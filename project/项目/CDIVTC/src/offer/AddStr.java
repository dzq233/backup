package offer;

public class AddStr {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("���");
		System.out.println(s1.length());
		System.out.println("׷��: "+s1.append("���"));
		System.out.println(s1.length());
	}

}
