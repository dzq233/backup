package chapter04;

public class Plus {
	public int info(int a,int b) {
		int sum;
		sum = a+b;
		return sum;
	}
	public double info(double a,double b) {
		double sum;
		sum = a+b;
		return sum;
	}
	public int info(int[] arr) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		Plus t1 = new Plus();
		System.out.println(t1.info(5,6));
		Plus t2 = new Plus();
		System.out.println(t2.info(5.55,6.66));
		Plus t3 = new Plus();
		int [] arr= new int[] {1,5,8,7};
		System.out.println(t3.info(arr));
	}
}
