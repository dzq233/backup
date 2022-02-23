package offer;

public class OuterDemo {
	public class Inner1{
		public int sum(int a,int b) {
			return a+b;
		}
	}
	public static void main(String[] args) {
		Inner1 i1 = new OuterDemo().new Inner1();
		System.out.println(i1.sum(5, 10));
	}

}
