package cn.kcsj.controller;

import cn.kcsj.javaBean.BookInfo;
import cn.kcsj.javaBean.BorrowRecords;
import cn.kcsj.javaBean.BorrowRecordsjilu;
import cn.kcsj.javaBean.UserInfo;
import cn.kcsj.service.BookService;
import cn.kcsj.service.UserService;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/JSP")
public class BookController {
    public List<BookInfo> list;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    //查询所有书籍信息
    @RequestMapping("/findAllBookInfo")
    public String findAllUser(Model model){
        List<BookInfo> list = bookService.findAllBookInfo();
        model.addAttribute("BookInfolist",list);
        return "BookInfolist";
    }
    //根据书名搜索书籍信息（首页搜索）
    @RequestMapping("/findNameBookInfo")
    public String findNameBookInfo(Model model,BookInfo bookInfo){
        String name = bookInfo.getBookName();
        List<BookInfo> list = bookService.findNameBookInfo(name);
        model.addAttribute("Books",list);
        model.addAttribute("BookName",name);
        return "searchResult";
    }
    @RequestMapping("/findNameBookInfo1")
    public String findNameBookInfo1(Model model,BookInfo bookInfo,HttpServletRequest request){
        String name = bookInfo.getBookName();
        List<BookInfo> list = bookService.findNameBookInfo(name);
        if(list==null){
            request.getSession().setAttribute("kongsss","<script>alert(\"没有搜索到\");</script>");
        }
        else if(list!=null){
            model.addAttribute("Books",list);
            model.addAttribute("BookName",name);
        }
        return "adSearchBook";
    }
    //图书管理员验证图书信息
    @RequestMapping("/check")
    public String check(Model model, @RequestParam("BookId")String BookId,@RequestParam("UserId")String UserId,HttpServletRequest request){
        BookInfo bookInfo1= bookService.getBookInfo_BookId(BookId);
        UserInfo userInfo=userService.getUserInfo(UserId);
        System.out.println(bookInfo1);
        System.out.println(userInfo);
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String now = df.format(d);
        List<BorrowRecords> BorrowRecordsList = (List<BorrowRecords>) request.getSession().getAttribute("BorrowRecordsList");
        BorrowRecords borrowRecords = new BorrowRecords();
        if(bookInfo1!=null&&userInfo!=null){
            if(bookInfo1.getState() == 1){
                borrowRecords.setBookId(bookInfo1.getBookId());
                borrowRecords.setBookName(bookInfo1.getBookName());
                borrowRecords.setBorrowTime(now);
                borrowRecords.setUserId(userInfo.getUserId());
                borrowRecords.setShouldTime("2020-07-01");
                borrowRecords.setState(0);
                if(BorrowRecordsList==null){
                    BorrowRecordsList=new ArrayList<>();
                }
                BorrowRecordsList.add(borrowRecords);
                //bookService.insertBorrowRecords(userInfo.getUserId(),bookInfo1.getBookId(),bookInfo1.getBookName(),now,"2020-07-05",0);
                //request.getSession().setAttribute("s","<script>alert(\"借书成功\");</script>");
                request.getSession().setAttribute("BorrowRecordsList",BorrowRecordsList);
                return "adBorrowBook";
            }
            else {
                request.getSession().setAttribute("BorrowRecordsList",BorrowRecordsList);
                request.getSession().setAttribute("error","<script>alert(\"该图书已被借出\");</script>");
                return "adBorrowBook";
            }
        }
        else {
            request.getSession().setAttribute("BorrowRecordsList",BorrowRecordsList);
            request.getSession().setAttribute("error","<script>alert(\"账户或图书编号错误\");</script>");
            return "adBorrowBook";
        }
    }
    //管理员添加图书信息
    @RequestMapping("/insertBookInfo")
    public String insertInfo(@RequestParam("BookId")String BookId,@RequestParam("BookName")String BookName,@RequestParam("Author")String Author,
                           @RequestParam("Translator")String Translator,@RequestParam("Price")String Price,@RequestParam("ISBNCode")String ISBNCode,
                           @RequestParam("ComeUpTime")String ComeUpTime,@RequestParam("PublishCompany")String PublishCompany,@RequestParam("EnteringMen")String EnteringMen,
                           HttpServletResponse response, HttpServletRequest request) throws IOException {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String now = df.format(d);
        BookInfo bookInfo = new BookInfo();
        bookInfo.setAuthor(Author);
        bookInfo.setBookId(BookId);
        bookInfo.setBookName(BookName);
        bookInfo.setComeUpTime(ComeUpTime);
        bookInfo.setTranslator(Translator);
        bookInfo.setISBNCode(ISBNCode);
        bookInfo.setEnteringMen(EnteringMen);
        bookInfo.setPrice(Float.parseFloat(Price));
        bookInfo.setPublishCompany(PublishCompany);
        bookInfo.setState(1);
        bookInfo.setEnteringDate(now);
        bookService.insertBookInfo(bookInfo);
        request.getSession().setAttribute("添加","<script>alert(\"入库成功\");</script>");
        return "adAddBook";
    }
    @RequestMapping("/DelBook")
    public String DelBook(@RequestParam("BookId")String BookId, HttpServletRequest request) throws IOException {
        bookService.DelBook(BookId);
        request.getSession().setAttribute("删除","<script>alert(\"删除成功\");</script>");
        return "adOutBook";
    }
    @RequestMapping("/UpdateBook")
    public String UpdateBook(@RequestParam("BookId")String BookId,@RequestParam("BookName")String BookName,@RequestParam("Author")String Author,
                           @RequestParam("Translator")String Translator,@RequestParam("Price")String Price,@RequestParam("ISBNCode")String ISBNCode,
                           @RequestParam("ComeUpTime")String ComeUpTime,@RequestParam("PublishCompany")String PublishCompany,@RequestParam("EnteringMen")String EnteringMen,
                           @RequestParam("State")String State,@RequestParam("Number")String Number
                           , HttpServletRequest request) throws IOException {
        bookService.update(BookId,BookName,Author,Translator,Float.parseFloat(Price),ISBNCode,ComeUpTime,PublishCompany,Integer.parseInt(State),EnteringMen,Integer.parseInt(Number));
        request.getSession().setAttribute("修改","<script>alert(\"修改成功\");</script>");
        return "adAlterBook";
    }
    @RequestMapping("/getBookInfo")
    public String getBookInfo(@RequestParam("BookId")String BookId ,Model model,HttpServletRequest request) throws IOException {
        BookInfo bookInfo=bookService.getBookInfo_BookId(BookId);
        if(bookInfo==null){
            request.getSession().setAttribute("为空","<script>alert(\"没有这本书\");</script>");
        }
        else{
            model.addAttribute("books",bookInfo);
        }
        return "adAlterBook";
    }
    @RequestMapping("/getBookInfo1")
    public String getBookInfo1(@RequestParam("BookId")String BookId ,Model model,HttpServletRequest request) throws IOException {
        BookInfo bookInfo=bookService.getBookInfo_BookId(BookId);
        if(bookInfo==null){
            request.getSession().setAttribute("为空","<script>alert(\"没有这本书\");</script>");
        }
        else{
            model.addAttribute("books",bookInfo);
        }
        return "adOutBook";
    }
    @RequestMapping("/insterBorrowBook")
    public String insterBorrowBook(HttpServletRequest request) throws IOException {
        List<BorrowRecords> borrowRecordsList =(List<BorrowRecords>) request.getSession().getAttribute("BorrowRecordsList");
        for(int i=0;i<borrowRecordsList.size();i++){
            bookService.insertBorrowRecords(borrowRecordsList.get(i).getUserId(),borrowRecordsList.get(i).getBookId(),borrowRecordsList.get(i).getBookName(),borrowRecordsList.get(i).getBorrowTime(),borrowRecordsList.get(i).getShouldTime(),borrowRecordsList.get(i).getState());
        }
        request.getSession().setAttribute("BorrowRecordsList","");
        request.getSession().setAttribute("s","<script>alert(\"借书成功\");</script>");
        return "adBorrowBook";
    }
    @RequestMapping("/huanshu")
    public String huanshu(@RequestParam("BookId")String BookId,@RequestParam("UserId")String UserId,HttpServletRequest request){
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String now = df.format(d);
        bookService.huanshu(BookId,now,UserId);
        request.getSession().setAttribute("还书","<script>alert(\"还书成功\");</script>");
        return "adReturnBook";
    }

