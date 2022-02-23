package util;
//判断用户名和密码是否为空
public class JudgeMent {
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
			
		}else {
			return false;
		}
	}
}
