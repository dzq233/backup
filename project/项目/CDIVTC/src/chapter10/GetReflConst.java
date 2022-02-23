package chapter10;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取构造方法
 */
public class GetReflConst {

	public static void main(String[] args) throws Exception {
		//获取字节码文件
		Class c = Class.forName("chapter11.Animal");
		//过去所有public构造方法
		Constructor[] cons1 = c.getConstructors();
		for(Constructor i:cons1) {
			System.out.println(i);
		}
		//获取所有构造方法
		Constructor[] cons2 = c.getDeclaredConstructors();
		for(Constructor i:cons2) {
			System.out.println(i);
		}
		//获取单个无参构造方法
		Constructor cons3 = c.getConstructor();
		Object obj1 = cons3.newInstance();
		System.out.println(obj1);
	}

}
