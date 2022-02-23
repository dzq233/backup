package review;

public class Test {
	String name;
	//手动创建无参构造
	public Test() {
		System.out.println("无参构造");
	}
	//创建有参构造
	public Test(String name) {
		this.name = name;
		System.out.println("有参构造");
	}
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test("张三");
		System.out.println(t2.name);
	}
}
