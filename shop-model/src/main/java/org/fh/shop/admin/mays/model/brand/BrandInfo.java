/** 
 * <pre>项目名称:ssm_shop_v2 
 * 文件名称:Brand.java 
 * 包名:com.fh.shop.backend.bean.brand 
 * 创建日期:2018年12月28日上午10:17:01 
 * Copyright (c) 2018, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.model.brand;

import java.io.Serializable;

import org.fh.shop.admin.mays.model.PageInfo;

/** 
 * <pre>项目名称：ssm_shop_v2    
 * 类名称：Brand    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2018年12月28日 上午10:17:01    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2018年12月28日 上午10:17:01    
 * 修改备注：       
 * @version </pre>    
 */
public class BrandInfo extends PageInfo implements Serializable{
	private static final long serialVersionUID = -1901273997447355155L;
	private Integer id;
	private String brandName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "BrandInfo [id=" + id + ", brandName=" + brandName + "]";
	}
	
}
