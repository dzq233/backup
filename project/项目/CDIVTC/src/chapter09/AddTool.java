package chapter09;

import java.util.LinkedList;

public class AddTool {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.add("����");
		l1.add("����");
		l1.addFirst("����");
		//System.out.println(l1);
		Tool.info(l1);
	}

}
