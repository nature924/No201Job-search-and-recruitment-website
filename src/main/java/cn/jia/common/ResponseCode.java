package cn.jia.common;

/**
 * 状态码枚举类,系统所有状态码在这里定义
 */
public enum ResponseCode {
    OA_ERROR(0,"ERROR"),
    OA_SUCCESS(1,"SUCCESS"),
    OA_NO_PERMISSION(2,"OA_NO_PERMISSION");


    private final int status;
    private final String desc;

    private ResponseCode(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
