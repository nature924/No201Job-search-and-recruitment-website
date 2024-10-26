package cn.jia.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by matou on 2020/01/4.
 * 职位申请
 */
@Data
public class Apply {
    private Integer id;
    private Integer pId;
    private Integer userId;
    private Integer resumeId; //1代表在线简历，2代表附件简历
    private Integer state;
    private Integer handleUser;
    private Date handleTime;
    private Date applyTime;


    public Apply(Integer id, Integer userId, Integer pId, Integer resumeId, Integer state, Integer handleUser,
                 Date handleTime,Date applyTime) {
        this.id = id;
        this.pId = pId;
        this.userId = userId;
        this.resumeId = resumeId;
        this.state = state;
        this.handleTime = handleTime;
        this.handleUser = handleUser;
        this.applyTime = applyTime;
    }
    public Apply(){}

    public static enum ApplyState{
        DCK(0),YM(1),EM(2),TG(3),TT(4);
        public int value;
        ApplyState(int value){
            this.value = value;
        }
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getHandleUser() {
		return handleUser;
	}
	public void setHandleUser(Integer handleUser) {
		this.handleUser = handleUser;
	}
	public Date getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
    
    
}
