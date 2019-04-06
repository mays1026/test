/**
 * <pre>项目名称:lalal
 * 文件名称:UserServiceImpl.java
 * 包名:org.fh.shop.admin.mays.service.user
 * 创建日期:2019年1月31日下午11:11:52
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.service.user;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.dao.user.IUserDao;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.util.QQCOSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>项目名称：lalal    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午11:11:52    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午11:11:52    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserInfo login(String userName) {
        return userDao.login(userName);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userDao.addUser(userInfo);
    }

    @Override
    public void updateUserLoginDate(UserInfo userInfo) {
        userDao.updateUserLoginDate(userInfo);
    }

    @Override
    public void updateUserWhereLoginError(UserInfo user) {
        userDao.updateUserWhereLoginError(user);
    }

    /**
     * 计算符合条件的用户人数
     * @param userInfo
     * @return
     */
    @Override
    public Long countUserListSize(UserInfo userInfo) {
        return userDao.countUserListSize(userInfo);
    }

    @Override
    public List<UserInfo> findUserList(UserInfo userInfo) {
        /**
         * List<NameValuePair> list = new ArrayList<NameValuePair>();
         *         list.add(new BasicNameValuePair("userName", userInfo.getUserName()));
         *         String s = HttpClientUtil.postResponse("http://192.168.1.54:8088/api/user/findUserList.action", list);
         *         Gson gson = new Gson();
         *         UserServiceResponse userServiceResponse = gson.fromJson(s, UserServiceResponse.class);
         *         return userServiceResponse;
         */
        return userDao.findUserList(userInfo);
    }

    /**
     * 解锁用户
     * @param id
     */
    @Override
    public void unlockUser(Integer id) {
        userDao.unlockUser(id);
    }

    @Override
    public void deleteAllUserInfo(List<Integer> ids) {
        //查询数据库 并删除云服务器上的文件
        findImagePathByIds(ids);
        userDao.deleteAllUserInfo(ids);
    }

    /**
     * 修改用户
     * @param userInfo
     */
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        String oldImagePath = userInfo.getOldImagePath();
        String imagePath = userInfo.getImagePath();
        if (oldImagePath.equals(imagePath)) {
            userInfo.setImagePath(oldImagePath);
        } else {
            QQCOSUtil.deleteCOSFile(oldImagePath);
        }
        userDao.updateUserInfo(userInfo);
    }

    /**
     * 批量更换部门
     * @param userInfo
     * @return
     */
    @Override
    public ServiceResponse updateUserDept(UserInfo userInfo) {
        userDao.updateUserDept(userInfo);
        return ServiceResponse.success();
    }

    /**
     * 通过给定的ids集合查询数据库后 删除云服务器上的文件
     * @param ids
     */
    public void findImagePathByIds(List<Integer> ids) {
        //查询所删除的用户中的图片
        List<String> list = userDao.findImagePathByUserId(ids);
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                QQCOSUtil.deleteCOSFile(list.get(i));
            }
        }
    }
}
