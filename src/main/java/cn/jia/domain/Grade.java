package cn.jia.domain;
import lombok.Data;

@Data
public class Grade {
    private Integer id;

    private Integer userId;

    private Float score;

    private String classify;

    private String origQuest;

    private String scoreDetail;

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

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getOrigQuest() {
		return origQuest;
	}

	public void setOrigQuest(String origQuest) {
		this.origQuest = origQuest;
	}

	public String getScoreDetail() {
		return scoreDetail;
	}

	public void setScoreDetail(String scoreDetail) {
		this.scoreDetail = scoreDetail;
	}
    
    
}