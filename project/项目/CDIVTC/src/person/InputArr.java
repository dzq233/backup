package person;
import java.util.Scanner;
public class InputArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SumArr sum =new SumArr();
		int []arr = new int[3];
		for(int i = 0;i<arr.length;i++) {
			System.out.println("输入第"+(i+1)+"个数:");
			arr[i] = sc.nextInt();
		}
		int sumarr = sum.sumarr(arr);
		System.out.println("和为:"+sumarr);
	}
	

}
