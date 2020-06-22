package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 用户信息
 */
public class UserInfo implements Serializable {
    private String UserId ;   //用户ID(学号)
    private String UserName;   //用户名
    private String Departments;  //院系
    private String Major;   //专业
    private String Phone;  //电话
    private String Email;  //邮箱
    private int Max;  //可借最大数量
    private int Time;  //可借期限
    private int LendedNum;  //在借数量

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getDepartments() {
        return Departments;
    }

    public void setDepartments(String departments) {
        Departments = departments;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        Max = max;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public int getLendedNum() {
        return LendedNum;
    }

    public void setLendedNum(int lendedNum) {
        LendedNum = lendedNum;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserId='" + UserId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Departments='" + Departments + '\'' +
                ", Major='" + Major + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Max=" + Max +
                ", Time=" + Time +
                ", LendedNum=" + LendedNum +
                '}';
    }
}
