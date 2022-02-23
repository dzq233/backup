package chapter08;

public class Test {
	public static void main(String[] args) {
		OuterInDemo1.Inner1 i2 = new OuterInDemo1().new Inner1();
		System.out.println(i2.sum(3, 5));
	}
	
}
