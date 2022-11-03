package com.springway.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.springway.base.AbstractDbunitTestCase;
import com.springway.entity.User;
import com.springway.utils.DButils;

public class TestUserDao extends AbstractDbunitTestCase {
    
    private UserDao userDao;

    public TestUserDao() throws Exception {
        super(DButils.getConnection(), TestUserDao.class.getClassLoader().getResourceAsStream("user-test.xml"));
    }
    
    @Before
    public void init() throws Exception {
        userDao = new UserDao();
        backOneTable("javaee_2208_db.t_user");
        insertTestData();
    }

    @Test
    public void selectOne() throws SQLException {
        User result = userDao.selectOne("1583019654656311297");
        assertEquals("mikuuuuuuuu", result.getUsername());
        assertEquals("mikumikuwovuwo", result.getPassword());
    }

    @Test
    public void insertOne() throws SQLException {
        User user = new User();
        user.setUId("123456");
        user.setUsername("hhhhhh");
        user.setPassword("haihaihai");
        assertEquals(1, userDao.insertOne(user));
    }
    
    @After
    public void after() throws Exception {
        rollBackTable();
    }
}
