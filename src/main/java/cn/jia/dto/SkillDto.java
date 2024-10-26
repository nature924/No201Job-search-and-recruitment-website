package cn.jia.dto;

/**
 * Created by matou on 2020/01/11.
 */
public class SkillDto {

    private Integer id;

    private Integer userId;

    private String skill1;

    private String skill2;

    private String skill3;

    private String skill4;

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
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public String getSkill4() {
        return skill4;
    }

    public void setSkill4(String skill4) {
        this.skill4 = skill4;
    }

    @Override
    public String toString() {
        return "SkillDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", skill1='" + skill1 + '\'' +
                ", skill2='" + skill2 + '\'' +
                ", skill3='" + skill3 + '\'' +
                ", skill4='" + skill4 + '\'' +
                '}';
    }
}
