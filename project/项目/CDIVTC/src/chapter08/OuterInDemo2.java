package chapter08;

public class OuterInDemo2 {
	int a = 100;
	final int b = 200;
	private int c = 300;
	static int d = 400;
	
	public String info() {
		return "∆’Õ®∑Ω∑®";
	}
	public class Inner2{
		int aa = a;
		String str = info();
	}
	public static void main(String[] args) {
		Inner2 i2 = new OuterInDemo2().new Inner2();
		System.out.println(i2.aa);
		System.out.println(i2.str);
	}

}
