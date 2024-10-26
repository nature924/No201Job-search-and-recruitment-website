package cn.jia.mapper;

import cn.jia.domain.Information;

import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByUserId(Integer userId);

    int updateByUserIdSelective(Information record);

    int updateByPrimaryKey(Information record);

    List<Information> findAll();
}