package cn.kcsj.Dao;

import cn.kcsj.javaBean.BookInfo;

import cn.kcsj.javaBean.BorrowRecords;
import cn.kcsj.javaBean.BorrowRecordsjilu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 书籍信息Dao接口
 */

@Repository
public interface BookDao {
    //查询所有书籍信息（测试）
    @Select("select * from bookinfo")
    public List<BookInfo> findAllBookInfo();

    //图书管理员新书入库
    @Insert("insert into bookinfo (BookId,BookName,Author,Translator,Price,ISBNCode,ComeUpTime,PublishCompany,State,EnteringMen,EnteringDate,Number) " +
            "values (#{BookId},#{BookName},#{Author},#{Translator},#{Price},#{ISBNCode},#{ComeUpTime},#{PublishCompany},#{State},#{EnteringMen},#{EnteringDate},#{Number})")
    public void insertBookInfo(BookInfo bookInfo);

    //按书名查询书籍详情（首页搜索）
    @Select("select * from bookinfo where bookinfo.BookName like concat('%',#{BookName},'%')")
    public List<BookInfo> findNameBookInfo(String BookName);

    //图书管理员根据图书编号查询图书
    @Select("select * from bookinfo where BookId=#{BookId}")
    public BookInfo getBookInfo_BookId(String BookId);


    //图书管理员删除图书（图书出库）
    @Delete("delete from bookinfo where BookId=#{BookId};")
    public void DelBook(String BookId);

    //图书管理员修改图书信息
    @Update("update bookinfo set BookName=#{arg1},Author=#{arg2},Translator=#{arg3},Price=#{arg4},ISBNCode=#{arg5},ComeUpTime=#{arg6},PublishCompany=#{arg7},State=#{arg8},EnteringMen=#{arg9},Number=#{arg10}  where BookId=#{arg0};")
    public void update(String BookId,String BookName,String Author,String Translator,
            float Price ,
             String ISBNCode,  //ISBN编码
             String ComeUpTime, //出版日期
             String PublishCompany, //出版社
             int State,  //图书状态（0借出;1在库）
             String EnteringMen, //入库者
             int Number);

    //通过借阅号查询在借图书
    @Select("select * from borrowrecords where UserId=#{arg0} and State=#{arg1}")
    public List<BorrowRecords> getBorrowRecords(String UserId,int State);

    //图书管理员借书
    @Insert("insert into borrowrecords (UserId,BookId,BookName,BorrowTime,ShouldTime,State) values (#{arg0},#{arg1},#{arg2},#{arg3},#{arg4},#{arg5})")
    public void insertBorrowRecords(String UserId,String BookId,String BookName,String BorrowTime,String ShouldTime,int State);

    //读者还书
    @Update("update borrowrecords set ReturnTime=#{arg1},State=1 where BookId=#{arg0} and UserId=#{arg2}")
    public void huanshu(String BookId,String ReturnTime,String UserId);

    //查询借阅记录
    @Select("Select * from borrowrecords where BookId=#{arg0} or BookName=#{arg0} or UserId=#{arg0}")
    public  List<BorrowRecords> select(String arg);

    //图书管理员查询借阅记录
    @Select("select * from(select borrowrecords.UserId,borrowrecords.BookId,borrowrecords.BookName,borrowrecords.ShouldTime,borrowrecords.ReturnTime,bookinfo.Author,bookinfo.Translator,bookinfo.Price,bookinfo.ISBNCode,bookinfo.ComeUpTime,bookinfo.PublishCompany,bookinfo.EnteringMen from bookinfo INNER JOIN borrowrecords ON bookinfo.BookId=borrowrecords.BookId)b where b.BookId=#{arg0} or b.BookName=#{arg0} or b.UserId=#{arg0}")
    public List<BorrowRecordsjilu> BORROW_RECORDSJILU_LIST(String BookId);
}
