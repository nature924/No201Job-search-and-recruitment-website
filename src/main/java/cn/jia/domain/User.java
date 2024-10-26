package cn.jia.domain;

import java.util.Date;
import java.util.Set;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String answer1;

    private String answer2;

    private Integer flag = 1;

    private Date createTime;

    private Date updateTime;

    private int roleId ;

    public User(Integer id, String username, String password, String answer1, String answer2, Integer flag, Date createTime, Date updateTime,Integer roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.flag = flag;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.roleId = roleId;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1 == null ? null : answer1.trim();
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2 == null ? null : answer2.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}