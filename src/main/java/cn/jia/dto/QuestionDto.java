package cn.jia.dto;

import java.util.Arrays;

/**
 * Created by matou on 2020/01/5.
 */
public class QuestionDto {
    private Integer id;

    private String qName;

    private String[] qChose;

    private String qAnswer;

    private String qClassify;

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
        this.qName = qName;
    }

    public String[] getqChose() {
        return qChose;
    }

    public void setqChose(String[] qChose) {
        this.qChose = qChose;
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer;
    }

    public String getqClassify() {
        return qClassify;
    }

    public void setqClassify(String qClassify) {
        this.qClassify = qClassify;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "id=" + id +
                ", qName='" + qName + '\'' +
                ", qChose=" + Arrays.toString(qChose) +
                ", qAnswer='" + qAnswer + '\'' +
                ", qClassify='" + qClassify + '\'' +
                '}';
    }
}
