package com.note.fiction.dto.request;

/**
 * Created by Administrator on 2017/3/18.
 */
public class SystemUserLoginReq {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
