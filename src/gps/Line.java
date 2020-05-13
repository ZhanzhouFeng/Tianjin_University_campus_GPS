package gps;
import java.math.BigDecimal;


/**
 * Created by xsm48563 on 2017/10/31.
 * 线
 */
public class Line {


    @Override
	public String toString() {
		return "Line [POINTA=" + POINTA + ", POINTB=" + POINTB + "]";
	}


	/**
     * 端点1
     */
    public Point POINTA;


    /**
     * 端点2
     */
    public Point POINTB;


    Line(Point pointA, Point pointB) {


        this.POINTA = pointA;
        this.POINTB = pointB;
    }


    /**
     * 判断当前线段是否包含给定的点</br>
     * 即给定的点是否在当前边上
     * @param point
     * @return
     */
    public boolean isContainsPoint(Point point) {


        boolean result = false;
        //判断给定点point与端点1构成线段的斜率是否和当前线段的斜率相同
        //给定点point与端点1构成线段的斜率k1
        Double k1 = null;
        if (point.X.equals(this.POINTA.X)) {
            k1 = Double.NEGATIVE_INFINITY;
        } else {
            k1 = div(sub(point.Y, this.POINTA.Y), sub(point.X, this.POINTA.X));
        }
        //当前线段的斜率k2
        Double k2 = null;
        if (this.POINTB.X.equals(this.POINTA.X)) {
            k2 = Double.NEGATIVE_INFINITY;
        } else {
            k2 = div(sub(this.POINTB.Y, this.POINTA.Y), sub(this.POINTB.X, this.POINTA.X));
        }
        if (k1 != null && k2 != null) {
            if (k1.equals(k2)) {
                //若斜率相同，继续判断给定点point的x是否在pointA.x和pointB.x之间,若在 则说明该点在当前边上
                if (sub(point.X, this.POINTA.X) * sub(point.X, this.POINTB.X) < 0) {
                    result = true;
                }
            }
        }
        return result;
    }


    //叉积
    double mult(Point a, Point b, Point c) {
        return (a.X-c.X)*(b.Y-c.Y)-(b.X-c.X)*(a.Y-c.Y);
    }


    /**
     * 给定线段是否与当前线段相交</br>
     * 相交返回true, 不相交返回false
     * @param line
     * @return
     */
    public boolean
    isIntersect(Line line) {


        Point a = this.POINTA;
        Point b = this.POINTB;
        Point c = line.POINTA;
        Point d = line.POINTB;
//        if (Math.max(aa.X, bb.X) < Math.min(cc.X, dd.X)) {
//            return false;
//        }
//        if (Math.max(aa.Y, bb.Y) < Math.min(cc.Y, dd.Y)) {
//            return false;
//        }
//        if (Math.max(cc.X, dd.X) < Math.min(aa.X, bb.X)) {
//            return false;
//        }
//        if (Math.max(cc.Y, dd.Y) < Math.min(aa.Y, bb.Y)) {
//            return false;
//        }
//        if (mult(cc, bb, aa) * mult(bb, dd, aa) < 0 ) {
//            return false;
//        }
//        if ( mult(aa, dd, cc) * mult(dd, bb, cc) < 0 ) {
//            return false;
//        }
//        return true;
        if(!(Math.min(a.X,b.X)<=Math.max(c.X,d.X) && Math.min(c.Y,d.Y)<=Math.max(a.Y,b.Y)&&Math.min(c.X,d.X)<=Math.max(a.X,b.X) && Math.min(a.Y,b.Y)<=Math.max(c.Y,d.Y)))//这里的确如此，这一步是判定两矩形是否相交
            //1.线段ab的低点低于cd的最高点（可能重合） 2.cd的最左端小于ab的最右端（可能重合）
            //3.cd的最低点低于ab的最高点（加上条件1，两线段在竖直方向上重合） 4.ab的最左端小于cd的最右端（加上条件2，两直线在水平方向上重合）
            //综上4个条件，两条线段组成的矩形是重合的
            /*特别要注意一个矩形含于另一个矩形之内的情况*/
            return false;
            /*
            跨立实验：
            如果两条线段相交，那么必须跨立，就是以一条线段为标准，另一条线段的两端点一定在这条线段的两段
            也就是说a b两点在线段cd的两端，c d两点在线段ab的两端
            */
         double u,v,w,z;//分别记录两个向量
         u=(c.X-a.X)*(b.Y-a.Y)-(b.X-a.X)*(c.Y-a.Y);
            v=(d.X-a.X)*(b.Y-a.Y)-(b.X-a.X)*(d.Y-a.Y);
            w=(a.X-c.X)*(d.Y-c.Y)-(d.X-c.X)*(a.Y-c.Y);
            z=(b.X-c.X)*(d.Y-c.Y)-(d.X-c.X)*(b.Y-c.Y);
            return (u*v<=0.00000001 && w*z<=0.00000001);
    }


    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }


    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }


    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }


    private static final int DEF_DIV_SCALE = 10;


    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }


    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

