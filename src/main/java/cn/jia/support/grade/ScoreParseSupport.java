package cn.jia.support.grade;

import cn.jia.dto.AnswerDto;
import cn.jia.dto.ScoreDetail;
import com.google.common.collect.Lists;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreParseSupport {

    public static List<ScoreDetail> parse(List<AnswerDto> reqAnswer,Map<Integer,String> readlAnswer){
        List<ScoreDetail> list = new ArrayList<>();
        reqAnswer.forEach((obj)->{
            ScoreDetail scoreDetail = new ScoreDetail();
            scoreDetail.setId(obj.getId());
            scoreDetail.setAnswer(obj.getAnswer());
            if(obj.getAnswer().equals(readlAnswer.get(obj.getId()))){
                scoreDetail.setResult(ScoreDetail.RESULT_YES);
            }else{
                scoreDetail.setResult(ScoreDetail.RESULT_NO);
            }
            list.add(scoreDetail);
        });
        return list;
    }

    public static Float getScore(List<ScoreDetail> scoreList){
        return  Float.valueOf(scoreList.stream().filter(obj->obj.getResult().equals(ScoreDetail.RESULT_YES)).count());
    }

    public static String getOrigQuest(List<ScoreDetail> scoreList){
        Map<Integer,String> map = scoreList.stream().collect(Collectors.toMap(ScoreDetail::getId,ScoreDetail::getAnswer));
        return JSONUtils.valueToString(map);
    }

    public static String getScoreDetail(List<ScoreDetail> scoreList){
        Map<Integer,String> map = scoreList.stream().collect(Collectors.toMap(ScoreDetail::getId,ScoreDetail::getResult));
        return JSONUtils.valueToString(map);
    }

    public static List<AnswerDto> transToDetailDto(String map) {
        Map mapClass = new HashMap();
        JSONArray jsonArray = new JSONArray();
        List<AnswerDto> list = new ArrayList<>();
        jsonArray = JSONArray.fromObject(map);
        for (int i = 0; i < jsonArray.size(); i++) {
            AnswerDto dto = new AnswerDto();
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);
            dto.setId(Integer.valueOf(jsonObj.get("i").toString()));
            dto.setAnswer(changeNum(jsonObj.getString("ans")));
            list.add(dto);
        }
        return list;
    }
    private static String changeNum(String num){
        switch (num){
            case "1":
                return "A";
            case "2":
                return "B";
            case "3":
                return "C";
            case "4":
                return "D";
            default:
                return null;
        }
    }

    private int countScore(List<AnswerDto> answerDtos){
        List<String>  ans = null;//存放答案的列表
        int a = 0;
        for (int i = 0; i < answerDtos.size(); i++) {
            AnswerDto answerDto = answerDtos.get(i);
            if (ans.get(answerDto.getId()-1).equals(answerDto.getAnswer())){
                a++;
            }
        }
        return  a;
    }
}
