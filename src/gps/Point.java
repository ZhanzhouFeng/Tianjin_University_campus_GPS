package gps;

public class Point {
	 
	 
    /**
     * 水平方向值/经度
     */
    public Double X;
    /**
     * 垂直方向值/纬度
     */
    public Double Y;


    Point(Double x, Double y) {


        x = x == null ? 0:x;
        y = y == null ? 0:y;
        this.X = x;
        this.Y = y;
    }

    Point(int x, int y) {

        this.X = (double)x;
        this.Y = (double)y;
    }
    

    public boolean equals(Object obj) {


        // 如果为同一对象的不同引用,则相同
        if (this == obj) {
            return true;
        }
        // 如果传入的对象为空,则返回false
        if (obj == null) {
            return false;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            if (point.X.equals(this.X) && point.Y.equals(this.Y)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


	@Override
	public String toString() {
		return "Point [X=" + X + ", Y=" + Y + "]";
	}


//    public static void main(String[] args) {
//
//
//        Point A = new Point(1d, null);
//        Point B = new Point(null, 3d);
//        System.out.println(A.equals(B));
//    }
}
