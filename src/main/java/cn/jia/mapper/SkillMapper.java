package cn.jia.mapper;

import cn.jia.domain.Skill;

public interface SkillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByUserId(Integer userId);

    int updateByUserIdSelective(Skill record);

    int updateByPrimaryKey(Skill record);
}