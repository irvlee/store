package com.my.store.service;

import com.my.store.entity.User;

public interface IUserService {

    public void insert(User user);

    public User login(User user);

    public Integer changePwd(Integer id,String username, String oldPwd, String newPwd);

}
