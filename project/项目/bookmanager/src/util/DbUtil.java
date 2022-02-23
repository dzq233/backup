package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * 数据库工具类，用于加载数据库驱动、配置数据库连接信息
 */
public class DbUtil {
	private static String dbUr1="jdbc:mysql://localhost:3306/db_book";//主机和数据库名。
	private static String dbUserName="root";//用户
	private static String dbPassWord="dzq200216";//密码
	private static String jdbcName="com.mysql.jdbc.Driver";//驱动包名
	/*
	 * 创建一个返回类为Connection的方法，获取数据库连接
	 * 使用Connection时一定要注意导包不用错，可用ctrl+shift+o，选择java.sql.Connection
	 * @return
	 * @throws Exception
	 */
	
 public static Connection getCon() throws Exception{
		Class.forName(jdbcName);//通过反射获取驱动名称，加载数据库驱动并初始化
		Connection con=DriverManager.getConnection(dbUr1, dbUserName, dbPassWord);
		return con;
	}
	
	/*
	 * 关闭数据库连接，虽然有自动回收机制，但Connection比较占资源应主动关闭
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
			System.out.println("连接数据库成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
