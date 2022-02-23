package chapter03;

import java.util.Scanner;

public class Arr_Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[3];
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			if(max < arr[i]) {
				max = arr[i];
				
			}
			
		}
		System.out.println(max);
	}

}
