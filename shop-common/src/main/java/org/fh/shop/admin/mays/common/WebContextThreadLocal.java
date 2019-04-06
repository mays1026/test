/** 
 * <pre>项目名称:lalal 
 * 文件名称:WebContextThreadLocal.java 
 * 包名:org.fh.shop.admin.mys.common 
 * 创建日期:2019年1月31日下午10:43:32 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.common;

import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：lalal    
 * 类名称：WebContextThreadLocal    
 * 类描述：    通过filter与request绑定的工具类
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午10:43:32    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午10:43:32    
 * 修改备注：       
 * @version </pre>    
 */
public class WebContextThreadLocal {

	private static ThreadLocal<HttpServletRequest> contextRequest = new ThreadLocal<HttpServletRequest>();
	
	/**
	 * <pre>setRequest(将request与当前线程绑定)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月31日 下午10:53:48    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月31日 下午10:53:48    
	 * 修改备注： 
	 * @param request</pre>
	 */
	public static void setRequest(HttpServletRequest request) {
		contextRequest.set(request);
	}
	
	/**
	 * <pre>getRequest(得到request)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月31日 下午10:53:34    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月31日 下午10:53:34    
	 * 修改备注： 
	 * @return</pre>
	 */
	public static HttpServletRequest getRequest() {
		return contextRequest.get();
	}
	
	/**
	 * <pre>remove(解除绑定)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月31日 下午10:53:10    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月31日 下午10:53:10    
	 * 修改备注： </pre>
	 */
	public static void remove() {
		contextRequest.remove();
	}
}
