
package cn.jia.common;
/**
 * Created by matou on 2019/11/23.
 */
public enum  RoleType {
    user(1,"user"),
    admin(2,"admin"),
	system(3,"system");

    private int id;
    private String msg;

    RoleType(int id,String msg){
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
