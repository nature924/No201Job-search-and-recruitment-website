package cn.jia.mapper;

import cn.jia.domain.Work;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByUserId(Integer userId);

    int updateByUserIdSelective(Work record);

    int updateByPrimaryKey(Work record);
}