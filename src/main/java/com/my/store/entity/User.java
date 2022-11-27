package com.my.store.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class User extends BaseEntity  implements Serializable {

    private Long uid;
    private String password;
    private String username;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;

}
