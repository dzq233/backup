package chapter04;

public class ThisDemo {
	String name;
	public ThisDemo(String name) {
		this();
		this.name = name;
		
	}
	public ThisDemo() {
		System.out.println("无参构造");
	}
	public static void main(String[] args) {
		ThisDemo t1 = new ThisDemo("张三");
		System.out.println(t1.name);
		
	}
}
