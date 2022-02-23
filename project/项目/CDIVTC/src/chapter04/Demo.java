package chapter04;

public class Demo {
	public Demo(int a) {
		System.out.println("有参");
	}
	public Demo() {
		System.out.println("无参");
	}
	public static void main(String[] args) {
		Demo c1 = new Demo();
		Demo c2 = new Demo();
		
	}
}
