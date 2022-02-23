package chapter08;

public class OuterInDemo3 {
	int a = 10;
	static int b = 20;
	
	public class Inner3{
		int a = 100;
		int aa = a;//ÒþÊ½µÄthis.a
		int aaa = OuterInDemo3.this.a;
		int b = 200;
		int bb = b;
	}
	public static void main(String[] args) {
		Inner3 i3 = new OuterInDemo3().new Inner3();
		System.out.println(i3.a);
	}
}
