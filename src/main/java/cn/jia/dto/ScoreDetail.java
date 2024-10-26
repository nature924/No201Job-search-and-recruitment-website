package cn.jia.dto;

import lombok.Data;

@Data
public class ScoreDetail {

    private int id;

    private String answer;

    private String result;

    public static final String RESULT_YES = "y";

    public static final String RESULT_NO = "n";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
    
    
}
