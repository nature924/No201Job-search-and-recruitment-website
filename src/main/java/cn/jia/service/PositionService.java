package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Positions;

import java.util.List;

/**
 * Created by matou on 2020/01/3.
 */
public interface PositionService {
    ServerResponse insert(Positions positions);
    ServerResponse findAllBySocial(int pageIndex,int pageSize);
    ServerResponse findByCondiction(List<String> pClassify, List<String> workSite,List<String> descs, int flag,String keyWord, int pageIndex, int pageSize);
    ServerResponse getDeatils(String pName,Integer flag);
    ServerResponse update(Positions positions);
    ServerResponse deleteById(Integer id);
    ServerResponse findByKeyWord(String keyWord,int  pageIndex,int pageSize,int flag);
    ServerResponse findBySchool(int pageIndex,int pageSize);
    ServerResponse apply(int userId,Integer pId,Integer resumeId);
    ServerResponse collect(int userId,Integer pId,Integer flag);
    ServerResponse findByRandom(Integer flag);
    ServerResponse findById(int  id);
    ServerResponse findAll(int pageIndex,int pageSize);
    ServerResponse updateApply(Integer state,Integer userId,Integer applyId);
    ServerResponse findAllApply(Integer pageIndex,Integer pageSize,Integer userId,String search);
}
