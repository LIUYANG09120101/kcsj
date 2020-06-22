package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * @ClassName BorrowRecordsjilu
 * @Description TODO
 * @Author 刘阳
 * @Date 2020/6/9 23:04
 */
public class BorrowRecordsjilu implements Serializable {
    private String UserId; //用户ID
    private String BookId; //图书ID
    private String BookName; //书名
    private String ShouldTime; //预还书时间
    private String ReturnTime;  //实际还书时间
    private String Author;  //作者
    private String Translator;  //译者
    private float Price;  //价格
    private String ISBNCode;  //ISBN编码
    private String ComeUpTime; //出版日期
    private String PublishCompany; //出版社
    private String EnteringMen; //入库者

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getShouldTime() {
        return ShouldTime;
    }

    public void setShouldTime(String shouldTime) {
        ShouldTime = shouldTime;
    }

    public String getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(String returnTime) {
        ReturnTime = returnTime;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTranslator() {
        return Translator;
    }

    public void setTranslator(String translator) {
        Translator = translator;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public String getComeUpTime() {
        return ComeUpTime;
    }

    public void setComeUpTime(String comeUpTime) {
        ComeUpTime = comeUpTime;
    }

    public String getPublishCompany() {
        return PublishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        PublishCompany = publishCompany;
    }

    public String getEnteringMen() {
        return EnteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        EnteringMen = enteringMen;
    }

    @Override
    public String toString() {
        return "BorrowRecordsjilu{" +
                "UserId='" + UserId + '\'' +
                ", BookId='" + BookId + '\'' +
                ", BookName='" + BookName + '\'' +
                ", ShouldTime='" + ShouldTime + '\'' +
                ", ReturnTime='" + ReturnTime + '\'' +
                ", Author='" + Author + '\'' +
                ", Translator='" + Translator + '\'' +
                ", Price=" + Price +
                ", ISBNCode='" + ISBNCode + '\'' +
                ", ComeUpTime='" + ComeUpTime + '\'' +
                ", PublishCompany='" + PublishCompany + '\'' +
                ", EnteringMen='" + EnteringMen + '\'' +
                '}';
    }
}
