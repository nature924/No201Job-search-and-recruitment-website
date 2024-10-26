package cn.jia.mapper;

import cn.jia.domain.Apply;
import cn.jia.dto.ApplyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by matou on 2020/01/4.
 */
public interface ApplyMapper {

    int insert(Apply apply);
    Apply findByUserIdAndPId(@Param("userId")int userId,@Param("pId")int pId);
    int updateState(Map<String,Object> map);
    List<ApplyDto> findApplys(@Param("userId") Integer userId,@Param("search") String search);
}
