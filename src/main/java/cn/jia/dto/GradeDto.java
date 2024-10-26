package cn.jia.dto;

import lombok.Data;

/**
 * Created by matou on 2020/01/31.
 */
@Data
public class GradeDto {
    private Integer id;

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
