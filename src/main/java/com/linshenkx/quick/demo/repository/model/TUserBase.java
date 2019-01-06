package com.linshenkx.quick.demo.repository.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`T_USER_BASE`")
public class TUserBase implements Serializable {
    private static final long serialVersionUID = 3656622178011827207L;
    /**
     * 用户编号：UUID
     */
    @Id
    @Column(name = "`ID`")
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 登录账号
     */
    @Column(name = "`USER_NAME`")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "`PASS_WORD`")
    private String passWord;

    /**
     * 记住登录：0-否、1-是
     */
    @Column(name = "`LOGIN_REMBER`")
    private Short loginRember;

    /**
     * 【数据信息】数据状态：0-丢弃（不可见）、1-启用、2-禁用（可见）
     */
    @Column(name = "`DATA_STATE`")
    private Short dataState;

    /**
     * 【数据信息】创建时间
     */
    @Column(name = "`DATA_CREATE_AT`")
    private Date dataCreateAt;

    /**
     * 【数据信息】创建人编号/系统"SYS"
     */
    @Column(name = "`DATA_CREATE_USER_ID`")
    private String dataCreateUserId;

    /**
     * 【数据信息】最后修改时间
     */
    @Column(name = "`DATA_UPDATE_AT`")
    private Date dataUpdateAt;

    /**
     * 【数据信息】最后修改人编号/系统"SYS"
     */
    @Column(name = "`DATA_UPDATE_USER_ID`")
    private String dataUpdateUserId;

    /**
     * 【扩展信息】备注/"无"
     */
    @Column(name = "`EXT_RESERVE`")
    private String extReserve;

    /**
     * 获取用户编号：UUID
     *
     * @return ID - 用户编号：UUID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户编号：UUID
     *
     * @param id 用户编号：UUID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取登录账号
     *
     * @return USER_NAME - 登录账号
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置登录账号
     *
     * @param userName 登录账号
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取登录密码
     *
     * @return PASS_WORD - 登录密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置登录密码
     *
     * @param passWord 登录密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取记住登录：0-否、1-是
     *
     * @return LOGIN_REMBER - 记住登录：0-否、1-是
     */
    public Short getLoginRember() {
        return loginRember;
    }

    /**
     * 设置记住登录：0-否、1-是
     *
     * @param loginRember 记住登录：0-否、1-是
     */
    public void setLoginRember(Short loginRember) {
        this.loginRember = loginRember;
    }

    /**
     * 获取【数据信息】数据状态：0-丢弃（不可见）、1-启用、2-禁用（可见）
     *
     * @return DATA_STATE - 【数据信息】数据状态：0-丢弃（不可见）、1-启用、2-禁用（可见）
     */
    public Short getDataState() {
        return dataState;
    }

    /**
     * 设置【数据信息】数据状态：0-丢弃（不可见）、1-启用、2-禁用（可见）
     *
     * @param dataState 【数据信息】数据状态：0-丢弃（不可见）、1-启用、2-禁用（可见）
     */
    public void setDataState(Short dataState) {
        this.dataState = dataState;
    }

    /**
     * 获取【数据信息】创建时间
     *
     * @return DATA_CREATE_AT - 【数据信息】创建时间
     */
    public Date getDataCreateAt() {
        return dataCreateAt;
    }

    /**
     * 设置【数据信息】创建时间
     *
     * @param dataCreateAt 【数据信息】创建时间
     */
    public void setDataCreateAt(Date dataCreateAt) {
        this.dataCreateAt = dataCreateAt;
    }

    /**
     * 获取【数据信息】创建人编号/系统"SYS"
     *
     * @return DATA_CREATE_USER_ID - 【数据信息】创建人编号/系统"SYS"
     */
    public String getDataCreateUserId() {
        return dataCreateUserId;
    }

    /**
     * 设置【数据信息】创建人编号/系统"SYS"
     *
     * @param dataCreateUserId 【数据信息】创建人编号/系统"SYS"
     */
    public void setDataCreateUserId(String dataCreateUserId) {
        this.dataCreateUserId = dataCreateUserId;
    }

    /**
     * 获取【数据信息】最后修改时间
     *
     * @return DATA_UPDATE_AT - 【数据信息】最后修改时间
     */
    public Date getDataUpdateAt() {
        return dataUpdateAt;
    }

    /**
     * 设置【数据信息】最后修改时间
     *
     * @param dataUpdateAt 【数据信息】最后修改时间
     */
    public void setDataUpdateAt(Date dataUpdateAt) {
        this.dataUpdateAt = dataUpdateAt;
    }

    /**
     * 获取【数据信息】最后修改人编号/系统"SYS"
     *
     * @return DATA_UPDATE_USER_ID - 【数据信息】最后修改人编号/系统"SYS"
     */
    public String getDataUpdateUserId() {
        return dataUpdateUserId;
    }

    /**
     * 设置【数据信息】最后修改人编号/系统"SYS"
     *
     * @param dataUpdateUserId 【数据信息】最后修改人编号/系统"SYS"
     */
    public void setDataUpdateUserId(String dataUpdateUserId) {
        this.dataUpdateUserId = dataUpdateUserId;
    }

    /**
     * 获取【扩展信息】备注/"无"
     *
     * @return EXT_RESERVE - 【扩展信息】备注/"无"
     */
    public String getExtReserve() {
        return extReserve;
    }

    /**
     * 设置【扩展信息】备注/"无"
     *
     * @param extReserve 【扩展信息】备注/"无"
     */
    public void setExtReserve(String extReserve) {
        this.extReserve = extReserve;
    }
}