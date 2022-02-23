package chapter08;

public class StaOuterDemo1 {
	/*
	 * 类中的public表示该类可以被任何外部类使用
	 * 如果去掉public则为protected,则只能被同包中的类使用
	 */
	static class Inner4{
		int a = 100;
		static int b = 200;
	}
	public static void main(String[] args) {
		Inner4 i4 = new Inner4();
	}

}
