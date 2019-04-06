package org.fh.shop.admin.mays.model.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名: MemberInfo
 * 描述：
 *
 * @author MYS
 * @create 2019-03-25 21:29
 */

public class MemberInfo implements Serializable {

    private static final long serialVersionUID = 6086375383653797488L;
    //会员id
    private Integer id;
    //会员名称
    private String userName;
    //会员密码
    private String password;
    //会员电话
    private String phone;
    //会员邮箱
    private String email;
    //会员生日
    private Date birthday;
    //会员登录时间
    private Date regTime;
    //会员错误登录时间
    private Date lastLoginTime;
    //会员头像
    private String headPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }
}
