package com.my.store.service.impl;

import com.my.store.entity.User;
import com.my.store.mapper.UserMapper;
import com.my.store.service.IUserService;
import com.my.store.service.ex.InsertException;
import com.my.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void findByUsername(String username) {

    }

    @Override
    public void insert(User user) {
        String username = user.getUsername();
        User byUsername = userMapper.findByUsername(username);
        if(byUsername != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        // 盐值 md5加密
        String password = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 保存盐值
        user.setSalt(salt);
        password = md5Produce(password, salt);
        user.setPassword(password);

        // 初始化默认值
        user.setIsDelete(0);
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer insert = userMapper.insert(user);
        if(insert != 1){
            throw new InsertException("插入时出错");
        }
    }

    private String md5Produce(String password, String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
        }
        return password;

    }
}
