package com.my.store.controller;

import com.my.store.service.ex.*;
import com.my.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {

    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<Void>(e);

        if(e instanceof UsernameDuplicatedException){
            result.setState(500);
            result.setMessage(e.getMessage());
        }else if(e instanceof InsertException){
            result.setState(500);
            result.setMessage(e.getMessage());
        }else if(e instanceof UsernameNotFoundException){
            result.setState(400);
            result.setMessage(e.getMessage());
        }else if(e instanceof PasswordNoMatchException){
            result.setState(4001);
            result.setMessage(e.getMessage());
        }

        return result;

    }

    protected final Integer getUidFromSession(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());

        return uid;
    }

    protected final String getUsernameFromSession(HttpSession session){
        String username = session.getAttribute("username").toString();
        return username;
    }

}
