package cn.jia.dto;

/**
 * Created by matou on 2020/01/3.
 */
public class PositionsDto {

    private int id;
    private String pName;

    private String pClassify;

    private String pDescribe;

    private String pResponsibility;

    private String pRequest;

    private String pDepartment;

    private String workSite;
    private int flag;
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpClassify() {
        return pClassify;
    }

    public void setpClassify(String pClassify) {
        this.pClassify = pClassify;
    }

    public String getpDescribe() {
        return pDescribe;
    }

    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    public String getpResponsibility() {
        return pResponsibility;
    }

    public void setpResponsibility(String pResponsibility) {
        this.pResponsibility = pResponsibility;
    }

    public String getpRequest() {
        return pRequest;
    }

    public void setpRequest(String pRequest) {
        this.pRequest = pRequest;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "PositionsDto{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pClassify='" + pClassify + '\'' +
                ", pDescribe='" + pDescribe + '\'' +
                ", pResponsibility='" + pResponsibility + '\'' +
                ", pRequest='" + pRequest + '\'' +
                ", pDepartment='" + pDepartment + '\'' +
                ", workSite='" + workSite + '\'' +
                '}';
    }
}
