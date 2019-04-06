/** 
 * <pre>项目名称:lalal 
 * 文件名称:ShopInfo.java 
 * 包名:com.fh.bean 
 * 创建日期:2019年1月25日下午7:44:07 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.model.shop;

import java.io.Serializable;
import java.util.Date;

import org.fh.shop.admin.mays.model.PageInfo;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ShopInfo    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月25日 下午7:44:07    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月25日 下午7:44:07    
 * 修改备注：       
 * @version </pre>    
 */
public class ShopInfo extends PageInfo implements Serializable{
	private static final long serialVersionUID = 4400788200875890117L;
	private Integer id;
	private String storeName;
	private String companyName;
	private Integer storeStatus;//店铺状态[storeStatus: 0关闭，1正常 ]，
	private Date closeTime;
	
	private Date minCloseTime;
	private Date maxCloseTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getStoreStatus() {
		return storeStatus;
	}
	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public Date getMinCloseTime() {
		return minCloseTime;
	}
	public void setMinCloseTime(Date minCloseTime) {
		this.minCloseTime = minCloseTime;
	}
	public Date getMaxCloseTime() {
		return maxCloseTime;
	}
	public void setMaxCloseTime(Date maxCloseTime) {
		this.maxCloseTime = maxCloseTime;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ShopInfo [id=" + id + ", storeName=" + storeName + ", companyName=" + companyName + ", storeStatus="
				+ storeStatus + ", closeTime=" + closeTime + ", minCloseTime=" + minCloseTime + ", maxCloseTime="
				+ maxCloseTime + "]";
	}
	
}
