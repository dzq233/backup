package offer;

public class TestAnimal {
	public static void main(String[] args) {
		Animal a1 = new Animal() {
			public void shout() {
				System.out.println("������");
			}
		};
		a1.shout();
	}

}
