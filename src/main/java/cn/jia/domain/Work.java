package cn.jia.domain;

import java.util.Date;

public class Work {
    private Integer id;

    private Integer userId;

    private String company;

    private String duty;

    private String fromTime;

    private String toTime;

    private String responsibility;

    private Date createTime;

    private Date updateTime;

    public Work(Integer id, Integer userId, String company, String duty, String fromTime, String toTime, String responsibility, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.company = company;
        this.duty = duty;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.responsibility = responsibility;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Work() {
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime == null ? null : fromTime.trim();
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime == null ? null : toTime.trim();
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility == null ? null : responsibility.trim();
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