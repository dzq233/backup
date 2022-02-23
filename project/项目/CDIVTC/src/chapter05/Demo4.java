package chapter05;

public class Demo4 {
	private String name;
	private int age;
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
			System.out.println("年龄不合法");
		}else {
			this.age = age;
		}
		
	}
	//信息返回输出方法
	public String info() {
		String str = "姓名"+this.name+"年龄"+this.age;
		return str;
	}
}
