package chapter05;
//父类
public class Person {
	private String name;
	private int age;
	public int height;
	public Person() {
		System.out.println("父亲无参构造");
	}
	public Person(String name,int age) {
		this.setAge(age);
		this.setName(name);
		System.out.println("父类有参构造");
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
		String str ="人都要吃米";
		return str;
	}
}
