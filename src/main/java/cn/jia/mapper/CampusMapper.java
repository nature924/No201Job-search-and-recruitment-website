package cn.jia.mapper;

import cn.jia.domain.Campus;

public interface CampusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByUserId(Integer userId);

    int updateByUserIdSelective(Campus record);

    int updateByPrimaryKey(Campus record);
}