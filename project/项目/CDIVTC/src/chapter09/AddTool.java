package chapter09;

import java.util.LinkedList;

public class AddTool {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add("张三");
		l1.add("李四");
		l1.addFirst("王五");
		//System.out.println(l1);
		Tool.info(l1);
	}

}
