import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
    //声明四个全局变量
    String driver = "com.mysql.jdbc.Driver";
    //               协议 子协议 主机   端口    数据库名字
    String url = "jdbc:mysql://localhost:3306.xiangmu1-2?useSSL=false";
    String user = "root";
    String password = "dzq200216";

    //连接数据库的方法
    public Connection getConnetion_tom() throws Exception {
        Connection conn = null;
        Class.forName(driver);//反射的方式
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //关闭数据库的方法
    public void closeConnetion_tom(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {            e.printStackTrace();
        }
    }

    //测试一下数据库是否连接成功？
    public static void main(String[] args) {
        Dbutil dbutil = new Dbutil();
        Connection conn = null;
        try {
            conn = dbutil.getConnetion_tom();
            if (conn != null) {
                System.out.println("数据库连接成功！");
            }
        } catch (Exception e) {
            System.err.println("数据库连接失败！");
            e.printStackTrace();
        } finally {
            dbutil.closeConnetion_tom(conn);
        }
    }

}
