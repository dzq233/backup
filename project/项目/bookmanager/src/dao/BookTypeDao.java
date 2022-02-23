package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookType;

/*
 * ͼ��������ݴ�ȡ
 */
public class BookTypeDao {
	//���
	public int add(Connection con,BookType bookType) throws SQLException {
		String sql="insert into t_booktype values(null,?,?)";
		//����PreparedStatement�����sql������Ԥ���룬����߰�ȫ�Ժ�ִ��Ч��
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, bookType.getBookTypeName());
		p.setString(2, bookType.getBookTypeDesc());
		
		return p.executeUpdate();//����ɾ����������±�
		
		
	}
	//��ѯ����
	public ResultSet list(Connection con,BookType bookType) throws SQLException {
		String sql="select * from t_booktype";
		PreparedStatement p=con.prepareStatement(sql);
		return p.executeQuery();
	}
	public int update(Connection con,BookType bookType) throws SQLException {
		String sql="update t_booktype set TypeName=?,TypeDesc=? where id=?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, bookType.getBookTypeName());
		p.setString(2, bookType.getBookTypeDesc());
		p.setInt(3, bookType.getId());
		return p.executeUpdate();
	}
	//ɾ����¼
	public int del(Connection con,String id) throws SQLException {
		String sql = "delete from t_booktype where id = ?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, id);
		return p.executeUpdate();
		
	}
}
