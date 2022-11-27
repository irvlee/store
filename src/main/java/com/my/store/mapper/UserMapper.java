package com.my.store.mapper;

import com.my.store.entity.User;

public interface UserMapper {
    /**
     * 根据名称查询是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insert(User user);

}
