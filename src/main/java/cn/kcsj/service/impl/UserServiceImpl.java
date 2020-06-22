package cn.kcsj.service.impl;


import cn.kcsj.Dao.UserDao;
import cn.kcsj.javaBean.*;
import cn.kcsj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User logincheck1(User user) {
        return userDao.logincheck1(user);
    }

    @Override
    public List<UserInfo> findAllUserInfo(User user) {
        return userDao.findAllUserInfo(user);
    }

    @Override
    public void UpdateUserInfo(String UserId, String Phone, String Email) {
        userDao.UpdateUserInfo(UserId,Phone,Email);
    }

    @Override
    public User getUserId(String UserName) {
        return userDao.getUserId(UserName);
    }

    @Override
    public void readerAlterPaswd(String UserId, String Password) {
        userDao.readerAlterPaswd(UserId,Password);
    }

    @Override
    public BookAdmin logincheck2(BookAdmin bookAdmin) {
        return userDao.logincheck2(bookAdmin);
    }

    @Override
    public SystemAdmin logincheck3(SystemAdmin systemAdmin) {
        return userDao.logincheck3(systemAdmin);
    }

    @Override
    public UserInfo getUserInfo(String UserId) {
        return userDao.getUserInfo(UserId);
    }

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        userDao.insertUserInfo(userInfo);
    }

    @Override
    public List<BookAdmin> findAllBookAdmin(String Adld) {
        return userDao.findAllBookAdmin(Adld);
    }

    @Override
    public BookAdmin findAllBookAdmin1(String AdName) {
        return userDao.findAllBookAdmin1(AdName);
    }

    @Override
    public void xiugaimima(String AdPassword, String AdName) {
        userDao.xiugaimima(AdPassword,AdName);
    }

    @Override
    public void xiugaixinxi(String AdPhone, String AdName, String AdEmail) {
        userDao.xiugaixinxi(AdPhone,AdName,AdEmail);
    }

    @Override
    public List<UserInfo> findAllUserInfo1() {
        return userDao.findAllUserInfo1();
    }

    @Override
    public void DelUserInfosss(String UserName) {
        userDao.DelUserInfosss(UserName);
    }

    @Override
    public void xiugaiUserInfoxinxi(String UserId, String UserName, String Departments, String Major, String Phone, String Email, String Max, String Time, String LendedNum, String UserIdx) {
        userDao.xiugaiUserInfoxinxi(UserId,UserName,Departments,Major,Phone,Email,Max,Time,LendedNum,UserIdx);
    }

    @Override
    public void DelUserInfosss1(String UserName) {

    }

    @Override
    public void InterBookAdmin(String AdId, String AdName, String AdPassword, String AdPhone, String AdEmail) {
        userDao.InterBookAdmin(AdId,AdName,AdPassword,AdPhone,AdEmail);
    }

    @Override
    public void DelBookAdmin(String AdId) {
        userDao.DelBookAdmin(AdId);
    }

    @Override
    public void UpdateBookadmin(String AdIdx, String AdName, String AdPassword, String AdPhone, String AdEmail, String AdId) {
        userDao.UpdateBookadmin(AdIdx,AdName,AdPassword,AdPhone,AdEmail,AdId);
    }

    @Override
    public BookAdmin findAllBookAdmin2(String AdId) {
        return userDao.findAllBookAdmin2(AdId);
    }

    @Override
    public List<BookAdmin> getBookadminAll() {
        return userDao.getBookadminAll();
    }

    @Override
    public void UpdateSystemadminPassword(String AdminPassword, String AdminName) {
        userDao.UpdateSystemadminPassword(AdminPassword,AdminName);
    }

    @Override
    public void UpdateSystemadmininfo(String AdminPhone, String AdminEmail, String AdminName) {
        userDao.UpdateSystemadmininfo(AdminPhone,AdminEmail,AdminName);
    }

    @Override
    public SystemAdmin getSystemAdmin(String AdminName) {
        return userDao.getSystemAdmin(AdminName);
    }

    @Override
    public SystemAdmin getgetSystemAdminlist(String AdminId) {
        return userDao.getgetSystemAdminlist(AdminId);
    }

}
