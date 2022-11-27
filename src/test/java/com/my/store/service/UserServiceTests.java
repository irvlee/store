package com.my.store.service;

import com.my.store.entity.User;
import com.my.store.service.ex.ServiceException;
import com.my.store.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

// @SpringBootTest 表示是一个测试类，不会随同项目一块打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("zhao5");
        user.setPassword("1234567");

        try {
            userService.insert(user);
        } catch (ServiceException e) {
            // 获取类的对象
            String name = e.getClass().getName();
            System.out.println("异常类名称：" + name);

            System.out.println(e.getMessage());
        }

    }


}
