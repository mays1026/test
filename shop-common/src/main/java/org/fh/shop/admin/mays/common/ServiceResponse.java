/** 
 * <pre>项目名称:lalal 
 * 文件名称:ServiceResponse.java 
 * 包名:com.fh.shop.backend.beanEnum 
 * 创建日期:2019年1月11日下午1:02:48 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.common;

import java.io.Serializable;

/** 
 * <pre>项目名称：lalal    
 * 类名称：ServiceResponse    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月11日 下午1:02:48    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月11日 下午1:02:48    
 * 修改备注：       
 * @version </pre>    
 */
public class ServiceResponse implements Serializable{
	private static final long serialVersionUID = 7933703061071035730L;
	private int code;
	private String message;
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private Object data;
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}

	public Integer getDraw() {
		return draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * <pre>创建一个新的实例 ServiceResponse.    
	 * @param code
	 * @param message
	 * @param data</pre>    
	 */
	private ServiceResponse(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * <pre>success(返回一个成功状态的对象)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月11日 下午1:06:36    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月11日 下午1:06:36    
	 * 修改备注： 
	 * @return</pre>
	 */
	public static ServiceResponse success() {
		return new ServiceResponse(ServiceResponseEnum.SUCCESS.getCode(), ServiceResponseEnum.SUCCESS.getMessage(), null);
	}
	
	/**
	 * <pre>error(返回一个失败状态的对象)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月11日 下午1:09:00    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月11日 下午1:09:00    
	 * 修改备注： 
	 * @return</pre>
	 */
	public static ServiceResponse error(ServiceResponseEnum serviceResponseEnum) {
		return new ServiceResponse(serviceResponseEnum.getCode(), serviceResponseEnum.getMessage(), null);
	}
	
	/** <pre>error(try-catch返回系统错误)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月15日 下午6:54:39    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月15日 下午6:54:39    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public static ServiceResponse error() {
		return new ServiceResponse(ServiceResponseEnum.USER_SYSTEM_ERROR.getCode(), ServiceResponseEnum.USER_SYSTEM_ERROR.getMessage(), null);
	}
	
	/** <pre>success(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月21日 下午2:29:31    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月21日 下午2:29:31    
	 * 修改备注： 
	 * @return</pre>    
	 */
	public static ServiceResponse success(Object object) {
		return new ServiceResponse(ServiceResponseEnum.SUCCESS.getCode(), ServiceResponseEnum.SUCCESS.getMessage(), object);
	}
	
}
