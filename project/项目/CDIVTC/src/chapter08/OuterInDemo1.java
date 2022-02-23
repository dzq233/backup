package chapter08;

public class OuterInDemo1 {
	public class Inner1{
		public int sum(int a, int b) {
			return a + b;
		}
		
	}
	//在外部类中可以直接创建内部类的实例化
	Inner1 i1 = new Inner1();
	public void info() {
		Inner1 i3 = new Inner1();
	}
	public static void menu() {
		Inner1 i4 = new OuterInDemo1().new Inner1();
	}
	//静态方法中创建内部类的实例化对象，必须通过外部类实例化对象创建
	public static void main(String[] args) {
		Inner1 i2 = new OuterInDemo1().new Inner1();
		System.out.println(i2.sum(2, 3));
	}

}
