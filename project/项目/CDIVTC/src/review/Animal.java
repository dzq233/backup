package review;

public class Animal {
	int age;
	String name;
	public Animal() {
		System.out.println("�޲ι���");
	}
	public Animal(int age,String name) {
		this.name = name;
		this.age = age;
		System.out.println("�вι���");
	}
	public String info () {
		return "����: "+this.name +" ����:"+ this.age;
	}
	public static void main(String[] args) {
		Animal t1 = new Animal();
		t1.name = "zhangsan";
		t1.age = 2;
		System.out.println(t1.info());
		Animal t2 = new Animal(19,"lisi");
		System.out.println(t2.info());
	}

}
