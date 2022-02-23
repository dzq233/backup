package com.dzq.test;
import com.alibaba.druid.util.JdbcUtils;
import com.dzq.utils.jdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtiles() {
        for (int i = 0; i < 100; i++) {
            Connection conn = jdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }


    }
}

