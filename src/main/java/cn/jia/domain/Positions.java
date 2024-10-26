package cn.jia.domain;

import java.util.Date;

public class Positions {
    private Integer id;

    private String pName;

    private String pClassify;

    private String pDescribe;

    private String pResponsibility;

    private String pRequest;

    private String pDepartment;
    private String workSite;

    private int flag;

    private Date createTime;

    private Date updateTime;

    public Positions(Integer id, String pName, String pClassify, String pDescribe, String pResponsibility, String pRequest,String pDepartment,String workSite,Integer flag,Date createTime, Date updateTime) {
        this.id = id;
        this.pName = pName;
        this.pClassify = pClassify;
        this.pDescribe = pDescribe;
        this.pResponsibility = pResponsibility;
        this.pRequest = pRequest;
        this.pDepartment = pDepartment;
        this.workSite = workSite;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Positions() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpClassify() {
        return pClassify;
    }

    public void setpClassify(String pClassify) {
        this.pClassify = pClassify == null ? null : pClassify.trim();
    }

    public String getpDescribe() {
        return pDescribe;
    }

    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe == null ? null : pDescribe.trim();
    }

    public String getpResponsibility() {
        return pResponsibility;
    }

    public void setpResponsibility(String pResponsibility) {
        this.pResponsibility = pResponsibility == null ? null : pResponsibility.trim();
    }

    public String getpRequest() {
        return pRequest;
    }

    public void setpRequest(String pRequest) {
        this.pRequest = pRequest == null ? null : pRequest.trim();
    }

    public String getpDepartment() {
        return pDepartment;
    }

    public void setpDepartment(String pDepartment) {
        this.pDepartment = pDepartment;
    }

    public String getWorkSite() {
        return workSite;
    }

    public void setWorkSite(String workSite) {
        this.workSite = workSite;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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