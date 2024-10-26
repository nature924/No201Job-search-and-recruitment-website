package cn.jia.dto;

/**
 * Created by matou on 2020/01/11.
 */
public class WorkDto {

    private Integer id;

    private Integer userId;

    private String company;

    private String duty;

    private String fromTime;

    private String toTime;

    private String responsibility;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return "WorkDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", company='" + company + '\'' +
                ", duty='" + duty + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", responsibility='" + responsibility + '\'' +
                '}';
    }
}
