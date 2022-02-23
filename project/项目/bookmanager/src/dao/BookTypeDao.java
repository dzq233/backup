package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookType;

/*
 * 图书类别数据存取
 */
public class BookTypeDao {
	//添加
	public int add(Connection con,BookType bookType) throws SQLException {
		String sql="insert into t_booktype values(null,?,?)";
		//定义PreparedStatement对象对sql语句进行预编译，以提高安全性和执行效率
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, bookType.getBookTypeName());
		p.setString(2, bookType.getBookTypeDesc());
		
		return p.executeUpdate();//增、删、改用其更新表
		
		
	}
	//查询所有
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
	//删除记录
	public int del(Connection con,String id) throws SQLException {
		String sql = "delete from t_booktype where id = ?";
		PreparedStatement p=con.prepareStatement(sql);
		p.setString(1, id);
		return p.executeUpdate();
		
	}
}
