/** 
 * <pre>项目名称:lalal 
 * 文件名称:UserInfo.java 
 * 包名:org.fh.shop.admin.mays.model.po.user
 * 创建日期:2019年1月31日下午11:03:37 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.model.po.user;

import org.fh.shop.admin.mays.model.PageInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：UserInfo    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午11:03:37    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午11:03:37    
 * 修改备注：       
 * @version </pre>    
 */
public class UserInfo extends PageInfo implements Serializable{

	private static final long serialVersionUID = 2264584858370445630L;
	private Integer id;
	private String userName;
	private String userPassword;
	//验证码
	private String imgCode;
	private String salt;
	//用户状态
	private Integer stauts;
	private Date loginDate;
	private Integer loginCount;
	//用户登录错误
	private Date errorLoginDate;
	private Integer errorLoginCount;

	private String userRealName;
	private Date birthday;
	private Integer sex;
	//部门id
	private Integer deptId;
	//部门名称
    private String industryTitle;
	//工资
	private String salary;
    //部门id list
	private List<Integer> deptList;

	private String imagePath;
	private String oldImagePath;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStauts() {
        return stauts;
    }

    public void setStauts(Integer stauts) {
        this.stauts = stauts;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getErrorLoginDate() {
        return errorLoginDate;
    }

    public void setErrorLoginDate(Date errorLoginDate) {
        this.errorLoginDate = errorLoginDate;
    }

    public Integer getErrorLoginCount() {
        return errorLoginCount;
    }

    public void setErrorLoginCount(Integer errorLoginCount) {
        this.errorLoginCount = errorLoginCount;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIndustryTitle() {
        return industryTitle;
    }

    public void setIndustryTitle(String industryTitle) {
        this.industryTitle = industryTitle;
    }

    public List<Integer> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Integer> deptList) {
        this.deptList = deptList;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOldImagePath() {
        return oldImagePath;
    }

    public void setOldImagePath(String oldImagePath) {
        this.oldImagePath = oldImagePath;
    }
}
