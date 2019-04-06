/** 
 * <pre>项目名称:lalal 
 * 文件名称:LogsAspect.java 
 * 包名:org.fh.shop.admin.mays.aspect 
 * 创建日期:2019年1月30日下午3:43:57 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.fh.shop.admin.mays.annontation.Log;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.common.WebContextThreadLocal;
import org.fh.shop.admin.mays.model.logs.LogsInfo;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.service.logs.ILogsService;
import org.fh.shop.admin.mays.staticFinal.SystemStauts;
import org.fh.shop.admin.mays.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/** 
 * <pre>项目名称：lalal    
 * 类名称：LogsAspect    
 * 类描述：    日志切面类
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月30日 下午3:43:57    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月30日 下午3:43:57    
 * 修改备注：       
 * @version </pre>    
 */
public class LogsAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogsAspect.class);

	@Resource
	private ILogsService logsService;
	public Object logAspect(ProceedingJoinPoint proceedingJoinPoint) {
		long startTime = System.currentTimeMillis();
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取类名
		String className = proceedingJoinPoint.getTarget().getClass().getCanonicalName();
		//获取方法名
		String methodName = proceedingJoinPoint.getSignature().getName()+"()";
		//获得方法签名
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		//通过方法签名获得方法
		Method method = signature.getMethod();
		LogsInfo logsInfo = new LogsInfo();
		String value = "";
		//判断目标方法上是否含有指定注解
		if (method.isAnnotationPresent(Log.class)) {
			//创建该注解对象
			Log annotation = method.getAnnotation(Log.class);
			//获取注解的值
			value = annotation.value();
		}
		Object result;
		UserInfo user;
		logsInfo.setCreateTime(DateUtils.getDateNow());
		logsInfo.setInfo(className+"_"+methodName);
		try {
			result = proceedingJoinPoint.proceed();
			user = (UserInfo) WebContextThreadLocal.getRequest().getSession().getAttribute("user");
			if (user == null) {
				return result;
			}
			logsInfo.setUserName(user.getUserName());
			logsInfo.setStatus(SystemStauts.SYSTEM_SUCCESS);
			long endTime = System.currentTimeMillis();
			logsInfo.setUseTime(endTime-startTime+"ms");
			logsInfo.setInfoStr("用户"+user.getUserName()+"执行"+value+"成功");
			logsService.addLogs(logsInfo);
			LOGGER.info("{}进入{}, 执行{}成功, 耗时{}ms", user.getUserName(), className, methodName, (endTime-startTime));
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
			long endTime = System.currentTimeMillis();
			user = (UserInfo) WebContextThreadLocal.getRequest().getSession().getAttribute("user");
			if (user == null) {
				return ServiceResponse.error();
			}
			logsInfo.setUserName(user.getUserName());
			logsInfo.setStatus(SystemStauts.SYSTEM_ERROR);
			logsInfo.setUseTime(endTime-startTime+"ms");
			logsInfo.setInfoStr("用户"+user.getUserName()+"执行"+value+"失败");
			logsService.addLogs(logsInfo);
			LOGGER.error("{}进入{}, 执行{}失败, 耗时{}ms", user.getUserName(), className, methodName, (endTime-startTime));
			//获取request请求头，判断请求类型是否为ajax(XMLHttpRequest)
			String requestedWith = WebContextThreadLocal.getRequest().getHeader("x-requested-with");
			//equalsIgnoreCase()不区分大小写判断值是否相等
			if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
                return ServiceResponse.error();
            } else {
                return "/error";
            }
		}
	}
	
}
