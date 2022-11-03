package com.springway.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springway.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User>{
    
}
