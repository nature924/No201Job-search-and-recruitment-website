package cn.jia.mapper;

import cn.jia.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User finByUsername(String username);
    User finByUsernameAndPassword(@Param("username") String username,
                                  @Param("password")String password);
    List<User> findUserLike(@Param("username")String username);
}