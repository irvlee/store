package com.my.store.service.impl;

import com.my.store.entity.User;
import com.my.store.mapper.UserMapper;
import com.my.store.service.IUserService;
import com.my.store.service.ex.*;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.rmi.activation.UnknownObjectException;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;


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

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User byUser = userMapper.findByUsername(username);
        if(byUser == null){
            throw new UsernameNotFoundException("用户名没找到");
        }
        String pwd = byUser.getPassword();
        String salt = byUser.getSalt();
        String md5Pwd = md5Produce(password, salt);
        if(!md5Pwd.equals(pwd)){
            throw new PasswordNoMatchException("密码不匹配！");
        }
        user.setUid(byUser.getUid());
        if(byUser.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户已删除");
        }
        user.setIsDelete(0);
        user.setAvatar(byUser.getAvatar());

        return user;

    }

    @Override
    public Integer changePwd(Integer id, String username, String oldPwd, String newPwd) {

        User userById = userMapper.findUserById(id);
        if(userById == null || userById.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户没找到");
        }

        String salt = userById.getSalt();
        String oldP = md5Produce(oldPwd, salt);
        String newP = md5Produce(newPwd, salt);
        String password = userById.getPassword();
//        if(oldP != password){
//            throw  new PasswordNoMatchException("密码不正确");
//        }
        if(!password.equals(oldP)){
            throw new PasswordNoMatchException("密码不正确");
        }

        Integer rows =
                userMapper.updatePassword(id, newP, username, new Date());
        if(rows.intValue() != 1){
            throw new UpdateException("更新时异常");
        }
        return rows;
    }

    private String md5Produce(String password, String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
        }
        return password;

    }
}
