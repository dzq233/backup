package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * ���ݿ⹤���࣬���ڼ������ݿ��������������ݿ�������Ϣ
 */
public class DbUtil {
	private static String dbUr1="jdbc:mysql://localhost:3306/db_book";//���������ݿ�����
	private static String dbUserName="root";//�û�
	private static String dbPassWord="dzq200216";//����
	private static String jdbcName="com.mysql.jdbc.Driver";//��������
	/*
	 * ����һ��������ΪConnection�ķ�������ȡ���ݿ�����
	 * ʹ��Connectionʱһ��Ҫע�⵼�����ô�����ctrl+shift+o��ѡ��java.sql.Connection
	 * @return
	 * @throws Exception
	 */
	
 public static Connection getCon() throws Exception{
		Class.forName(jdbcName);//ͨ�������ȡ�������ƣ��������ݿ���������ʼ��
		Connection con=DriverManager.getConnection(dbUr1, dbUserName, dbPassWord);
		return con;
	}
	
	/*
	 * �ر����ݿ����ӣ���Ȼ���Զ����ջ��ƣ���Connection�Ƚ�ռ��ԴӦ�����ر�
	 * @throws SQLException
	 */
	public static void closeCon(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil db=new DbUtil();
		try {
			db.getCon();
			System.out.println("�������ݿ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
