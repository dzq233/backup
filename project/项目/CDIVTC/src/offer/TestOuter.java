package offer;

public class TestOuter {
	public static void main(String[] args) {
		OuterDemo.Inner1 i1 = new OuterDemo().new Inner1();
		System.out.println(i1.sum(2, 4));
	}

}
