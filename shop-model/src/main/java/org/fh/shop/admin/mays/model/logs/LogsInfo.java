package org.fh.shop.admin.mays.model.logs;

import org.fh.shop.admin.mays.model.PageInfo;

import java.io.Serializable;
import java.util.Date;

public class LogsInfo extends PageInfo implements Serializable {
    private static final long serialVersionUID = -2151609739722359728L;
    private Integer id;
    private String userName;
    private String info;
    private Integer status;
    private String useTime;
    private String infoStr;

    public String getInfoStr() {
        return infoStr;
    }

    public void setInfoStr(String infoStr) {
        this.infoStr = infoStr;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }

    @Override
    public String toString() {
        return "LogsInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", useTime='" + useTime + '\'' +
                ", infoStr='" + infoStr + '\'' +
                '}';
    }
}
