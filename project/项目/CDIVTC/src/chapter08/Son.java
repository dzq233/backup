package chapter08;

public class Son {
	class Son1 extends Father1{
		public int year() {
			return super.year()+1;
		}
	}
	class Son2 extends Father2{
		public int year() {
			return super.year()+1;
		}
	}
	public int getFa1() {
		return new Son1().year();
	}
	public int getFa2() {
		return new Son2().year();
	}

}
