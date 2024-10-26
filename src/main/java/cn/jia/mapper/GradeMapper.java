package cn.jia.mapper;

import cn.jia.domain.Grade;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GradeMapper extends Mapper<Grade> {

    @Select("  select * from grade where user_id = #{userId} and classify = #{classify}")
    Grade selectByUserIdAndType(@Param("userId") int userId,@Param("classify") String classify);

    @Select("  select * from grade where user_id = #{userId} ")
    Grade selectByUserId(int userId);
}