package chapter03;

public class arr {
	public static void main(String[] args){
		int[]a = new int[]{2,1,5};//����һ���������
		
		//System.out.println(a[0]);
		//System.out.println(a[1]);
		//for(int i=0;i<a.length;i++) {
	//		//��ͳforѭ��
		//	System.out.println(a[i]);
		//}
		//��ǿ��forѭ��
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
