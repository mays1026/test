/** 
 * <pre>项目名称:lalal 
 * 文件名称:IUserDao.java 
 * 包名:org.fh.shop.admin.mays.dao.user 
 * 创建日期:2019年1月31日下午11:12:58 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.dao.user;

import org.fh.shop.admin.mays.model.po.user.UserInfo;

import java.util.List;

/** 
 * <pre>项目名称：lalal    
 * 类名称：IUserDao    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午11:12:58    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午11:12:58    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserDao {

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：马优生 178249290@qq.com    
	 * 创建时间：2019年1月31日 下午11:38:38    
	 * 修改人：马优生 178249290@qq.com    
	 * 修改时间：2019年1月31日 下午11:38:38    
	 * 修改备注：
	 * @return</pre>    
	 */
	UserInfo login(String userName);

    void addUser(UserInfo userInfo);

    void updateUserLoginDate(UserInfo userInfo);

    void updateUserWhereLoginError(UserInfo user);

    Long countUserListSize(UserInfo userInfo);

	List<UserInfo> findUserList(UserInfo userInfo);

    void unlockUser(Integer id);

    void deleteUserInfoByDept(List<Integer> ids);

	void deleteAllUserInfo(List<Integer> ids);

    void updateUserInfo(UserInfo userInfo);

    void updateUserDept(UserInfo userInfo);

    List<UserInfo> findUserChidenWhereId(Integer id);

    List<String> findImagePathByUserId(List<Integer> ids);
}
