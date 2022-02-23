package chapter03;

public class TestCat {
	private String name;
	private int age;
	public TestCat(String name,int age) {
		this.setName(name);
		this.setAge(age);
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
		if(age<=0) {
			System.out.println("输入不正确");
		}
		this.age = age;
	}
	
}
