package chapter07;

public class stu extends Man {
	public stu(String name,int age) {
		super(name,age);
	}
	@Override
	public String info() {
		
		return "������"+this.name+",����:"+this.age;
	}

}
