package chapter04;

public class Test {
	public void info(int a) {
		System.out.println("����");
	}
	public void info(String a) {
		System.out.println("�ַ���");
	}
	public int info(int a,int b) {
		System.out.println();
	int sum;
	sum =a+b;
	return sum;
	}
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.info("hello");
		Test t2 = new Test();
		System.out.println(t2.info(5,6));
		
	}
}
