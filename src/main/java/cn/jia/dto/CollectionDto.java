package cn.jia.dto;

/**
 * Created by matou on 2020/01/5.
 */
public class CollectionDto {
    private int id;
    private int count;
    private String pName;
    private String workSpace;
    private String pClassify;
    private String pRequest;
    private String department;
    private Integer flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(String workSpace) {
        this.workSpace = workSpace;
    }

    public String getpClassify() {
        return pClassify;
    }

    public void setpClassify(String pClassify) {
        this.pClassify = pClassify;
    }

    public String getpRequest() {
        return pRequest;
    }

    public void setpRequest(String pRequest) {
        this.pRequest = pRequest;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "CollectionDto{" +
                "id=" + id +
                ", count=" + count +
                ", pName='" + pName + '\'' +
                ", workSpace='" + workSpace + '\'' +
                ", pClassify='" + pClassify + '\'' +
                ", pRequest='" + pRequest + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
