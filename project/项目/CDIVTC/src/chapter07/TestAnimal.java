package chapter07;

public class TestAnimal {
	
	public static void main(String[] args) {
		Animal t1 = new cat();
		Animal t2 = new dog();
		Animal t = new Animal();
		t1.shout();
		t2.shout();
	}

}
