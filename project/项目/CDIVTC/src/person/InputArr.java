package person;
import java.util.Scanner;
public class InputArr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SumArr sum =new SumArr();
		int []arr = new int[3];
		for(int i = 0;i<arr.length;i++) {
			System.out.println("�����"+(i+1)+"����:");
			arr[i] = sc.nextInt();
		}
		int sumarr = sum.sumarr(arr);
		System.out.println("��Ϊ:"+sumarr);
	}
	

}
