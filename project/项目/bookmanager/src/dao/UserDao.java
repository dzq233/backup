package dao;
/*
 * �û���¼��֤
 */
import java.sql.Connection;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
	public User login(User User,Connection con)throws SQLException {
		User resultUser = null;
		//�����ѯ���
		String sql = "select * from t_user where username=? and password=?";
		//����peparedStatments�����SQL������Ԥ���룬����߰�ȫ�Ժ�ִ��Ч��
		PreparedStatement pt = con.prepareStatement(sql);
		//���ã�����Ϊ�û������ֵ
		pt.setString(1, User.getUseName());//�û���
		pt.setString(2, User.getPassWord());//����
		//���ؼ�¼ֵ
		ResultSet rs = pt.executeQuery();
		//�жϼ�¼�����Ƿ�������
		if(rs.next()){
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUseName(rs.getString("Username"));
			resultUser.setPassWord(rs.getString("password"));
			
		}
		return resultUser;
	}
}
