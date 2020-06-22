package cn.kcsj.controller;

import cn.kcsj.javaBean.*;
import cn.kcsj.service.BookService;
import cn.kcsj.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Time;
import java.util.List;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author 刘阳
 * @Date 2020/6/2 16:04
 *
 * 实现用户相关功能
 */
@Controller
@RequestMapping("/JSP")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) {
        System.out.println("查询所有读者信息");
        List<User> list = userService.findAllUser();
        model.addAttribute("Userlist", list);
        return "Userlist";
    }

    @RequestMapping("/insertUser")
    public void insertUser(User user, HttpServletResponse response, HttpServletRequest request) throws IOException {
        userService.insertUser(user);
        response.sendRedirect(request.getContextPath() + "/user/findAllUser");
        return;
    }

    //登录验证
    @RequestMapping("/logins")
    public String login(@RequestParam("UserName") String Name, @RequestParam("Password") String Password, String type, HttpServletRequest request) {
        if (type.equals("1")) {  //读者
            User user = new User();
            user.setUserName(Name);
            user.setPassword(Password);
            User user1 = userService.logincheck1(user);
            if (user1 != null) {
                List<UserInfo> list = userService.findAllUserInfo(userService.logincheck1(user));
                String UserId = user1.getUserId();
                List<BorrowRecords> borrowRecordsList1 = bookService.getBorrowRecords(UserId, 0);
                List<BorrowRecords> borrowRecordsList2 = bookService.getBorrowRecords(UserId, 1);
                request.getSession().setAttribute("username", Name);
                request.getSession().setAttribute("userinfos", list);
                request.getSession().setAttribute("borrowRecordsList2", borrowRecordsList2);
                request.getSession().setAttribute("borrowRecordsList1", borrowRecordsList1);
                return "readerPersonal";
            } else {
                request.getSession().setAttribute("error", "<script>alert(\"通行证号或密码错误\");</script>");
                return "login";
            }
        } else if (type.equals("2")) {  //图书管理员
            BookAdmin bookAdmin = new BookAdmin();
            bookAdmin.setAdName(Name);
            bookAdmin.setAdPassword(Password);
            BookAdmin bookAdmin1;
            bookAdmin1 = userService.logincheck2(bookAdmin);
            if (bookAdmin1 != null) {
                List<BookAdmin> list = userService.findAllBookAdmin(bookAdmin1.getAdId());
                request.getSession().setAttribute("bookadmin", list);
                request.getSession().setAttribute("Adname", Name);
                return "adBorrowBook";
            } else {
                request.getSession().setAttribute("error", "<script>alert(\"通行证号或密码错误\");</script>");
                return "login";
            }

        } else if (type.equals("3")) {  //系统管理员
            SystemAdmin systemAdmin = new SystemAdmin();
            systemAdmin.setAdminName(Name);
            systemAdmin.setAdminPassword(Password);
            SystemAdmin systemAdmin1 = new SystemAdmin();
            systemAdmin1=userService.logincheck3(systemAdmin);
            if ( systemAdmin1!= null) {
                List<UserInfo> userInfoList = userService.findAllUserInfo1();
                List<BookAdmin> bookAdminList = userService.getBookadminAll();
                if (userInfoList.isEmpty()) {
                    request.getSession().setAttribute("infokong", "<script>alert(\"没有读者\");</script>");
                } else {
                    request.getSession().setAttribute("userInfoList", userInfoList);
                }
                if (bookAdminList.isEmpty()) {
                    request.getSession().setAttribute("infokong1", "<script>alert(\"没有图书管理员\");</script>");
                } else {
                    request.getSession().setAttribute("bookAdminList", bookAdminList);
                }
                request.getSession().setAttribute("systemAdmin1", systemAdmin1);
                request.getSession().setAttribute("SysAdname", Name);
                return "adminPersonal";
            } else {
                request.getSession().setAttribute("error", "<script>alert(\"通行证号或密码错误\");</script>");
                return "login";
            }
        } else {
            request.getSession().setAttribute("error", "<script>alert(\"登录错误\");</script>");
            return "login";
        }
    }

    //修改读者信息
    @RequestMapping("/readerAlterDatas")
    public String readerAlterData(@RequestParam("Phone") String Phone, @RequestParam("Email") String Email, @RequestParam("UserName") String UserName, HttpServletRequest request) {
        User user = userService.getUserId(UserName);
        userService.UpdateUserInfo(user.getUserId(), Phone, Email);
        List<UserInfo> list = userService.findAllUserInfo(user);
        request.getSession().setAttribute("username", UserName);
        request.getSession().setAttribute("userinfos", list);
        request.getSession().setAttribute("s", "<script>alert(\"修改资料成功\");</script>");
        return "readerPersonal";
    }

    //读者密码
    @RequestMapping("/readerAlterPaswds")
    public String readerAlterPaswd(@RequestParam("UserName") String UserName, @RequestParam("Password1") String Password1, @RequestParam("Password2") String Password2, @RequestParam("Password3") String Password3, HttpServletRequest request) {
        User user = new User();
        user.setUserName(UserName);
        user.setPassword(Password1);
        if (userService.logincheck1(user) != null) {
            User user1 = userService.getUserId(UserName);
            if (Password2.equals(Password3)) {
                userService.readerAlterPaswd(user1.getUserId(), Password2);
            } else {
                request.getSession().setAttribute("1", "<script>alert(\"两次输入密码不匹配，请重新输入\");</script>");
                return "readerAlterPaswd";
            }
        } else {
            request.getSession().setAttribute("2", "<script>alert(\"原密码错误，请重新输入\");</script>");
            return "readerAlterPaswd";
        }
        request.getSession().invalidate();
        request.getSession().setAttribute("3", "<script>alert(\"修改密码成功，请重新登录\");</script>");
        return "login";  //修改密码成功，返回登录界面重新登录
    }

    @RequestMapping("/out")
    public String out(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/insertUserInfo")
    public String insertUserInfo(@RequestParam("UserId") String UserId, @RequestParam("UserName") String UserName, @RequestParam("Departments") String Departments, @RequestParam("Major") String Major, @RequestParam("Phone") String Phone, @RequestParam("Email") String Email, @RequestParam("Max") String Max, @RequestParam("Time") String Time, HttpServletRequest request) {
        User user = new User();
        user.setUserName(UserName);
        user.setUserId(UserId);
        user.setPassword(UserId);
        userService.insertUser(user);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UserId);
        userInfo.setUserName(UserName);
        userInfo.setDepartments(Departments);
        userInfo.setEmail(Email);
        userInfo.setMajor(Major);
        userInfo.setMax(Integer.parseInt(Max));
        userInfo.setPhone(Phone);
        userInfo.setTime(Integer.parseInt(Time));
        userInfo.setLendedNum(0);
        userService.insertUserInfo(userInfo);
        request.getSession().setAttribute("insertUserInfo", "<script>alert(\"录入新读者成功\");</script>");
        return "adminAddReader";
    }

    @RequestMapping("/adPersonal_xiugai")
    public String adPersonal_xiugai(@RequestParam("AdName") String AdName, @RequestParam("yPassword") String yPassword, @RequestParam("xPassword") String xPassword, @RequestParam("qPassword") String qPassword, @RequestParam("adPhone") String adPhone, @RequestParam("adEmail") String adEmail, HttpServletRequest request) {
        BookAdmin bookAdmin = userService.findAllBookAdmin1(AdName);
        if (yPassword.isEmpty()) {
            request.getSession().setAttribute("ymimano", "<script>alert(\"请输入原密码\");</script>");
            return "adPersonal";
        } else if (yPassword.equals(bookAdmin.getAdPassword())) {
            if (xPassword.isEmpty() && qPassword.isEmpty()) {
                userService.xiugaixinxi(adPhone, AdName, adEmail);
                request.getSession().setAttribute("xinxicg", "<script>alert(\"修改信息成功\");</script>");
                List<BookAdmin> list = userService.findAllBookAdmin(bookAdmin.getAdId());
                request.getSession().setAttribute("bookadmin", list);
                return "adPersonal";
            } else if (qPassword == null) {
                request.getSession().setAttribute("qmima", "<script>alert(\"没有输入确认新密码\");</script>");
                return "adPersonal";
            } else if (xPassword.equals(qPassword)) {
                userService.xiugaimima(xPassword, AdName);
                request.getSession().setAttribute("mimacg", "<script>alert(\"修改密码成功,请重新登录\");</script>");
                return "login";
            } else {
                request.getSession().setAttribute("mimabu", "<script>alert(\"两次密码不匹配\");</script>");
                return "adPersonal";
            }
        } else {
            request.getSession().setAttribute("mimacw", "<script>alert(\"原密码错误\");</script>");
            return "adPersonal";
        }
    }

    @RequestMapping("/getUserInfoss")
    public String getUserInfo(@RequestParam("UserId")String UserId, HttpServletRequest request) {
        UserInfo userInfoss = userService.getUserInfo(UserId);
        if(userInfoss==null){
            request.getSession().setAttribute("nop","<script>alert(\"没有该读者\");</script>");
        }
        else {
            request.getSession().setAttribute("userInfoss", userInfoss);
        }

        return "adminOutReader";
    }

    @RequestMapping("/delUserInfosss")
    public String delUserInfosss(@RequestParam("UserName")String UserName,HttpServletRequest request){
        userService.DelUserInfosss(UserName);
        userService.DelUserInfosss1(UserName);
        request.getSession().setAttribute("delcg","<script>alert(\"删除成功\");</script>");
        return "adminOutReader";
    }

    @RequestMapping("/getUserInfoss1")
    public String getUserInfo1(@RequestParam("UserId")String UserId, HttpServletRequest request) {
        UserInfo userInfoss = userService.getUserInfo(UserId);
        if(userInfoss==null){
            request.getSession().setAttribute("nop1","<script>alert(\"没有该读者\");</script>");
        }
        else {
            request.getSession().setAttribute("userInfoss1", userInfoss);
        }
        return "adminAlterReader";

    }

    @RequestMapping("/xiugaiUserInfoss")
    public String xiugaiUserInfoss1(@RequestParam("UserId")String UserId,@RequestParam("UserIdx")String UserIdx,@RequestParam("UserName")String UserName,@RequestParam("Departments")String Departments,@RequestParam("Major")String Major,@RequestParam("Phone")String Phone,@RequestParam("Email")String Email,@RequestParam("Max")String Max,@RequestParam("Time")String Time,@RequestParam("LendedNum")String LendedNum, HttpServletRequest request) {
        userService.xiugaiUserInfoxinxi(UserId,UserName,Departments,Major,Phone,Email,Max,Time,LendedNum,UserIdx);
        UserInfo userInfoss = userService.getUserInfo(UserIdx);
        request.getSession().setAttribute("userInfoss1", userInfoss);
        request.getSession().setAttribute("xiugaiInfocg","<script>alert(\"修改成功\");</script>");
        return "adminAlterReader";
    }

    @RequestMapping("/interBookAdmin")
    public String interBookAdmin(@RequestParam("AdId")String AdId,@RequestParam("AdName")String AdName,@RequestParam("AdPassword")String AdPassword,@RequestParam("AdPhone")String AdPhone,@RequestParam("AdEmail")String AdEmail,HttpServletRequest request){
        userService.InterBookAdmin(AdId,AdName,AdPassword,AdPhone,AdEmail);
        request.getSession().setAttribute("tianjiacg","<script>alert(\"录入成功\");</script>");
        return "adminAddAd";
    }

    @RequestMapping("/getBookAdmins")
    public String getBookAdmins(@RequestParam("AdId")String AdId,HttpServletRequest request){
        BookAdmin bookAdmin=userService.findAllBookAdmin2(AdId);
        if(bookAdmin==null){
            request.getSession().setAttribute("bookadminkong","<script>alert(\"没有该图书管理员\");</script>");
        }
        else {
            request.getSession().setAttribute("bookAdminss1", bookAdmin);
        }
        return "adminOutAd";
    }
    @RequestMapping("/delBookAdmin")
    public String delBookAdmin(@RequestParam("AdId")String AdId,HttpServletRequest request){
        userService.DelBookAdmin(AdId);
        request.getSession().setAttribute("bookadminsc","<script>alert(\"成功删除\");</script>");
        return "adminOutAd";
    }

    @RequestMapping("/getBookAdmins1")
    public String getBookAdmins1(@RequestParam("AdId")String AdId,HttpServletRequest request){
        BookAdmin bookAdmin=userService.findAllBookAdmin2(AdId);
        if(bookAdmin==null){
            request.getSession().setAttribute("bookadminkong1","<script>alert(\"没有该图书管理员\");</script>");
        }
        else {
            request.getSession().setAttribute("bookAdminss2", bookAdmin);
        }
        return "adminAlterAd";
    }
    @RequestMapping("/AlterBookAdmin")
    public String AlterBookAdmin(@RequestParam("AdId")String AdId,@RequestParam("AdIdx")String AdIdx,@RequestParam("AdName")String AdName,@RequestParam("AdPassword")String AdPassword,@RequestParam("AdPhone")String AdPhone,@RequestParam("AdEmail")String AdEmail,HttpServletRequest request){
        userService.UpdateBookadmin(AdIdx,AdName,AdPassword,AdPhone,AdEmail,AdId);
        BookAdmin bookAdmin=userService.findAllBookAdmin2(AdIdx);
        request.getSession().setAttribute("bookAdminss2", bookAdmin);
        request.getSession().setAttribute("bookminxiugaicg", "<script>alert(\"修改成功\");</script>");
        return "adminAlterAd";
    }

    @RequestMapping("/adminPersonal_xiugai")
    public String adminPersonal_xiugai(@RequestParam("AdminName") String AdminName, @RequestParam("ypassword") String yPassword, @RequestParam("xpassword") String xPassword, @RequestParam("qpassword") String qPassword, @RequestParam("adminPhone") String adminPhone, @RequestParam("adminEmail") String adminEmail, HttpServletRequest request) {
      SystemAdmin systemAdmin = userService.getSystemAdmin(AdminName);
        if (yPassword.isEmpty()) {
            request.getSession().setAttribute("ymimano1", "<script>alert(\"请输入原密码\");</script>");
            return "adminPersonal";
        } else if (yPassword.equals(systemAdmin.getAdminPassword())) {
            if (xPassword.isEmpty() && qPassword.isEmpty()) {
                userService.UpdateSystemadmininfo(adminPhone,adminEmail,AdminName);
                request.getSession().setAttribute("xinxicg1", "<script>alert(\"修改信息成功\");</script>");
                SystemAdmin systemAdmin1= userService.getgetSystemAdminlist(systemAdmin.getAdminId());
                request.getSession().setAttribute("systemAdmin1", systemAdmin1);
                return "adminPersonal";
            } else if (qPassword == null) {
                request.getSession().setAttribute("qmima1", "<script>alert(\"没有输入确认新密码\");</script>");
                return "adminPersonal";
            } else if (xPassword.equals(qPassword)) {
                userService.UpdateSystemadminPassword(xPassword,AdminName);
                request.getSession().setAttribute("mimacg1", "<script>alert(\"修改密码成功,请重新登录\");</script>");
                return "login";
            } else {
                request.getSession().setAttribute("mimabu1", "<script>alert(\"两次密码不匹配\");</script>");
                return "adminPersonal";
            }
        } else {
            request.getSession().setAttribute("mimacw1", "<script>alert(\"原密码错误\");</script>");
            return "adminPersonal";
        }
    }

    //验证微信登录
    @RequestMapping("/Weixin_Login")
    public void Weixin_Login(@RequestParam("Weixin_name") String name, @RequestParam("Weixin_Password") String password,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user1 = new User();
        user1.setUserName(name);
        user1.setPassword(password);
        System.out.println(name);
        System.out.println(password);
        User user2 = userService.logincheck1(user1);
        Writer out = response.getWriter();
        if(user2!=null){
            out.write("登录成功");
        }
        else {
            out.write("通行证或密码错误");
        }
    }
    @RequestMapping("/Weixin_Info")
    public void Weixin_Info(@RequestParam("Weixin_name") String name,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        UserInfo userInfo = userService.getUserInfo(name);
        String json = new Gson().toJson(userInfo);
        Writer out = response.getWriter();
        if(json!=null){
            out.write(json);
        }
        else {
            out.write(json);
        }
    }
}
