package offer;

public class DSAF {
	public static void main(String[] args) {
		String a = " a b c ";
		String b = "a bc";
		String c = "中 a国是一个伟大的国家";
		System.out.println("长度: "+a.length());
		System.out.println("c的位置: "+a.indexOf('c'));
		System.out.println("第一个字符: "+a.charAt(0));
		System.out.println("替换: "+a.replace('a', 'A'));
		System.out.println("删空格: "+a.trim());
		System.out.println("删除空格: "+a.replace(" ", ""));
		System.out.println("是否已a开头: "+a.startsWith("a"));
		System.out.println("是否为空: "+a.isEmpty());
		System.out.println("是否包含空格: "+a.contains("c"));
		System.out.println("截取: "+c.substring(4));
		System.out.println(c.substring(4,7));
	}

}
