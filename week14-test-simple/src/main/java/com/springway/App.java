package com.springway;

import java.sql.SQLException;

import com.springway.dao.UserDao;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();

        userDao.findAlUsers().forEach(System.out::println);
        System.out.println(userDao.selectOne("1583019654656311297"));;
    }
}
