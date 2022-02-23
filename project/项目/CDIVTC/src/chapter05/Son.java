package chapter05;

public class Son extends Person {
	private String school;
	public String getSchool() {
		return school;
		
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String eat() {
	return super.eat();
		
		//方法的重写
	}
	public String info() {
		return "姓名:"+ this.getName()+",年龄:"+this.getAge()+",学校:"+this.getSchool();
	}
}
