package gps;



//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xsm48563 on 2017/10/31.
 * ͼ��ר����
 */
public class MapUtil {
	 
	 
	 
	 
    /**
     * ������Ͷ���Σ��жϸ����ĵ��Ƿ��ڶ������
     * @param point
     * @param points
     * @return
     */
    public static boolean isPointInPolygon(Point point, List<Point> points) {


        boolean result = false;
        int intersectCount = 0;
        // �ж����ݣ����Ӹõ����ҷ�����ˮƽ�����������θ��ߵĽ��㣬��������Ϊ�����������ڲ�
        //����Ҫע�⼸�����������1�����ڱ߻��߶�����;2�����ڱߵ��ӳ�����;3���������ˮƽ�����������ཻ�ڶ�����
        /**
         * ���岽�����£�
         * ѭ�����������߶Σ�
         *  1���жϵ��Ƿ��ڵ�ǰ����(б����ͬ,�Ҹõ��xֵ�������˿ڵ�xֵ֮��),�����򷵻�true
         *  2�������ж��ɸõ㷢����ˮƽ�����Ƿ��뵱ǰ���ཻ,�����ཻ��continue
         *  3�����ཻ,���ж��Ƿ��ཻ�ڶ�����(�ߵĶ˵��Ƿ��ڸ������ˮƽ�Ҳ�).������,����Ϊ�˴��ཻΪ��Խ,������+1 ��continue
         *  4�������ڶ�����,���ж���һ���ߵ�����һ���˵��뵱ǰ�ߵ�����һ���˵��Ƿ�ֲ���ˮƽ���ߵ�����.��������Ϊ�˴��ཻΪ��Խ,������+1.
         */
        for (int i = 0; i < points.size(); i++) {
            Point pointA = points.get(i);
            Point pointB = null;
            Point pointPre = null;
            //����ǰ�ǵ�һ����,����һ������list��������һ����
            if (i == 0) {
                pointPre = points.get(points.size() - 1);
            } else {
                pointPre = points.get(i - 1);
            }
            //���Ѿ�ѭ�������һ����,����֮���ӵ��ǵ�һ����
            if (i == (points.size() - 1)) {
                pointB = points.get(0);
            } else {
                pointB = points.get(i + 1);
            }
            Line line = new Line(pointA, pointB);
            //1���жϵ��Ƿ��ڵ�ǰ����(б����ͬ,�Ҹõ��xֵ�������˿ڵ�xֵ֮��),�����򷵻�true
            boolean isAtLine = line.isContainsPoint(point);
            if (isAtLine) {
                return true;
            } else {
            	
                //2�������ڱ���,�ж��ɸõ㷢����ˮƽ�����Ƿ��뵱ǰ���ཻ,�����ཻ��continue
                //���ø����ߵ�����һ���˵��xֵ=999,��֤�ߵ�x��Զ������
                Point  radialPoint = new Point(999d, point.Y);
                Line radial = new Line(point, radialPoint);
                boolean isIntersect = radial.isIntersect(line);
//                System.out.print(radial.toString());
//                System.out.println(line.toString());
                if (!isIntersect) {
                    continue;
                } else {
//                	System.out.print("jiao");
                    //3�����ཻ,���ж��Ƿ��ཻ�ڶ�����(�ߵĶ˵��Ƿ��ڸ������ˮƽ�Ҳ�).������,����Ϊ�˴��ཻΪ��Խ,������+1 ��continue
                    if (!( (pointA.X > point.X) && (pointA.Y.equals(point.Y))
                            || (pointB.X > point.X) && (pointB.Y.equals(point.Y)) )) {
                        intersectCount++;
                        continue;
                    } else {
                        //4�������ڶ�����,���ж���һ���ߵ�����һ���˵��뵱ǰ�ߵ�����һ���˵��Ƿ�ֲ���ˮƽ���ߵ�����.��������Ϊ�˴��ཻΪ��Խ,������+1
                        if ((pointPre.Y - point.Y) * (pointB.Y - point.Y) < 0) {
                            intersectCount++;
                        }
                    }
//                	intersectCount++;
                }
            }
        }
        System.out.print(intersectCount);
        result = intersectCount % 2 == 1;
        return result;
    }




//    public static void main(String[] args) {
//
//
//        Point point11 = new Point(1.0, 1.0);
//        Point point22 = new Point(10.0, 1.0);
//        Point point33 = new Point(10d, 10d);
//        Point point44 = new Point(1.0, 10.0);
////        Point point55 = new Point(5d, 1d);
////        Point point66 = new Point(3d, 0d);
//        List<Point> points = new ArrayList<>();
//        points.add(point11);
//        points.add(point22);
//        points.add(point33);
//        points.add(point44);
////        points.add(point55);
////        points.add(point66);
//        Point test=null;
//        for(double i=0;i<12;i+=0.5)
//        	for(double j=0;j<12;j+=0.5) {
//        		 test = new Point((double)i,(double) j);
//        		 System.out.print(i);
//        		 System.out.print(" ");
//        		 System.out.print(j);
//        		 System.out.print(" ");
//        	     System.out.println(isPointInPolygon(test, points));
//
//        	}
//       
//    }
}