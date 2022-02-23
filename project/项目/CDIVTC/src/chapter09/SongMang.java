package chapter09;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SongMang {
	//输出歌曲
	public static void show(LinkedList l1) {
		System.out.println("当前歌曲列表：");
		Iterator it=l1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	//添加歌曲
	public static void add(LinkedList l1) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入歌曲名称：");
		String name=sc.next();
		l1.add(name);
		System.out.println("已添加歌曲");
	}
	//置顶歌曲
	public static void top(LinkedList l1) {
		System.out.println("请输入要置顶的歌曲：");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int p=l1.indexOf(name);
		if(p==0) {
			System.out.println("已经排第一了");
		}
		else if(p<0) {
			System.out.println("找不到该歌曲");
		}
		else {
			l1.remove(p);
			l1.addFirst(name);
			System.out.println("歌曲已置顶");
		}
	}
	//前移一位
	public static void move(LinkedList l1) {
		System.out.println("请输入要置顶的歌曲：");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int p=l1.indexOf(name);
		if(p==0) {
			System.out.println("已经排第一了");
		}
		else if(p<0) {
			System.out.println("找不到该歌曲");
		}
		else {
			l1.remove(p);
			l1.add(p-1,name);
			System.out.println("歌曲已置顶");
		}
	}
	public static void exit() {
		System.out.println("已退出");
		System.exit(0);
	}
	public static void main(String[] args) {
		System.out.println("0.添加歌曲");
		System.out.println("1.将歌曲置顶");
		System.out.println("2.将歌曲前移一位");
		System.out.println("3.退出");
		LinkedList l1=new LinkedList();
		l1.add("中国人");
		l1.add("祝福祖国");
		while(true) {
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入菜单：");
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

