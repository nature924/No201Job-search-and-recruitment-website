package cn.jia.mapper;

import cn.jia.domain.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByUserId(Integer userId);

    int updateByUserIdSelective(Project record);

    int updateByPrimaryKey(Project record);
}