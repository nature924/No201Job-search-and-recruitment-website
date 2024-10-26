package cn.jia.mapper;

import cn.jia.domain.Collection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    List<Collection> findByUserId(int userId);
    int countByUserId(int userId);
    Collection findCollectionByUserIdAndPId(@Param("userId")int userId,@Param("pId")int pId);
}