package offer;

public class DSAF {
	public static void main(String[] args) {
		String a = " a b c ";
		String b = "a bc";
		String c = "�� a����һ��ΰ��Ĺ���";
		System.out.println("����: "+a.length());
		System.out.println("c��λ��: "+a.indexOf('c'));
		System.out.println("��һ���ַ�: "+a.charAt(0));
		System.out.println("�滻: "+a.replace('a', 'A'));
		System.out.println("ɾ�ո�: "+a.trim());
		System.out.println("ɾ���ո�: "+a.replace(" ", ""));
		System.out.println("�Ƿ���a��ͷ: "+a.startsWith("a"));
		System.out.println("�Ƿ�Ϊ��: "+a.isEmpty());
		System.out.println("�Ƿ�����ո�: "+a.contains("c"));
		System.out.println("��ȡ: "+c.substring(4));
		System.out.println(c.substring(4,7));
	}

}
