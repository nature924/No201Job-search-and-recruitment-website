package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Question;
import cn.jia.dto.AnswerDto;
import cn.jia.dto.QuestionDto;
import cn.jia.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matou on 2020/01/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceImplTest {


    @Autowired
    private QuestionService questionService;
    @Test
    public void add() throws Exception {
        for (int i = 0;i<10;i++){
            Question question = new Question();
            question.setqName("选出下面的不同");
            question.setqChose("A:1/3,B:1/4,C:1/5,D:3/9");
            question.setqAnswer("D");
            question.setqClassify("逻辑");
            questionService.add(question);
        }
    }

    @Test
    public void update() throws Exception {
        Question question = new Question();
        question.setqName("选出下面的不同");
        question.setqChose("A:1/3,B:1/4,C:1/5,D:3/9");
        question.setqAnswer("D");
        question.setqClassify("逻辑");
        question.setId(1);
        questionService.update(question);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void showRandom() throws Exception {
        ServerResponse serverResponse = questionService.showRandomByType("人力资源");
        System.out.println("-------"+((List<QuestionDto>)serverResponse.getData()).size());
    }

    @Test
    public void getSrcore() throws Exception {
        AnswerDto[] answerDtos = new AnswerDto[10];
        for (int i = 1;i<3;i++){
            AnswerDto answerDto = new AnswerDto();
            answerDto.setId(i);
            answerDto.setAnswer("D");
            answerDtos[i++] = answerDto;
        }
      // System.out.println(questionService.getSrcore(answerDtos,1));
    }

}