package cn.jia.mapper;



import cn.jia.domain.Resume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by matou on 2020/01/31.
 */
public interface ResumeMapper {

    List<Resume> findByUserId(int user_id);
    List<Integer> findUserId();
    int findFlagByUserIdAndPName(@Param("userId") int userId,@Param("pName") String pName);
    List<Resume> findPositionLikeName(@Param("positionName") String positionName);
    int insert(Resume resume);
    int delete(int id);
    int updateR(@Param("userId") int userId,@Param("pName") String pName);
    List<Resume> findAll();
}
