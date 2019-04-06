/** 
 * <pre>项目名称:lalal 
 * 文件名称:IUserService.java 
 * 包名:org.fh.shop.admin.mays.service.user 
 * 创建日期:2019年1月31日下午11:11:34 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.service.user;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.user.UserInfo;

import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：IUserService    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午11:11:34    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午11:11:34    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserService {

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月31日 下午11:16:55    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月31日 下午11:16:55    
	 * 修改备注： 
	 * @param userName
	 * @return</pre>    
	 */
	UserInfo login(String userName);

    void addUser(UserInfo userInfo);

    void updateUserLoginDate(UserInfo userInfo);

    void updateUserWhereLoginError(UserInfo user);

    Long countUserListSize(UserInfo userInfo);

	List<UserInfo> findUserList(UserInfo userInfo);

    void unlockUser(Integer id);

	void deleteAllUserInfo(List<Integer> ids);

    void updateUserInfo(UserInfo userInfo);

    ServiceResponse updateUserDept(UserInfo userInfo);
}
