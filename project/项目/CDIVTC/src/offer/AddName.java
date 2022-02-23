package offer;
import java.util.Scanner;
public class AddName {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("张三、李四");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名");
		String str = sc.next();
		s1.append(str);
	}

}
