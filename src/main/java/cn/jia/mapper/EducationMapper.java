package cn.jia.mapper;

import cn.jia.domain.Education;

public interface EducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByUserId(Integer userId);

    int updateByUserIdSelective(Education record);

    int updateByPrimaryKey(Education record);
}