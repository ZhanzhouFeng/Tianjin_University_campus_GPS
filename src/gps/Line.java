package gps;
import java.math.BigDecimal;


/**
 * Created by xsm48563 on 2017/10/31.
 * ��
 */
public class Line {


    @Override
	public String toString() {
		return "Line [POINTA=" + POINTA + ", POINTB=" + POINTB + "]";
	}


	/**
     * �˵�1
     */
    public Point POINTA;


    /**
     * �˵�2
     */
    public Point POINTB;


    Line(Point pointA, Point pointB) {


        this.POINTA = pointA;
        this.POINTB = pointB;
    }


    /**
     * �жϵ�ǰ�߶��Ƿ���������ĵ�</br>
     * �������ĵ��Ƿ��ڵ�ǰ����
     * @param point
     * @return
     */
    public boolean isContainsPoint(Point point) {


        boolean result = false;
        //�жϸ�����point��˵�1�����߶ε�б���Ƿ�͵�ǰ�߶ε�б����ͬ
        //������point��˵�1�����߶ε�б��k1
        Double k1 = null;
        if (point.X.equals(this.POINTA.X)) {
            k1 = Double.NEGATIVE_INFINITY;
        } else {
            k1 = div(sub(point.Y, this.POINTA.Y), sub(point.X, this.POINTA.X));
        }
        //��ǰ�߶ε�б��k2
        Double k2 = null;
        if (this.POINTB.X.equals(this.POINTA.X)) {
            k2 = Double.NEGATIVE_INFINITY;
        } else {
            k2 = div(sub(this.POINTB.Y, this.POINTA.Y), sub(this.POINTB.X, this.POINTA.X));
        }
        if (k1 != null && k2 != null) {
            if (k1.equals(k2)) {
                //��б����ͬ�������жϸ�����point��x�Ƿ���pointA.x��pointB.x֮��,���� ��˵���õ��ڵ�ǰ����
                if (sub(point.X, this.POINTA.X) * sub(point.X, this.POINTB.X) < 0) {
                    result = true;
                }
            }
        }
        return result;
    }


    //���
    double mult(Point a, Point b, Point c) {
        return (a.X-c.X)*(b.Y-c.Y)-(b.X-c.X)*(a.Y-c.Y);
    }


    /**
     * �����߶��Ƿ��뵱ǰ�߶��ཻ</br>
     * �ཻ����true, ���ཻ����false
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
        if(!(Math.min(a.X,b.X)<=Math.max(c.X,d.X) && Math.min(c.Y,d.Y)<=Math.max(a.Y,b.Y)&&Math.min(c.X,d.X)<=Math.max(a.X,b.X) && Math.min(a.Y,b.Y)<=Math.max(c.Y,d.Y)))//�����ȷ��ˣ���һ�����ж��������Ƿ��ཻ
            //1.�߶�ab�ĵ͵����cd����ߵ㣨�����غϣ� 2.cd�������С��ab�����Ҷˣ������غϣ�
            //3.cd����͵����ab����ߵ㣨��������1�����߶�����ֱ�������غϣ� 4.ab�������С��cd�����Ҷˣ���������2����ֱ����ˮƽ�������غϣ�
            //����4�������������߶���ɵľ������غϵ�
            /*�ر�Ҫע��һ�����κ�����һ������֮�ڵ����*/
            return false;
            /*
            ����ʵ�飺
            ��������߶��ཻ����ô���������������һ���߶�Ϊ��׼����һ���߶ε����˵�һ���������߶ε�����
            Ҳ����˵a b�������߶�cd�����ˣ�c d�������߶�ab������
            */
         double u,v,w,z;//�ֱ��¼��������
         u=(c.X-a.X)*(b.Y-a.Y)-(b.X-a.X)*(c.Y-a.Y);
            v=(d.X-a.X)*(b.Y-a.Y)-(b.X-a.X)*(d.Y-a.Y);
            w=(a.X-c.X)*(d.Y-c.Y)-(d.X-c.X)*(a.Y-c.Y);
            z=(b.X-c.X)*(d.Y-c.Y)-(d.X-c.X)*(b.Y-c.Y);
            return (u*v<=0.00000001 && w*z<=0.00000001);
    }


    /**
     * �ṩ��ȷ�ļӷ����㡣
     * @param v1 ������
     * @param v2 ����
     * @return ���������ĺ�
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }


    /**
     * �ṩ��ȷ�ļ������㡣
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ĳ�
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }


    /**
     * �ṩ��ȷ�ĳ˷����㡣
     * @param v1 ������
     * @param v2 ����
     * @return ���������Ļ�
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }


    private static final int DEF_DIV_SCALE = 10;


    /**
     * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��
     * С�����Ժ�10λ���Ժ�������������롣
     * @param v1 ������
     * @param v2 ����
     * @return ������������
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }


    /**
     * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ
     * �����ȣ��Ժ�������������롣
     * @param v1 ������
     * @param v2 ����
     * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
     * @return ������������
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

