package com.my.store.controller;

import com.my.store.entity.User;
import com.my.store.service.IUserService;
import com.my.store.service.ex.InsertException;
import com.my.store.service.ex.UsernameDuplicatedException;
import com.my.store.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;


    @GetMapping("register")
    public JsonResult register(User user){
//        JsonResult jsonResult = new JsonResult();
//        try {
//            userService.insert(user);
//            jsonResult.setState(200);
//            jsonResult.setMessage("注册成功！");
//        } catch (UsernameDuplicatedException e) {
//            jsonResult.setState(500);
//            jsonResult.setMessage(e.getMessage());
//        } catch (InsertException e){
//            jsonResult.setState(500);
//            jsonResult.setMessage(e.getMessage());
//        }
//        return jsonResult;
        userService.insert(user);
        return new JsonResult(OK);

    }




}
