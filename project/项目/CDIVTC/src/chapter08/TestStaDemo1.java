package chapter08;

public class TestStaDemo1 {
	public static void main(String[] args) {
		StaOuterDemo1.Inner4 i4 = new StaOuterDemo1.Inner4();
		System.out.println(i4.a);
		System.out.println(i4.b);
		System.out.println(StaOuterDemo1.Inner4.b);
	}

}
