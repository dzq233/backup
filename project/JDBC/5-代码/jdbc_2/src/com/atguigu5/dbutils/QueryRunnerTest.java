package com.atguigu5.dbutils;


import com.atguigu2.dao.bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import com.atguigu4.util.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//commons-dbutils 是Apache组织提供的一个开源JDBC工具类库，封装了针对于数据库的增删改查操作
public class QueryRunnerTest {
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = runner.update(conn, sql, "蔡徐坤", "caixukun@126.com", "1997-09-08");
            System.out.println("添加了" + insertCount + "条记录");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
//测试查询
    //BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
@Test
public void testQuery1() {
    Connection conn = null;
    try {
        QueryRunner runner = new QueryRunner();
        conn = JDBCUtils.getConnection3();
        String sql = "select id,name,email,birth from customers where id < ?";
        BeanHandler<Customer> handler= new BeanHandler<>(Customer.class);
        Customer customer= runner.query(conn, sql, handler, 23);
        System.out.println(customer);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        JDBCUtils.closeResource(conn,null);
    }


}
//BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
    @Test
    public void testQuery2() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> handler= new BeanListHandler<>(Customer.class);
            List<Customer> list= runner.query(conn, sql, handler, 23);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }
    //MapHandler:是ResultSetHandler接口的实现类，对应表中的一条记录。
    //将字段及相应字段的值作为map中的key和value
    @Test
    public void testQuery3() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String,Object> map= runner.query(conn, sql, handler, 23);
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }
    //MapHandler:是ResultSetHandler接口的实现类，对应表中的多条记录。
    //将字段及相应字段的值作为map中的key和value，将这些map添加到List中
    @Test
    public void testQuery4() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }
    //ScalarHandler:用于查询特殊值
    @Test
    public void testQuery5() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select count(*)from customers";
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(conn, sql, handler);
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }
    @Test
    public void testQuery6() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select max(birth) from customers";
            ScalarHandler handler = new ScalarHandler();

            Date maxBirth = (Date) runner.query(conn, sql, handler);
            System.out.println(maxBirth);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }
}
