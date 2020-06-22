package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 图书管理员
 */
public class BookAdmin implements Serializable {
    private String AdId;  //图书管理员ID
    private String AdName;  //图书管理员名
    private String AdPassword; //用户密码
    private String AdPhone;  //联系电话
    private String AdEmail; //邮箱

    public String getAdId() {
        return AdId;
    }

    public void setAdId(String adId) {
        AdId = adId;
    }

    public String getAdName() {
        return AdName;
    }

    public void setAdName(String adName) {
        AdName = adName;
    }

    public String getAdPassword() {
        return AdPassword;
    }

    public void setAdPassword(String adPassword) {
        AdPassword = adPassword;
    }

    public String getAdPhone() {
        return AdPhone;
    }

    public void setAdPhone(String adPhone) {
        AdPhone = adPhone;
    }

    public String getAdEmail() {
        return AdEmail;
    }

    public void setAdEmail(String adEmail) {
        AdEmail = adEmail;
    }

    @Override
    public String toString() {
        return "BookAdmin{" +
                "AdId='" + AdId + '\'' +
                ", AdName='" + AdName + '\'' +
                ", AdPassword='" + AdPassword + '\'' +
                ", AdPhone='" + AdPhone + '\'' +
                ", AdEmail='" + AdEmail + '\'' +
                '}';
    }
}
