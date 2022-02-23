package chapter05;
/**
 * 
 * @author dzq
 *
 */
public class Test {
String name;
int age;

	public Test() {
		
	}
	public Test(String name,int age) {
		this.name = name;
		this.age = age;
		System.out.println("有参");
	}
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.name="zhangsan";
		Test t2 = new Test("lisi",19);
		System.out.println(t2.name);
		/*
		 * 多行注释
		 */
	}
}
