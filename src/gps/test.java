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
		// // ��ȡ����
		//
		// file = new File("test");
		//
		// BufferedReader reader = null;
		// String temp = null;
		// int line = 0;
		//
		// try {
		// reader = new BufferedReader(new FileReader(file));
		// // lineΪ���������
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
		String[] building_name = { "�����ʦ��Ԣ-��ʦ��Ԣʳ��", "�ۺ�������-УҽԺ", "������������", "����-��ְ����������", "31��ѧ¥", "32��ѧ¥", "33��ѧ¥",
				"����㳡", "����", "������԰", "34��ѧ¥", "51��52��53��54��ѧ����", "50��ѧ¥", "�ڶ�ѧ��ʳ��", "49��ѧ¥", "48��ѧ¥", "47��ѧ¥", "37��ѧ¥",
				"35��36��ѧ����", "��԰", "��԰-��ѧ��ʳ��", "֪԰-����ѧ��ʳ��-��һѧ��ʳ��", "��԰", "��԰", "46��ѧ¥", "45��ѧ¥", "��԰", "��԰", "����ѧ��ʳ��",
				"39��38��ѧ����", "55��ѧ¥", "��������-��Դվ", "֣��ͼ���", "44��ѧ¥", "43��ѧ¥", "42��41��40��ѧ����", "����", "ƽ԰", "����ѧ��ʳ��",
				"����ѧ��ʳ��", "��԰", "����", "ѧ������-̫�׹㳡", "���������", "���Ʊ�·-���ı�·", "��°�·-���ı�·", "���ƶ���-��°�·", "���񱱵�-���ı�·",
				"���±���-���ı�·", "���񱱵�-��ҵ·", "��ҵ·-���±���", "���±���-��ѧ·", "�����ϵ�-��ѧ·", "���Ǵ��-������·", "�����ϵ�-������·", "�����ϵ�-������·",
				"����͢��-������·", "����͢��-���ƶ���", "������·-�����ϵ�", "���Ʊ���-������·", "��°�·-������·", "���񱱵�-������·", "���±���-������·", "���Ǵ��-������·",
				"�����ϵ�-������·", "�����ϵ�-������·", "�����ϵ�-������·", "���Ʊ���-���Ǳ�·", "��°�·-���Ǳ�·", "���񱱵�-���Ǳ�·", "���±���-���Ǳ�·", "�����ϵ�-������·",
				"�����ϵ�-������·", "�����ϵ�-������·", "���Ʊ���-��Ԫ��·", "���񱱵�-��Ԫ��·", "˫̨��·-���񱱵�", "���±���-��Ԫ��·", "���±���-˫̨��·", "�����ϵ�-˫̨��·",
				"�����ϵ�-��Ԫ��·", "�����ϵ�-��Ԫ��·", "�����ϵ�-˫̨��·", "�����ϵ�-��Ԫ��· ", "�����ϵ�-˫̨��·", "Ӣ����-������·", "���Ǳ���-������·", "Ӣ����-������·",
				"���Ǳ���-������·", "���ﱱ��-˫̨��·", "���ﱱ��-��Ԫ��·", "���ﱱ��-˫̨��·", "�����ϵ�-��Ԫ��·", "�����ϵ�-������·", "�����ϵ�-������·", "�����ϵ�-������·",
				"���̵�-������·", "���̵�-������·", "���̵�-˫̨��·", "���̵�-��Ԫ��·", "���Ǵ��-������·" };

		HashMap<String, Integer> match = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < building_name.length; i++) {
			// ƥ������ͱ��
			match.put(building_name[i], i);
			// System.out.println(i+" "+building_name[i]);
		}

		while (true) {
			String s = sc.nextLine();
			System.out.println(match.get(s));
		}
	}

	

}
