package chapter08;

public class StaOuterDemo1 {
	/*
	 * ���е�public��ʾ������Ա��κ��ⲿ��ʹ��
	 * ���ȥ��public��Ϊprotected,��ֻ�ܱ�ͬ���е���ʹ��
	 */
	static class Inner4{
		int a = 100;
		static int b = 200;
	}
	public static void main(String[] args) {
		Inner4 i4 = new Inner4();
	}

}
