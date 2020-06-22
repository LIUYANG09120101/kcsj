package cn.kcsj.service;

import cn.kcsj.javaBean.BookAdmin;
import cn.kcsj.javaBean.SystemAdmin;
import cn.kcsj.javaBean.User;
import cn.kcsj.javaBean.UserInfo;

import java.util.List;

public interface UserService {
    //查询所有读者
    public List<User> findAllUser();

    //读者注册
    public void insertUser(User user);

    //读者登录验证
     public  User logincheck1(User user);

    //查询读者信息
    public List<UserInfo> findAllUserInfo(User user);

    //修改读者信息
    public void UpdateUserInfo(String UserId,String Phone,String Email);

    //根据读者名查读者ID
    public  User getUserId(String UserName);

    //修改密码
    public void readerAlterPaswd(String UserId,String Password);

    //图书管理员登录
    public  BookAdmin logincheck2(BookAdmin bookAdmin);

    //系统管理员登录
    public  SystemAdmin logincheck3(SystemAdmin systemAdmin);

    //根据id获取读者信息
    public  UserInfo getUserInfo(String UserId);

    public void insertUserInfo(UserInfo userInfo);

    public List<BookAdmin> findAllBookAdmin(String Adld);

    public BookAdmin findAllBookAdmin1(String AdName);

    public void xiugaimima(String AdPassword,String AdName);

    public void xiugaixinxi(String AdPhone,String AdName,String AdEmail);

    public List<UserInfo> findAllUserInfo1();

    public void DelUserInfosss(String UserName);

    public void xiugaiUserInfoxinxi(String UserId,String UserName,String Departments,String Major,String Phone,String Email,String Max,String Time,String LendedNum,String UserIdx);

    public void DelUserInfosss1(String UserName);

    public void InterBookAdmin(String AdId,String AdName,String AdPassword,String AdPhone,String AdEmail);

    public void DelBookAdmin(String AdId);

    public void UpdateBookadmin(String AdIdx,String AdName,String AdPassword,String AdPhone,String AdEmail,String AdId);

    public BookAdmin findAllBookAdmin2(String AdId);

    public List<BookAdmin> getBookadminAll();

    public void UpdateSystemadminPassword(String AdminPassword,String AdminName);

    public void UpdateSystemadmininfo(String AdminPhone,String AdminEmail,String AdminName);

    public SystemAdmin getSystemAdmin(String AdminName);

    public SystemAdmin getgetSystemAdminlist(String AdminId);
}
