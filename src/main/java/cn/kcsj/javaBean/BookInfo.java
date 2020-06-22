package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 书籍详细信息
 */
public class BookInfo implements Serializable {
    private String BookId;  //图书ID
    private String BookName;  //图书名称
    private String Author;  //作者
    private String Translator;  //译者
    private float Price;  //价格
    private String ISBNCode;  //ISBN编码
    private String ComeUpTime; //出版日期
    private String PublishCompany; //出版社
    private int State;  //图书状态（0借出;1在库）
    private String EnteringMen; //入库者
    private String EnteringDate;  //入库日期
    private int Number;  //在库数量

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

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getEnteringMen() {
        return EnteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        EnteringMen = enteringMen;
    }

    public String getEnteringDate() {
        return EnteringDate;
    }

    public void setEnteringDate(String enteringDate) {
        EnteringDate = enteringDate;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "BookId='" + BookId + '\'' +
                ", BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", Translator='" + Translator + '\'' +
                ", Price=" + Price +
                ", ISBNCode='" + ISBNCode + '\'' +
                ", ComeUpTime='" + ComeUpTime + '\'' +
                ", PublishCompany='" + PublishCompany + '\'' +
                ", State=" + State +
                ", EnteringMen='" + EnteringMen + '\'' +
                ", EnteringDate='" + EnteringDate + '\'' +
                ", Number=" + Number +
                '}';
    }
}