    @RequestMapping("/shousuo")
    public String shousuo(@RequestParam("arg")String arg,HttpServletRequest request){
        List<BorrowRecords> borrowRecordsListsss = bookService.select(arg);
        request.getSession().setAttribute("borrowRecordsListsss",borrowRecordsListsss);
        return "adCheckBook";
    }
    @RequestMapping("/adCheckBookss")
    public String adCheckBook(@RequestParam("BookId")String BookId,HttpServletRequest request){
        List<BorrowRecordsjilu> borrowRecordsjiluList =bookService.BORROW_RECORDSJILU_LIST(BookId);
        System.out.println(borrowRecordsjiluList);
        request.getSession().setAttribute("borrowRecordsjiluList",borrowRecordsjiluList);
        return "adCheckBook";
    }

    @RequestMapping("/Weixin_searchBook")
    public void Weixin_searchBook(@RequestParam("Weixin_BookName") String Weixin_BookName,HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(Weixin_BookName);
        List<BookInfo> bookInfoslist = bookService.findNameBookInfo(Weixin_BookName);
        Map<Integer, BookInfo> result = new HashMap<Integer, BookInfo>();
        for(int i=0;i<bookInfoslist.size();i++){
            result.put(i,bookInfoslist.get(i));
        }
        System.out.println(result);
        String json = new Gson().toJson(result);
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }
}
