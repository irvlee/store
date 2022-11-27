package com.my.store.mapper;

import com.my.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest 表示是一个测试类，不会随同项目一块打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired // 提示没有找到是因为idea 接口是不能直接创建bean的,设置inspections为警告
    private UserMapper userMapper;
    /** 单元测试方法可以独立运行
     * 1. 必须被@Test修饰
     * 2. 返回值必须是void
     * 3。 无参
     * 4. public修饰符修饰方法
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("zhangs");
        user.setPassword("123456");

        Integer insert = userMapper.insert(user);
        if(insert>0){
            System.out.println("添加成功！");
        }



    }

    @Test
    public void query(){
        User byUsername = userMapper.findByUsername("zhangs");
        System.out.println(byUsername);

    }
}
