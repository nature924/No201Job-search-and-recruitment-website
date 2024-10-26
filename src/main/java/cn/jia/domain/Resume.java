package cn.jia.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by matou on 2020/01/31.
 */
public class Resume {

    private int id;
    private int userId;
    private String positionName;//投递岗位
    private int flag;//1表示在线简历2表示附件简历
    private Information information;
    private Education education;
    private Campus campus;
    private Project project;
    private Skill skill;
    private Work work;
    private Date createTime;
    private Date updateTime;

    private int R; //0表示未读1表示1读


    //成绩
    private Grade grade;


    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
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

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", userId=" + userId +
                ", positionName='" + positionName + '\'' +
                ", flag=" + flag +
                ", information=" + information +
                ", education=" + education +
                ", campus=" + campus +
                ", project=" + project +
                ", skill=" + skill +
                ", work=" + work +
                ", grade=" + grade +
                '}';
    }
}
