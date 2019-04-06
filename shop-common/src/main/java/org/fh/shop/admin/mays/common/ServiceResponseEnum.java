/**
 * <pre>项目名称:heiheihie
 * 文件名称:ServiceResponseEnum.java
 * 包名:com.fh.shop.backend.beanEnum
 * 创建日期:2019年1月11日下午1:11:20
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.common;

/**
 * <pre>项目名称：heiheihie    
 * 类名称：ServiceResponseEnum    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月11日 下午1:11:20    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月11日 下午1:11:20    
 * 修改备注：
 * @version </pre>    
 */
public enum ServiceResponseEnum {

    USER_LOGIN_ERROR(-1, "用户已被锁定，请联系管理员"),
    USER_ARGS_NULL(-1, "用户名和密码不能为空"),
    USER_SYSTEM_ERROR(500, "系统错误，登陆失败，请联系管理员"),
    USER_IMAGECODE_NULL(-1, "验证码不能为空"),
    USER_IMAGECODE_ERROR(-1, "验证码错误"),
    USERNAME_USERPASSWORE_ERROR(1001, "用户名or密码错误"),
    SUCCESS(200, "成功");

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
     * <pre>创建一个新的实例 ServiceResponseEnum.
     *
     */
    private ServiceResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * <pre>创建一个新的实例 ServiceResponseEnum.
     *
     */
    private ServiceResponseEnum() {

    }

}
