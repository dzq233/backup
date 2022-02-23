package chapter10;

public class Animal {
	public String name;
	private int age;
	String sex;
	//定义构造方法
	public Animal() {
		
	}
	private Animal(String name) {
		this.name = name;
	}
	Animal(String name,int age){
		this.name = name;
		this.age = age;
	}
	public Animal(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	//定义成员方法
	public void show() {
		System.out.println("show");
	}
	public void eat(String s) {
		System.out.println("eat"+s);
	}
	public String info(String name,int age) {
		return name+":"+age+"岁";
	}
	private  void pFun() {
		System.out.println("私有化方法");
	}

}
