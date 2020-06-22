package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 用户信息
 */
public class User implements Serializable{

    private String UserId;  //用户ID(学号)
    private String UserName;  //用户名
    private String Password;  //用户密码

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String id) {
        this.UserId = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String name) {
        this.UserName = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", Password=" + Password +
                '}';
    }
}
