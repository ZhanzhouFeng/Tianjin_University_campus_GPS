package gps;

public class Point {
	 
	 
    /**
     * ˮƽ����ֵ/����
     */
    public Double X;
    /**
     * ��ֱ����ֵ/γ��
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


        // ���Ϊͬһ����Ĳ�ͬ����,����ͬ
        if (this == obj) {
            return true;
        }
        // �������Ķ���Ϊ��,�򷵻�false
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
