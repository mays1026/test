/**
 * <pre>项目名称:lalal
 * 文件名称:UserInfo.java
 * 包名:org.fh.shop.admin.mays.web.action
 * 创建日期:2019年1月31日下午11:06:46
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.web.action.user;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fh.shop.admin.mays.annontation.Log;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.common.ServiceResponseEnum;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.service.dept.IDeptService;
import org.fh.shop.admin.mays.service.user.IUserService;
import org.fh.shop.admin.mays.util.DateUtils;
import org.fh.shop.admin.mays.util.FileUtil;
import org.fh.shop.admin.mays.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <pre>项目名称：lalal
 * 类名称：UserInfo
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月31日 下午11:06:46
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月31日 下午11:06:46
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private IDeptService deptService;

    /**
     * 跳转到用户管理页面
     *
     * @return
     */
    @RequestMapping("touserMangerPage")
    public String touserMangerPage() {
        return "user/userList";
    }

    /**
     * ajax查询
     * @param userInfo
     * @param ids
     * @return
     */
    @RequestMapping("findUserList")
    @ResponseBody
    public Map findUserList(UserInfo userInfo, @RequestParam(value="ids[]",required = false) List<Integer> ids) {
        userInfo.setDeptList(ids);
        Long count = userService.countUserListSize(userInfo);
        List<UserInfo> userList = userService.findUserList(userInfo);
        Map map = new HashMap();
        map.put("draw", userInfo.getDraw());
        map.put("recordsTotal", userList.size());
        map.put("recordsFiltered", count);
        map.put("data", userList);
        return map;
    }

    /**
     * <pre>login(登录)
     * 创建人：马优生 178249290@qq.com
     * 创建时间：2019年1月31日 下午11:22:21
     * 修改人：马优生 178249290@qq.com
     * 修改时间：2019年1月31日 下午11:22:21
     * 修改备注：
     * @param userInfo
     * @param request
     * @return</pre>
     */
    @RequestMapping("login")
    @ResponseBody
    @Log("用户登录")
    public ServiceResponse login(HttpServletRequest request, UserInfo userInfo) {
        String code = (String) request.getSession().getAttribute("code");
        //验证码为空
        if (StringUtils.isEmpty(userInfo.getImgCode())) {
            return ServiceResponse.error(ServiceResponseEnum.USER_IMAGECODE_NULL);
        }

        //验证码错误
        if (!code.equals(userInfo.getImgCode())) {
            return ServiceResponse.error(ServiceResponseEnum.USER_IMAGECODE_ERROR);
        }

        if (StringUtils.isEmpty(userInfo.getUserName()) && StringUtils.isEmpty(userInfo.getUserPassword())) {
            return ServiceResponse.error(ServiceResponseEnum.USER_ARGS_NULL);
        }

        UserInfo user = userService.login(userInfo.getUserName());
        if (user == null) {
            return ServiceResponse.error(ServiceResponseEnum.USERNAME_USERPASSWORE_ERROR);
        }
        //判断用户登录错误次数是否大于三次
        if (user.getStauts() == 1) {
            return ServiceResponse.error(ServiceResponseEnum.USER_LOGIN_ERROR);
        }
        //判断密码
        String userPassword = user.getUserPassword();
        String salt = user.getSalt();
        String stringMD5 = MD5Util.getStringMD5(userInfo.getUserPassword() + salt);
        //判断密码错误
        if (!stringMD5.equals(userPassword)) {
            //判断错误日期是否是今天
            if (DateUtils.compareDate(user.getErrorLoginDate())) {
                //+1
                user.setErrorLoginCount(user.getErrorLoginCount() + 1);
            } else {
                //重置为1
                user.setErrorLoginCount(1);
            }
            if (user.getErrorLoginCount() >= 3) {
                user.setStauts(1);
            }
            //更新错误登陆时间
            user.setErrorLoginDate(DateUtils.getDateNow());
            //调用sql
            userService.updateUserWhereLoginError(user);
            return ServiceResponse.error(ServiceResponseEnum.USERNAME_USERPASSWORE_ERROR);
        }
        //判断最后一次登录日期是否是今天
        if (DateUtils.compareDate(user.getLoginDate())) {
            user.setLoginCount(user.getLoginCount() + 1);
        } else {
            user.setLoginCount(1);
        }
        request.getSession().setAttribute("user", user);
        //spring复制对象,将user复制给userInfo(复制对象的值,不引用对象原本的地址)
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setLoginDate(DateUtils.getDateNow());
        userInfo.setErrorLoginCount(0);
        userInfo.setErrorLoginDate(null);
        userService.updateUserLoginDate(userInfo);
        return ServiceResponse.success();
    }

    /**
     * 添加用户
     *
     * @param userInfo 用户实体对象
     * @return
     */
    @RequestMapping("addUser")
    @Log("添加用户")
    public ServiceResponse addUser(UserInfo userInfo) {
        if (userInfo != null) {
            if (StringUtils.isNotEmpty(userInfo.getUserName()) && StringUtils.isNotEmpty(userInfo.getUserPassword())) {
                String s = UUID.randomUUID().toString();
                userInfo.setSalt(s);
                userInfo.setLoginCount(0);
                String stringMD5 = MD5Util.getStringMD5(userInfo.getUserPassword() + s);
                userInfo.setUserPassword(stringMD5);
                userService.addUser(userInfo);
            }
        }
        return ServiceResponse.success();
    }


    /**
     * 解锁用户
     * @param id
     */
    @RequestMapping("unlockUser")
    @ResponseBody
    public void unlockUser(Integer id) {
        if (id != null) {
            userService.unlockUser(id);
        }
    }

    /**
     * 批量删除多个用户
     * @param ids
     * @return
     */
    @RequestMapping("deleteAllUserInfo")
    @ResponseBody
    public ServiceResponse deleteAllUserInfo(@RequestParam("ids[]") List<Integer> ids){
        userService.deleteAllUserInfo(ids);
        return ServiceResponse.success();
    }

    /**
     * 修改
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public ServiceResponse updateUserInfo(UserInfo userInfo){
        if (userInfo != null) {
            if (StringUtils.isNotEmpty(userInfo.getUserName()) && StringUtils.isNotEmpty(userInfo.getUserPassword())) {
                if (StringUtils.isNotEmpty(userInfo.getUserPassword())) {
                    String s = UUID.randomUUID().toString();
                    userInfo.setSalt(s);
                    String stringMD5 = MD5Util.getStringMD5(userInfo.getUserPassword() + s);
                    userInfo.setUserPassword(stringMD5);
                }
                userService.updateUserInfo(userInfo);
            }
        }
        return ServiceResponse.success();
    }

    /**
     * 批量更换部门
     * @param userIds
     * @param userInfo
     * @return
     */
    @RequestMapping("updateUserDept")
    @ResponseBody
    public ServiceResponse updateUserDept(@RequestParam("userIds[]") List<Integer> userIds,
                               UserInfo userInfo){
        userInfo.setDeptList(userIds);
        return userService.updateUserDept(userInfo);
    }

    /**
     * 按部门到处用户
     * @param deptId
     * @param response
     */
    @RequestMapping("exportExcelWhereDept")
    public void exportExcelWhereDept(Integer deptId, HttpServletResponse response){
        XSSFWorkbook xssfWorkbook = deptService.exportExcelWhereDept(deptId);
        FileUtil.excelDownload(xssfWorkbook, response);
    }
}
