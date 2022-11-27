package com.my.store.controller;

import com.my.store.service.ex.InsertException;
import com.my.store.service.ex.ServiceException;
import com.my.store.service.ex.UsernameDuplicatedException;
import com.my.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        }

        return result;

    }


}
