package cn.jia.domain;

import java.util.Date;

public class Project {
    private Integer id;

    private Integer userId;

    private String projectName;

    private String fromTime;

    private String toTime;

    private String describes;

    private Date createTime;

    private Date updateTime;

    public Project(Integer id, Integer userId, String projectName, String fromTime, String toTime, String describes, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.projectName = projectName;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.describes = describes;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Project() {
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
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