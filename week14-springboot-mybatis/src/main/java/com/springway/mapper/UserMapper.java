package com.springway.mapper;

import com.springway.entity.User;
import java.util.List;

public interface UserMapper {
    List<User> findAllUser();
}
