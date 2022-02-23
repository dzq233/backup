package offer;

public class AddStr {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("ÄãºÃ");
		System.out.println(s1.length());
		System.out.println("×·¼Ó: "+s1.append("×æ¹ú"));
		System.out.println(s1.length());
	}

}
