package chapter08;

public class OuterInDemo1 {
	public class Inner1{
		public int sum(int a, int b) {
			return a + b;
		}
		
	}
	//���ⲿ���п���ֱ�Ӵ����ڲ����ʵ����
	Inner1 i1 = new Inner1();
	public void info() {
		Inner1 i3 = new Inner1();
	}
	public static void menu() {
		Inner1 i4 = new OuterInDemo1().new Inner1();
	}
	//��̬�����д����ڲ����ʵ�������󣬱���ͨ���ⲿ��ʵ�������󴴽�
	public static void main(String[] args) {
		Inner1 i2 = new OuterInDemo1().new Inner1();
		System.out.println(i2.sum(2, 3));
	}

}
