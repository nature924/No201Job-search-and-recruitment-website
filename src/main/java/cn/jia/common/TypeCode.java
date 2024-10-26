package cn.jia.common;

/**
 * Created by jia on 2018/1/1.
 */
public enum TypeCode {

    SocialZhao(1,"社会招-"),
    CampusZhao(2,"校园招-");

    private int code;
    private String desc;

    TypeCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
