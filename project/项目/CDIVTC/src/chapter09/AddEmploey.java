package chapter09;

import java.util.ArrayList;
import java.util.Iterator;

public class AddEmploey {
	public static void info(ArrayList a) {
		//��ǿ��ѭ������
		for(Object i:a) {
			System.out.print(i+" ");
		}
		//����������
		Iterator it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
	}

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList();
		a1.add("����");
		a1.add("����");
		//System.out.println(a1);
		
		a1.add("wanwu");
		a1.remove("����");
		a1.set(1, "����");
		AddEmploey.info(a1);
		
		System.out.println(a1.indexOf("����"));
	}
}
