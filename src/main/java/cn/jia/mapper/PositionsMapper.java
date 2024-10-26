package cn.jia.mapper;

import cn.jia.domain.Positions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionsMapper {
    int deleteById(int id);

    int insert(Positions record);

    int insertSelective(Positions record);

    Positions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Positions record);

    int updateByPrimaryKey(Positions record);

    List<Positions> findAll(@Param("flag") Integer flag);

    List<Positions> findByCondiction(@Param("pClassify")List<String> pClassify,
                                     @Param("workSite")List<String> workSite,
                                     @Param("descs")List<String> descs,
                                     @Param("flag")int flag,
                                     @Param("keyWord") String keyWord);

    Positions findDetails(@Param("pName")String pName,
                          @Param("flag") int flag);

    //int updateByNameAndFlagSelective(Positions record);

  //  List<Positions> findSchoolAll();

    List<Positions> findByKeyWord(@Param("keyWord")String keyWord,
                                  @Param("flag") Integer flag);

    List<Positions> selectRandom(@Param("flag") Integer flag);



}