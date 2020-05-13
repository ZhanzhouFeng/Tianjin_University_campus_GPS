package gps;

import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// // TODO Auto-generated method stub
		// File file = null;
		// // 读取数组
		//
		// file = new File("test");
		//
		// BufferedReader reader = null;
		// String temp = null;
		// int line = 0;
		//
		// try {
		// reader = new BufferedReader(new FileReader(file));
		// // line为数组的纵轴
		// while ((temp = reader.readLine()) != null) {
		// String[] s = temp.split(",");
		// for (String a : s) {
		// double t = Double.valueOf(a.toString());
		// System.out.println(a);
		// }
		//
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		String[] building_name = { "青年教师公寓-教师公寓食堂", "综合体育馆-校医院", "行政服务中心", "工会-教职工服务中心", "31教学楼", "32教学楼", "33教学楼",
				"北洋广场", "东门", "体育公园", "34教学楼", "51、52、53、54教学组团", "50教学楼", "第二学生食堂", "49教学楼", "48教学楼", "47教学楼", "37教学楼",
				"35、36教学组团", "留园", "格园-留学生食堂", "知园-第六学生食堂-第一学生食堂", "诚园", "正园", "46教学楼", "45教学楼", "修园", "齐园", "第四学生食堂",
				"39、38教学组团", "55教学楼", "信网中心-能源站", "郑东图书馆", "44教学楼", "43教学楼", "42、41、40教学组团", "北门", "平园", "第三学生食堂",
				"第五学生食堂", "治园", "南门", "学生中心-太雷广场", "青年湖西岸", "至善北路-博文北路", "侯德榜路-博文北路", "至善东道-侯德榜路", "亲民北道-博文北路",
				"明德北道-博文北路", "亲民北道-敬业路", "敬业路-明德北道", "明德北道-兴学路", "明德南道-兴学路", "求是大道-博文中路", "明德南道-博文中路", "亲民南道-博文南路",
				"王正廷道-博文南路", "王正廷道-至善东道", "博文南路-至善南道", "至善北道-西沽北路", "侯德榜路-西沽北路", "亲民北道-西沽北路", "明德北道-西沽北路", "求是大道-西沽中路",
				"明德南道-西沽南路", "亲民南道-西沽南路", "至善南道-西沽南路", "至善北道-七星北路", "侯德榜路-七星北路", "亲民北道-七星北路", "明德北道-七星北路", "明德南道-七星南路",
				"亲民南道-七星南路", "至善南道-七星南路", "至善北道-新元北路", "亲民北道-新元北路", "双台北路-亲民北道", "明德北道-新元中路", "明德北道-双台中路", "明德南道-双台南路",
				"明德南道-新元南路", "亲民南道-新元南路", "亲民南道-双台南路", "至善南道-新元南路 ", "至善南道-双台南路", "英华道-西沽中路", "求是北道-西沽中路", "英华道-西沽中路",
				"求是北道-七星中路", "书田北道-双台中路", "书田北道-新元中路", "书田北道-双台中路", "书田南道-新元中路", "书田南道-七星中路", "求是南道-七星中路", "求是南道-西沽中路",
				"花堤道-七星中路", "花堤道-西沽中路", "花堤道-双台中路", "花堤道-新元中路", "求是大道-七星中路" };

		HashMap<String, Integer> match = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < building_name.length; i++) {
			// 匹配地名和编号
			match.put(building_name[i], i);
			// System.out.println(i+" "+building_name[i]);
		}

		while (true) {
			String s = sc.nextLine();
			System.out.println(match.get(s));
		}
	}

	

}
