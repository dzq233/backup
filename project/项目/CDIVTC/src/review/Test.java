package review;

public class Test {
	String name;
	//�ֶ������޲ι���
	public Test() {
		System.out.println("�޲ι���");
	}
	//�����вι���
	public Test(String name) {
		this.name = name;
		System.out.println("�вι���");
	}
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test("����");
		System.out.println(t2.name);
	}
}
