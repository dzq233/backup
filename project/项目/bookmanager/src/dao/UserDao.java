package dao;
/*
 * 用户登录验证
 */
import java.sql.Connection;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
	public User login(User User,Connection con)throws SQLException {
		User resultUser = null;
		//定义查询语句
		String sql = "select * from t_user where username=? and password=?";
		//定义peparedStatments对象对SQL语句进行预编译，以提高安全性和执行效率
		PreparedStatement pt = con.prepareStatement(sql);
		//设置？参数为用户输入的值
		pt.setString(1, User.getUseName());//用户名
		pt.setString(2, User.getPassWord());//密码
		//返回记录值
		ResultSet rs = pt.executeQuery();
		//判断记录集中是否有数据
		if(rs.next()){
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUseName(rs.getString("Username"));
			resultUser.setPassWord(rs.getString("password"));
			
		}
		return resultUser;
	}
}
