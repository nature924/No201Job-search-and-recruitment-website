package cn.jia.domain;

import java.util.Date;

public class Skill {
    private Integer id;

    private Integer userId;

    private String skill1;

    private String skill2;

    private String skill3;

    private String skill4;

    private Date createTime;

    private Date updateTime;

    public Skill(Integer id, Integer userId, String skill1, String skill2, String skill3, String skill4, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Skill() {
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

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1 == null ? null : skill1.trim();
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2 == null ? null : skill2.trim();
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3 == null ? null : skill3.trim();
    }

    public String getSkill4() {
        return skill4;
    }

    public void setSkill4(String skill4) {
        this.skill4 = skill4 == null ? null : skill4.trim();
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