package offer;

public class InMethDemo2 {
	int x;
	int a = 100;
	int b = 200;
	public void info() {
		int c;
		int d = 300;//隐式的加了 final
		int b = 400;
		class Inner4{
			//int cc = c;不能访问方法中的变量
			int dd = d;
			int aa = a;
			int xx = x;//可以访问外部类中的变量
			int bb = b;//访问方法中的同名属性
			int bbb = InMethDemo2.this.b;
		}
		Inner4 i4 = new Inner4();
		System.out.println(i4.dd);
		System.out.println(i4.bbb);
	}
	public static void main(String[] args) {
		InMethDemo2 i = new InMethDemo2();
		i.info();
	}
}
