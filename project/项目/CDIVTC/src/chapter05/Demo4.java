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
			System.out.println("���䲻�Ϸ�");
		}else {
			this.age = age;
		}
		
	}
	//��Ϣ�����������
	public String info() {
		String str = "����"+this.name+"����"+this.age;
		return str;
	}
}
