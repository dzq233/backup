package chapter03;

public class arr {
	public static void main(String[] args){
		int[]a = new int[]{2,1,5};//创建一个数组对象
		
		//System.out.println(a[0]);
		//System.out.println(a[1]);
		//for(int i=0;i<a.length;i++) {
	//		//传统for循环
		//	System.out.println(a[i]);
		//}
		//增强型for循环
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		System.out.println("sum="+sum);
		for(int i:a) {
			System.out.println(i);
		}
	}
}
