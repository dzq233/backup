package com.dzq.dao.impl;

import com.dzq.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //update()方法用来执行：Insert/update/delete语句
    //如果返回-1,说明执行失败，返回其他表示影响的行数
    public int update(String sql, Object... args) {
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(conn);
        }
        return -1;
    }
    /*查询返回一个javaBean的sql语句
     * type    返回的对象类型
     * sql     执行的sql语句
     * args    sql对应的函数值
     * <T>     返回的类型的泛型
     * */

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

    /*查询返回多个javaBean的sql语句
     * type    返回的对象类型
     * sql     执行的sql语句
     * args    sql对应的函数值
     * <T>     返回的类型的泛型
     * */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close(conn);
        }
        return null;

    }
//执行返回一行一列的sql语句
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = jdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }
}
