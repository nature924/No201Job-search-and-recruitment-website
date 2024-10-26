package cn.jia.domain;

import java.util.Date;

public class Question {
    private Integer id;

    private String qName;

    private String qChose;

    private String qAnswer;

    private String qClassify;

    private Date createTime;

    private Date updateTime;

    public Question(Integer id, String qName, String qChose, String qAnswer, String qClassify, Date createTime, Date updateTime) {
        this.id = id;
        this.qName = qName;
        this.qChose = qChose;
        this.qAnswer = qAnswer;
        this.qClassify = qClassify;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Question() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName == null ? null : qName.trim();
    }

    public String getqChose() {
        return qChose;
    }

    public void setqChose(String qChose) {
        this.qChose = qChose == null ? null : qChose.trim();
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer == null ? null : qAnswer.trim();
    }

    public String getqClassify() {
        return qClassify;
    }

    public void setqClassify(String qClassify) {
        this.qClassify = qClassify == null ? null : qClassify.trim();
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