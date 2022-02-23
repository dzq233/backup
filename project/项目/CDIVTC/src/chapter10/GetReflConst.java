package chapter10;

import java.lang.reflect.Constructor;

/*
 * ͨ�������ȡ���췽��
 */
public class GetReflConst {

	public static void main(String[] args) throws Exception {
		//��ȡ�ֽ����ļ�
		Class c = Class.forName("chapter11.Animal");
		//��ȥ����public���췽��
		Constructor[] cons1 = c.getConstructors();
		for(Constructor i:cons1) {
			System.out.println(i);
		}
		//��ȡ���й��췽��
		Constructor[] cons2 = c.getDeclaredConstructors();
		for(Constructor i:cons2) {
			System.out.println(i);
		}
		//��ȡ�����޲ι��췽��
		Constructor cons3 = c.getConstructor();
		Object obj1 = cons3.newInstance();
		System.out.println(obj1);
	}

}
