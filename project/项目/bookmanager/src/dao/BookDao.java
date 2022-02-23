package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

//ͼ�����ݴ�ȡ
public class BookDao {
	//���ͼ��
	public int add(Connection con,Book book) throws Exception{
		String sql="insert into t_book values(null,?,?,?,?,?)";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1,book.getBookName());
		p.setString(2,book.getAuthor());
		p.setFloat(3,book.getPrice());
		p.setInt(4,book.getBookTypeId());
		p.setString(5,book.getBookDesc());
		return p.executeUpdate();
		
	}
	//��ѯ����ͼ��
	public ResultSet list(Connection con, Book book) throws SQLException {
		String sql = "select * from t_book a,t_booktype b where a.booktypeid = b.id";
		PreparedStatement ps = con.prepareStatement(sql);

		return ps.executeQuery();
	}
	//ɾ��ͼ��
	public int delete(Connection con, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from t_book where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	//�޸�ͼ��
	public int update(Connection con,Book book) throws SQLException{
		String sql="update t_book set bookname=?,author=?,price=?,booktypeid=?,bookdesc=? where id=?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1,book.getBookName());
		p.setString(2,book.getAuthor());
		p.setFloat(3,book.getPrice());
		p.setInt(4,book.getBookTypeId());
		p.setString(5,book.getBookDesc());
		p.setInt(6,book.getId());
		return p.executeUpdate();
	}
	
}
