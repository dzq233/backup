package review;

public class People {
	private String name;
	private int age;
	public People(String name,int age) {
		
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
		if(age>0) {
			this.age = age;
		}
		else {
			this.age = 18;
		}
	}
}
