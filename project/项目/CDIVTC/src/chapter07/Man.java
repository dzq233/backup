package chapter07;

public abstract class Man {
	int age;
	String name;
	public Man(String name,int age) {
		this.age = age;
		this.name = name;
	}
	public abstract String info();

}
