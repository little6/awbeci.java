package com.awbeci.domain;


import java.sql.Timestamp;

/**
 * Created by zhangwei on 2015/6/27.
 */
public class User {
    private String id;

    private String name;

    private String email;

    private int isActivate;

    private String activeCode;

    private String password;

    private Timestamp createDt;

    private Timestamp updateDt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    public Timestamp getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Timestamp updateDt) {
        this.updateDt = updateDt;
    }

    public int getIsActivate() {
        return isActivate;
    }


    public void setIsActivate(int isActivate) {
        this.isActivate = isActivate;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
}
