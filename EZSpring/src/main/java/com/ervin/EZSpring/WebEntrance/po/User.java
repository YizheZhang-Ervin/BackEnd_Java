package com.ervin.EZSpring.WebEntrance.po;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class User implements Serializable {
    // POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称
    // POJO会反射调用set方法，所以必须要有set方法

    private Integer userId;

    @NotBlank(message="cannot blank name")
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
