package com.springway;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springway.entity.User;
import com.springway.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("User02");
        user.setPassword("waku_waku@&*)gwqk");
        userMapper.insert(user);
    }

    @Test
    public void selectAllUser() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void deleteUser() {
        int deleteById = userMapper.deleteById("1583018248188743681");
        System.out.println(deleteById);
    }

    @Test
    public void selectUserByPage() {
        IPage<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);

        IPage<User> selectPage = userMapper.selectPage(page, null);
        selectPage.getRecords().forEach(System.out::println);
        System.out.println("Current: " + selectPage.getCurrent());
        System.out.println("Pages: " + selectPage.getPages());
        System.out.println("Size: " + selectPage.getSize());
        System.out.println("Total: " + selectPage.getTotal());
    }

    @Test
    public void updateUserById() {
        User user = new User();
        user.setUsername("mikuuuuuuuu");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("u_id", "1583019654656311297");
        userMapper.update(user, updateWrapper);
    }

    @Test
    public void selectUserByIds() {
        List<String> ids = new ArrayList<>();
        ids.add("1583019654656311297");
        ids.add("1583029021829087233");
        userMapper.selectBatchIds(ids).forEach(System.out::println);
    }
}
