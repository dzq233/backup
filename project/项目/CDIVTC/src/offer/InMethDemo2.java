package offer;

public class InMethDemo2 {
	int x;
	int a = 100;
	int b = 200;
	public void info() {
		int c;
		int d = 300;//��ʽ�ļ��� final
		int b = 400;
		class Inner4{
			//int cc = c;���ܷ��ʷ����еı���
			int dd = d;
			int aa = a;
			int xx = x;//���Է����ⲿ���еı���
			int bb = b;//���ʷ����е�ͬ������
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
