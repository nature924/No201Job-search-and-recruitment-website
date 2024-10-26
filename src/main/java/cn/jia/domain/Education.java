package cn.jia.domain;

import java.util.Date;

public class Education {
    private Integer id;

    private Integer userId;

    private String school;

    private String level;

    private String fromTime;

    private String toTime;

    private Date createTime;

    private Date updateTime;

    public Education(Integer id, Integer userId, String school, String level, String fromTime, String toTime, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.school = school;
        this.level = level;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Education() {
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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