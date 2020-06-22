package cn.kcsj.service.impl;

import cn.kcsj.Dao.BookDao;
import cn.kcsj.javaBean.BookInfo;
import cn.kcsj.javaBean.BorrowRecords;
import cn.kcsj.javaBean.BorrowRecordsjilu;
import cn.kcsj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author 刘阳
 * @Date 2020/6/2 20:19
 *
 * 实现BookInfoService接口
 */
@Service("bookinfoService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<BookInfo> findAllBookInfo() {
        return bookDao.findAllBookInfo();
    }

    @Override
    public void insertBookInfo(BookInfo bookInfo) {
        bookDao.insertBookInfo(bookInfo);
    }

    @Override
    public List<BookInfo> findNameBookInfo(String name) {
        return bookDao.findNameBookInfo(name);
    }

    @Override
    public BookInfo getBookInfo_BookId(String BookId) {
        return bookDao.getBookInfo_BookId(BookId);
    }


    @Override
    public void DelBook(String BookId) {
        bookDao.DelBook(BookId);
    }

    @Override
    public void update(String BookId, String BookName, String Author, String Translator, float Price, String ISBNCode, String ComeUpTime, String PublishCompany, int State, String EnteringMen, int Number) {
        bookDao.update(BookId,BookName,Author,Translator,Price,ISBNCode,ComeUpTime,PublishCompany,State,EnteringMen,Number);
    }

    @Override
    public List<BorrowRecords> getBorrowRecords(String UserId, int State) {
        return bookDao.getBorrowRecords(UserId,State);
    }

    @Override
    public void insertBorrowRecords(String UserId, String BookId, String BookName, String BorrowTime, String ShouldTime, int State) {
        bookDao.insertBorrowRecords(UserId,BookId,BookName,BorrowTime,ShouldTime,State);
    }

    @Override
    public void huanshu(String BookId, String ReturnTime, String UserId) {
        bookDao.huanshu(BookId,ReturnTime,UserId);
    }

    @Override
    public List<BorrowRecords> select(String arg) {
        return bookDao.select(arg);
    }

    @Override
    public List<BorrowRecordsjilu> BORROW_RECORDSJILU_LIST(String BookId) {
        return bookDao.BORROW_RECORDSJILU_LIST(BookId);
    }


}
