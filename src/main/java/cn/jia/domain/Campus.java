package cn.jia.domain;

import java.util.Date;

public class Campus {
    private Integer id;

    private Integer userId;

    private String duty;

    private String award;

    private Date createTime;

    private Date updateTime;

    public Campus(Integer id, Integer userId, String duty, String award, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.duty = duty;
        this.award = award;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Campus() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award == null ? null : award.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}