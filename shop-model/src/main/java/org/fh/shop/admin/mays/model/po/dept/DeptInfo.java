package org.fh.shop.admin.mays.model.po.dept;

import org.fh.shop.admin.mays.model.PageInfo;

import java.io.Serializable;

/**
 * 类名: DeptInfo
 * 描述：
 *
 * @author
 * @create 2019-03-03 14:23
 **/

public class DeptInfo extends PageInfo implements Serializable {
    private static final long serialVersionUID = -6958573341726888594L;
    //主键
    private Integer id;
    //部门名称
    private String industryTitle;
    //父节点id
    private Integer pid;
    //描述
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryTitle() {
        return industryTitle;
    }

    public void setIndustryTitle(String industryTitle) {
        this.industryTitle = industryTitle;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "id=" + id +
                ", industryTitle='" + industryTitle + '\'' +
                ", pid=" + pid +
                ", remark='" + remark + '\'' +
                '}';
    }
}
