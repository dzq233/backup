package chapter05;

public class Test2 {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<=0) {
			System.out.println("ÊäÈë´íÎó");
		}
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
