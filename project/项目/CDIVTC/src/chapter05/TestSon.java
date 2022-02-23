package chapter05;

public class TestSon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s1 = new Son();
		s1.setName("zhangsan");
		s1.setAge(20);
		s1.setSchool("¹¤Ö°Ôº");
		s1.info();
		s1.height = 170;
		System.out.println(s1.info());
		System.out.println(s1.eat());

	}

}
