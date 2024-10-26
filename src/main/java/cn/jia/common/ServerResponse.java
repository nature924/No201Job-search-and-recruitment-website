package cn.jia.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 响应模板类
 * @param <T>  响应的数据类型
 */

/* 空字段不做 json 转换 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{
    private static final long serialVersionUID = -7338962563306135185L;
    /*状态码*/
    private int status;
    /*状态信息*/
    private String msg;
    /*响应数据*/
    private T data;

    /**
     * 重载各种构造方法
     */
    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 构建相应消息的各种方法
     */
    public static <T> ServerResponse<T> buildSuccessMsg(String msg){
        return new ServerResponse(ResponseCode.OA_SUCCESS.getStatus(), msg);
    }

    public static <T> ServerResponse<T> buildSuccessData(T data){
        return new ServerResponse(ResponseCode.OA_SUCCESS.getStatus(), data);
    }

    public static <T> ServerResponse<T> buildSuccessResponse(String msg,T data){
        return new ServerResponse(ResponseCode.OA_SUCCESS.getStatus(), msg,data);
    }

    public static <T> ServerResponse<T> buildErrorMsg(String msg){
        return new ServerResponse(ResponseCode.OA_ERROR.getStatus(), msg);
    }

    public static <T> ServerResponse<T> buildErrorMsg(int status, String msg){
        return new ServerResponse(status, msg);
    }


    /**
     * 判断当前响应状态
     * */
    @JsonIgnore
    public boolean isSuccess(){
        return status == ResponseCode.OA_SUCCESS.getStatus();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
