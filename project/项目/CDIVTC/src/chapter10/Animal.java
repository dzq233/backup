package chapter10;

public class Animal {
	public String name;
	private int age;
	String sex;
	//���幹�췽��
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
	//�����Ա����
	public void show() {
		System.out.println("show");
	}
	public void eat(String s) {
		System.out.println("eat"+s);
	}
	public String info(String name,int age) {
		return name+":"+age+"��";
	}
	private  void pFun() {
		System.out.println("˽�л�����");
	}

}
