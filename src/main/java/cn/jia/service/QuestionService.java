package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Question;
import cn.jia.dto.AnswerDto;

import java.util.HashMap;
import java.util.List;

/**
 * Created by matou on 2020/01/5.
 */
public interface QuestionService {
    ServerResponse add(Question question);
    ServerResponse update(Question question);
    ServerResponse delete(Integer id);
    ServerResponse showRandomByType(String type);
    ServerResponse getSrcore(List<AnswerDto> map, int userId,String classify);
    ServerResponse findAll(int pageIndex,int pageSize);
    ServerResponse findById(Integer id);
    ServerResponse findByType(String type,int pageIndex,int pageSize);
}
