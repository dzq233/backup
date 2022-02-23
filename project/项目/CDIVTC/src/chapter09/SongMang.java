package chapter09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SongMang {
	//�������
	public static void show(LinkedList l1) {
		System.out.println("��ǰ�����б�");
		Iterator it=l1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	//��Ӹ���
	public static void add(LinkedList l1) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������������ƣ�");
		String name=sc.next();
		l1.add(name);
		System.out.println("����Ӹ���");
	}
	//�ö�����
	public static void top(LinkedList l1) {
		System.out.println("������Ҫ�ö��ĸ�����");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int p=l1.indexOf(name);
		if(p==0) {
			System.out.println("�Ѿ��ŵ�һ��");
		}
		else if(p<0) {
			System.out.println("�Ҳ����ø���");
		}
		else {
			l1.remove(p);
			l1.addFirst(name);
			System.out.println("�������ö�");
		}
	}
	//ǰ��һλ
	public static void move(LinkedList l1) {
		System.out.println("������Ҫ�ö��ĸ�����");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int p=l1.indexOf(name);
		if(p==0) {
			System.out.println("�Ѿ��ŵ�һ��");
		}
		else if(p<0) {
			System.out.println("�Ҳ����ø���");
		}
		else {
			l1.remove(p);
			l1.add(p-1,name);
			System.out.println("�������ö�");
		}
	}
	public static void exit() {
		System.out.println("���˳�");
		System.exit(0);
	}
	public static void main(String[] args) {
		System.out.println("0.��Ӹ���");
		System.out.println("1.�������ö�");
		System.out.println("2.������ǰ��һλ");
		System.out.println("3.�˳�");
		LinkedList l1=new LinkedList();
		l1.add("�й���");
		l1.add("ף�����");
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("������˵���");
			int n=sc.nextInt();
			switch(n) {
			case 0:
				SongMang.add(l1);
				break;
			case 1:
				SongMang.top(l1);
				break;
			case 2:
				SongMang.move(l1);
				break;
			case 3:
				SongMang.exit();
				break;
			}
			SongMang.show(l1);
		}

	}

}

