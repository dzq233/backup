package chapter07;

public class TestFruit {
	
	public static void main(String[] args) {
		//Fruit f = new Fruit();抽象类不能对象实例化
		Fruit f1 = new Apple();//向上转型
		f1.eat();
	}

}
