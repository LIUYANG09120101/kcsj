package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 借阅记录信息
 */
public class BorrowRecords implements Serializable {
    private int BorrowID; //借阅记录ID
    private String UserId; //用户ID
    private String BookId; //图书ID
    private String BookName; //书名
    private String BorrowTime; //借书时间
    private String ShouldTime; //预还书时间
    private String ReturnTime;  //实际还书时间
    private int State;  //借阅状态（0借出;1已还）

    public int getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(int borrowID) {
        BorrowID = borrowID;
    }

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

    public String getBorrowTime() {
        return BorrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        BorrowTime = borrowTime;
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

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    @Override
    public String toString() {
        return "BorrowRecords{" +
                "BorrowID=" + BorrowID +
                ", UserId='" + UserId + '\'' +
                ", BookId='" + BookId + '\'' +
                ", BookName='" + BookName + '\'' +
                ", BorrowTime='" + BorrowTime + '\'' +
                ", ShouldTime='" + ShouldTime + '\'' +
                ", ReturnTime='" + ReturnTime + '\'' +
                ", State=" + State +
                '}';
    }
}
