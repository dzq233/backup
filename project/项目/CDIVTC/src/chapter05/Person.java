package chapter05;
//����
public class Person {
	private String name;
	private int age;
	public int height;
	public Person() {
		System.out.println("�����޲ι���");
	}
	public Person(String name,int age) {
		this.setAge(age);
		this.setName(name);
		System.out.println("�����вι���");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String eat() {
		String str ="�˶�Ҫ����";
		return str;
	}
}
