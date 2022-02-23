package chapter03;

import java.util.Scanner;

public class FindArr {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		int[] a = { 8, 2, 7, 6, 3 };
		boolean flag = true;
		int find = scan.nextInt();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == find) {
				System.out.println("找到了，在第" + (i + 1) + "个");
				flag = false;
				break;
			}

		}
		if (flag) {
			System.out.println("没找到");
		}
	}

}
