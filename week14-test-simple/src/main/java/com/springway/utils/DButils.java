package com.springway.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.druid.pool.DruidDataSource;

public class DButils {
    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        dataSource.setUsername("root");
        dataSource.setPassword("ZMQaishiteru1229");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/javaee_2208_db?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        /**
         * 下面是 mysql-jdbc-connector 8版本以上要使用dbunit必须配置的设置
         *
         * 原因：
         * mysql-jdbc-connector 在 8.0.17版本后 将databaseTerm的默认值设为了catalog
         * 但由于mysql不支持catalog，仅支持schema，我们需要手动将连接中的databaseTerm改为schema
         *
         * 采用druid连接池的情况下，配置好连接池的properties属性即可解决该问题
         * 同时，备份操作的数据库表名需要按照 数据库名.表名 的格式作为参数传入
         *
         * 该方法不兼容 mysql-jdbc-connector 5版本
         *
         */
        Properties properties = new Properties();
        properties.setProperty("databaseTerm", "schema");
        dataSource.setConnectProperties(properties);
    }

    public static Connection getConnection() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
//        connection.setSchema("javaee_2208_db");
        return connection;
    }

    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }
}
