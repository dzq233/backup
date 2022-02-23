package chapter09;

import java.util.ArrayList;
import java.util.Iterator;

public class AddEmploey {
	public static void info(ArrayList a) {
		//增强型循环遍历
		for(Object i:a) {
			System.out.print(i+" ");
		}
		//迭代器遍历
		Iterator it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
	}

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("张三");
		a1.add("李四");
		//System.out.println(a1);
		
		a1.add("wanwu");
		a1.remove("张三");
		a1.set(1, "王五");
		AddEmploey.info(a1);
		
		System.out.println(a1.indexOf("张三"));
	}
}
