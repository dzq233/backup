package chapter07;

public class Square extends Shape {
	public Square(int chang,int kuan) {
		super(chang,kuan);
	}

	
	public int area() {

		return this.chang * this.kuan;
	}

}
