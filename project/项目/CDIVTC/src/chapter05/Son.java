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
		
		//��������д
	}
	public String info() {
		return "����:"+ this.getName()+",����:"+this.getAge()+",ѧУ:"+this.getSchool();
	}
}
