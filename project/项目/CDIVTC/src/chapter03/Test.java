package chapter03;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("输入三个数:");
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		if(a > b) {
			int d = a;
			a = b;
			b = d;
		}
		if(a > c) {
			int d = a;
			a = c;
			c = d;
		}
		if(b > c) {
			int d = b;
			b = c;
			c = d;
		}
		System.out.println(a+"< "+b+"< "+c);
		
	}

}