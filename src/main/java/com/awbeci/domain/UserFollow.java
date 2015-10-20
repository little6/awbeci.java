package com.awbeci.domain;

import java.util.Date;

public class UserFollow {
    private String id;
    private String uid;
    private String folllowId;
    private String folllowName;
    private String folllowUrl;
    private String type;
    private Date createDt;
    private Date updateDt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFolllowId() {
        return folllowId;
    }

    public void setFolllowId(String folllowId) {
        this.folllowId = folllowId;
    }

    public String getFolllowName() {
        return folllowName;
    }

    public void setFolllowName(String folllowName) {
        this.folllowName = folllowName;
    }

    public String getFolllowUrl() {
        return folllowUrl;
    }

    public void setFolllowUrl(String folllowUrl) {
        this.folllowUrl = folllowUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
