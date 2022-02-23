package offer;

public class TestStaDemo {
	public static void main(String[] args) {
		StaOuter1.Inner2 i1 = new StaOuter1.Inner2();
		System.out.println(i1.a);
		System.out.println(StaOuter1.Inner2.b);
	}

}
