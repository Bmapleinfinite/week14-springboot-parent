package com.springway.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.springway.entity.User;
import com.springway.utils.DButils;

public class UserDao {

    private QueryRunner queryRunner = DButils.getQueryRunner();

    public List<User> findAlUsers() throws SQLException {
        return (List<User>) queryRunner.query(
                "select * from t_user where is_delete = ?",
                new BeanListHandler<>(User.class),
                0);
    }

    public User selectOne(String id) throws SQLException {
        return (User) queryRunner.query(
                "select * from t_user where is_delete = ? and u_id = ?",
                new BeanHandler<>(User.class),
                0, id);
    }


    public int insertOne(User user) throws SQLException {
        return queryRunner.update(
                "insert into t_user (u_id, username, password) values (?, ?, ?)",
                user.getUId(),
                user.getUsername(),
                user.getPassword());
    }

}
