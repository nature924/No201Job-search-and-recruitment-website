package cn.jia.domain;

import java.util.Date;

public class Information {
    private Integer id;

    private Integer userId;

    private String name;

    private String sex;

    private String email;

    private String poliStatus;

    private String phone;

    private String photo;

    private String files;

    private String jobIntension;

    private String describes;

    private Date createTime;

    private Date updateTime;

    public Information(Integer id, Integer userId, String name, String sex, String email, String poliStatus, String phone, String photo, String files, String jobIntension, String describes, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.poliStatus = poliStatus;
        this.phone = phone;
        this.photo = photo;
        this.files = files;
        this.jobIntension = jobIntension;
        this.describes = describes;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Information() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPoliStatus() {
        return poliStatus;
    }

    public void setPoliStatus(String poliStatus) {
        this.poliStatus = poliStatus == null ? null : poliStatus.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files == null ? null : files.trim();
    }

    public String getJobIntension() {
        return jobIntension;
    }

    public void setJobIntension(String jobIntension) {
        this.jobIntension = jobIntension == null ? null : jobIntension.trim();
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