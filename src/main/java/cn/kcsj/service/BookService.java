package cn.kcsj.service;

import cn.kcsj.javaBean.BookInfo;
import cn.kcsj.javaBean.BorrowRecords;
import cn.kcsj.javaBean.BorrowRecordsjilu;


import java.util.List;

public interface BookService {
    //查询所有书籍信息
    public List<BookInfo> findAllBookInfo();

    //插入书籍信息
    public void insertBookInfo(BookInfo bookInfo);

    //按书名查找书籍信息
    public List<BookInfo> findNameBookInfo(String name);

    //根据图书编号查找图书信息
    public BookInfo getBookInfo_BookId(String BookId);


    public void DelBook(String BookId);

    public void update(String BookId,String BookName,String Author,String Translator, float Price , String ISBNCode, String ComeUpTime, String PublishCompany, int State, String EnteringMen, int Number);

    public List<BorrowRecords> getBorrowRecords(String UserId,int State);

    public void insertBorrowRecords(String UserId,String BookId,String BookName,String BorrowTime,String ShouldTime,int State);

    public void huanshu(String BookId,String ReturnTime,String UserId);

    public  List<BorrowRecords> select(String arg);
    public List<BorrowRecordsjilu> BORROW_RECORDSJILU_LIST(String BookId);

}
