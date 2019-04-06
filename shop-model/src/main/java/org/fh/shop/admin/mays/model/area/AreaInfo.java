package org.fh.shop.admin.mays.model.area;

import org.fh.shop.admin.mays.model.PageInfo;

import java.io.Serializable;

/**
 * 类名: AreaInfo
 * 描述：
 *
 * @author
 * @create 2019-03-12 21:38
 **/

public class AreaInfo extends PageInfo implements Serializable {

    private static final long serialVersionUID = -3792492450871555484L;

    private Integer id;
    private String areaname;
    private Integer parentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "AreaInfo{" +
                "id=" + id +
                ", areaname='" + areaname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
