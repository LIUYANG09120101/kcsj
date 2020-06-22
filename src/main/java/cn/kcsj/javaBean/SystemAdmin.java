package cn.kcsj.javaBean;

import java.io.Serializable;

/**
 * 系统管理员
 */
public class SystemAdmin implements Serializable {
    private String AdminId; //系统管理员ID
    private String AdminName;  //系统管理员名
    private String AdminPassword; //用户密码
    private String AdminPhone;  //联系电话
    private String AdminEmail;   //邮箱

    public String getAdminId() {
        return AdminId;
    }

    public void setAdminId(String adminId) {
        AdminId = adminId;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return AdminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        AdminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return AdminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        AdminEmail = adminEmail;
    }

    @Override
    public String toString() {
        return "SystemAdmin{" +
                "AdminId='" + AdminId + '\'' +
                ", AdminName='" + AdminName + '\'' +
                ", AdminPassword='" + AdminPassword + '\'' +
                ", AdminPhone='" + AdminPhone + '\'' +
                ", AdminEmail='" + AdminEmail + '\'' +
                '}';
    }
}
