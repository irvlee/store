package com.my.store.mapper;

import com.my.store.entity.User;

import java.util.Date;

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

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User findUserById(Integer id);

    Integer updatePassword(Integer id, String pwd,
                           String modifiedUser, Date modifiedTime);




}
