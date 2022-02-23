package chapter05;

public class Demo2 {
	String name;
	int age;
	
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.age = 99999;
		t1.name = "Сè";
		System.out.println(t1.name+t1.age);
	}

}
