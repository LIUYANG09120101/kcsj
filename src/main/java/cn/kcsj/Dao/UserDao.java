package cn.kcsj.Dao;

import cn.kcsj.javaBean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 读者dao接口
 */
@Repository
public interface UserDao {

    //查询所有读者
    @Select("select * from user")
    public List<User> findAllUser();

    //注册读者信息
    @Insert("insert into user (UserId,UserName,Password) values (#{UserId},#{UserName},#{Password})")
    public void insertUser(User user);

    //读者验证登录
    @Select("select * from user where UserName=#{UserName} and Password=#{Password}")
    public  User logincheck1(User user);

    //查询读者信息
    @Select("select * from userinfo where UserId =#{UserId}")
    public List<UserInfo> findAllUserInfo(User user);
    //查询图书管理员信息
    @Select("select * from bookadmin where AdId =#{arg0}")
    public List<BookAdmin> findAllBookAdmin(String Adld);

    //查询图书管理员信息
    @Select("select * from bookadmin where AdName =#{arg0}")
    public BookAdmin findAllBookAdmin1(String AdName);

    @Select("select * from bookadmin where AdId =#{arg0}")
    public BookAdmin findAllBookAdmin2(String AdId);
    //根据读者名查读者ID
    @Select("select * from user where UserName=#{UserName}")
    public  User getUserId(String UserName);

    //修改读者信息
    @Update("update userinfo set Phone=#{arg1},Email=#{arg2} where UserId=#{arg0}")
    public void UpdateUserInfo(String UserId,String Phone,String Email);

    //修改读者密码
    @Update("update user set Password=#{arg1} where UserId=#{arg0}")
    public void readerAlterPaswd(String UserId,String Password);

    //图书管理员登录验证
    @Select("select * from bookadmin where AdName=#{AdName} and AdPassword=#{AdPassword}")
    public  BookAdmin logincheck2(BookAdmin bookAdmin);

    //系统管理员登录验证
    @Select("select * from systemadmin where AdminName=#{AdminName} and AdminPassword=#{AdminPassword}")
    public  SystemAdmin logincheck3(SystemAdmin systemAdmin);

    //根据读者ID查询读者信息
    @Select("select * from userinfo where UserId=#{UserId}")
    public  UserInfo getUserInfo(String UserId);

    //系统管理员录入新读者
    @Insert("insert into userinfo (UserId,UserName,Departments,Major,Phone,Email,Max,Time,LendedNum) values (#{UserId},#{UserName},#{Departments},#{Major},#{Phone},#{Email},#{Max},#{Time},#{LendedNum})")
    public void insertUserInfo(UserInfo userInfo);

    //修改管理员密码
    @Update("update bookadmin set AdPassword=#{arg0} where AdName=#{arg1}")
    public void xiugaimima(String AdPassword,String AdName);

    //修改管理员信息
    @Update("update bookadmin set AdPhone=#{arg0},AdEmail=#{arg2} where AdName=#{arg1}")
    public void xiugaixinxi(String AdPhone,String AdName,String AdEmail);

    //获取读者信息
    @Select("select * from userinfo")
    public List<UserInfo> findAllUserInfo1();

    //系统管理员根据读者名删除读者
    @Delete("delete from userinfo where UserName=#{UserName};")
    public void DelUserInfosss(String UserName);

    //系统管理员根据读者名删除读者
    @Delete("delete from user where UserName=#{UserName};")
    public void DelUserInfosss1(String UserName);

    //系统管理员修改读者信息
    @Update("update userinfo set UserId=#{arg0},UserName=#{arg1} ,Departments=#{arg2},Major=#{arg3},Phone=#{arg4},Email=#{arg5},Max=#{arg6},Time=#{arg7},LendedNum=#{arg8} where UserId=#{arg9}")
    public void xiugaiUserInfoxinxi(String UserId,String UserName,String Departments,String Major,String Phone,String Email,String Max,String Time,String LendedNum,String UserIdx);

    //系统管理员录入管理员
    @Insert("insert into bookadmin (AdId,AdName,AdPassword,AdPhone,AdEmail) values (#{arg0},#{arg1},#{arg2},#{arg3},#{arg4})")
    public void InterBookAdmin(String AdId,String AdName,String AdPassword,String AdPhone,String AdEmail);

    //系统管理员删除图书管理员
    @Delete("delete from bookadmin where AdId=#{arg0}")
    public void DelBookAdmin(String AdId);
    //系统管理员修改图书管理员信息
    @Update("update bookadmin set AdId=#{arg0},AdName=#{arg1},AdPassword=#{arg2},AdPhone=#{arg3},AdEmail=#{arg4} where AdId=#{arg5}")
    public void UpdateBookadmin(String AdIdx,String AdName,String AdPassword,String AdPhone,String AdEmail,String AdId);

    //系统管理员查看图书管理员
    @Select("select * from bookadmin")
    public List<BookAdmin> getBookadminAll();

    //系统管理员修改密码
    @Update("update systemadmin set AdminPassword=#{arg0} where AdminName=#{arg1}")
    public void UpdateSystemadminPassword(String AdminPassword,String AdminName);

    //系统管理员修改信息
    @Update("update systemadmin set AdminPhone=#{arg0},AdminEmail=#{arg1} where AdminName=#{arg2}")
    public void UpdateSystemadmininfo(String AdminPhone,String AdminEmail,String AdminName);

    //根据用户名查询
    @Select("select * from systemadmin where AdminName=#{AdminName}")
    public SystemAdmin getSystemAdmin(String AdminName);

    @Select("select * from systemadmin where AdminId=#{AdminId}")
    public SystemAdmin getgetSystemAdminlist(String AdminId);
}
