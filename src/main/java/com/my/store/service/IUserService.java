package com.my.store.service;

import com.my.store.entity.User;

public interface IUserService {

    public void findByUsername(String username);

    public void insert(User user);

}
