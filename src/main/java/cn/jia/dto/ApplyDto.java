package cn.jia.dto;

import cn.jia.domain.Apply;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class ApplyDto {
    private Integer applyId;

    /**
     * 职位的类别（校园招聘、社会招聘）
     */
    private Integer flag;
    private String  positionName;
    private String userName;
    private Integer state;
    private String stateTrans;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyTime;

    public String getStateTrans(){
        if(state == null){
            return "";
        }
        if(state.intValue() == Apply.ApplyState.DCK.value){
            return "待查看";
        }
        if(state.intValue() == Apply.ApplyState.YM.value){
            return "一面";
        }
        if(state.intValue() == Apply.ApplyState.EM.value){
            return "二面";
        }
        if(state.intValue() == Apply.ApplyState.TG.value){
            return "通过";
        }else{
            return "淘汰";
        }
    }

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public void setStateTrans(String stateTrans) {
		this.stateTrans = stateTrans;
	}
    
    
}
