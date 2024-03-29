package com.dlz.framework.ssme.db.model;

import com.dlz.framework.db.modal.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User extends BaseModel {
	void doNothing(){new java.util.ArrayList<>().forEach(a->{});}
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    public String tableName = "T_P_USER";

    @JsonIgnore
    public String tableColums = "USER_ID,LOGIN_ID,PWD,SALT,USER_NAME,USER_STATUS";

    /**
     * T_P_USER.USER_ID
     * 用户编号
     */
    private Long userId;

    /**
     * T_P_USER.LOGIN_ID
     * 登录名
     */
    private String loginId;

    /**
     * T_P_USER.PWD
     * 登陆密码Hash
     */
    private String pwd;

    /**
     * T_P_USER.SALT
     * 密码盐Salt
     */
    private String salt;

    /**
     * T_P_USER.USER_NAME
     * 真实姓名
     */
    private String userName;

    /**
     * T_P_USER.USER_STATUS
     * 用户状态
     */
    private String userStatus;

    /**
     * T_P_USER.USER_ID
     * 用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the value for T_P_USER.USER_ID
     * 用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * T_P_USER.LOGIN_ID
     * 登录名
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the value for T_P_USER.LOGIN_ID
     * 登录名
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    /**
     * T_P_USER.PWD
     * 登陆密码Hash
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the value for T_P_USER.PWD
     * 登陆密码Hash
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * T_P_USER.SALT
     * 密码盐Salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the value for T_P_USER.SALT
     * 密码盐Salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * T_P_USER.USER_NAME
     * 真实姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the value for T_P_USER.USER_NAME
     * 真实姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * T_P_USER.USER_STATUS
     * 用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus the value for T_P_USER.USER_STATUS
     * 用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }
}