package cn.jia.domain;

public class Collection {
    private Integer id;

    private Integer userId;

    private Integer pId;

    private Integer flag;

    public Collection(Integer id, Integer userId, Integer pId, Integer flag) {
        this.id = id;
        this.userId = userId;
        this.pId = pId;
        this.flag = flag;
    }

    public Collection() {
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}