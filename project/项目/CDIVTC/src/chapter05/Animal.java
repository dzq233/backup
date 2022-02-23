package chapter05;

public class Animal {
	public Animal() {
		System.out.println("父类无参构造");
	}
	public Animal(String name) {
		System.out.println("父类有参构造");
		System.out.println("名字:"+name);
	}
}
