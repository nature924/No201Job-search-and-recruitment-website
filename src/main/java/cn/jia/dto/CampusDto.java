package cn.jia.dto;

/**
 * Created by matou on 2020/01/11.
 */
public class CampusDto {

    private Integer id;

    private Integer userId;

    private String duty;

    private String award;

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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "CampusDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", duty='" + duty + '\'' +
                ", award='" + award + '\'' +
                '}';
    }
}
