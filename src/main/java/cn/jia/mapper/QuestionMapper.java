package cn.jia.mapper;

import cn.jia.domain.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectQuestionRandomByType(String type);
    List<Question> findAll();
    List<Question> findByType(String type);
}