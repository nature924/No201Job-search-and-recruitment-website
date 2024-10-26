package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.common.TypeCode;
import cn.jia.domain.*;
import cn.jia.dto.ApplyDto;
import cn.jia.dto.PositionsDto;
import cn.jia.mapper.*;
import cn.jia.service.PositionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matou on 2020/01/3.
 */
@Service
public class PositionServiceImpl implements PositionService {


    @Autowired
    private PositionsMapper positionsMapper;
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private InformationMapper informationMapper;
    @Autowired
    private ResumeMapper resumeMapper;

    //插入一个职位
    @Transactional
    public ServerResponse insert(Positions positions){
        positions.setCreateTime(new Date());
        positions.setUpdateTime(new Date());
        int i = positionsMapper.insert(positions);
        if (i<1){
            return ServerResponse.buildErrorMsg("新建失败");
        }
        return ServerResponse.buildSuccessMsg("新建成功");
    }
    public ServerResponse findAll(int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findAll(null);
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        PageInfo pageInfo = new PageInfo(positionsList);
        pageInfo.setList(positionsDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }
    //查询全部
    public ServerResponse findAllBySocial(int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findAll(1);
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        PageInfo pageInfo = new PageInfo(positionsList);
        pageInfo.setList(positionsDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }


    /**
     * 根据条件查询
     * @param pClassify  分类
     * @param workSite  工作地点
     * @param desc      描述  (这里区分工作的性质)  社会招聘为null
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ServerResponse findByCondiction(List<String> pClassify,List<String> workSite,List<String> descs,int flag,String keyWord,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findByCondiction(pClassify,workSite,descs,flag,keyWord);
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        PageInfo pageInfo = new PageInfo(positionsList);
        pageInfo.setList(positionsDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }

    /**
     * 查看详情
     * 根据名字和标志
     */

    public ServerResponse getDeatils(String pName,Integer flag){
        if (StringUtils.isEmpty(pName) || flag == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Positions positions = positionsMapper.findDetails(pName,flag);
        if (positions == null){
            return ServerResponse.buildErrorMsg("不存在相应的实体");
        }
        PositionsDto positionsDto = entityToDto(positions);
        return ServerResponse.buildSuccessData(positionsDto);
    }



    public ServerResponse findById(int  id){
        Positions positions = positionsMapper.selectByPrimaryKey(id);
        if (positions == null){
            return ServerResponse.buildErrorMsg("不存在相应的实体");
        }
        PositionsDto positionsDto = entityToDto(positions);
        return ServerResponse.buildSuccessData(positionsDto);
    }

    /**
     * 更新 根据职位名和标志更新
     */
    @Transactional
    public ServerResponse update(Positions positions){
        positions.setUpdateTime(new Date());
        int i = positionsMapper.updateByPrimaryKeySelective(positions);
        if (i < 1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        return ServerResponse.buildSuccessMsg("更新成功");
    }
    /**
     * 删除根据职位名和标志
     */
    @Transactional
    public ServerResponse deleteById(Integer id){
        if (id == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        int i = positionsMapper.deleteById(id);
        if (i<1){
            return ServerResponse.buildErrorMsg("删除失败");
        }
        return ServerResponse.buildSuccessMsg("删除成功");
    }

    /**
     * 关键字搜索
     * @param
     * @return
     */
    public ServerResponse findByKeyWord(String keyWord,int  pageIndex,int pageSize,int flag){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findByKeyWord(keyWord,flag);
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        PageInfo pageInfo = new PageInfo(positionsList);
        pageInfo.setList(positionsDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }


    //申请职位
    @Transactional
    public ServerResponse apply(int userId,Integer pId,Integer resumeId){
        if (pId == null || resumeId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        //判断简历是否存在
        //Resume resume = resumeMapper.findByUserId(userId);
        Information information = informationMapper.selectByUserId(userId);
        if (information == null){
            return ServerResponse.buildErrorMsg("请填写简历或上传附件简历");
        }
        if (StringUtils.isEmpty(information.getName()) ||
                StringUtils.isEmpty(information.getJobIntension())){
            return ServerResponse.buildErrorMsg("请完善个人基本信息");
        }
        /*if (resumeId == 1 && StringUtils.isEmpty(information.getName())){
            return ServerResponse.buildErrorMsg("不存在在线简历");
        }*/

        if (resumeId == 2 && StringUtils.isEmpty(information.getFiles())){
            return ServerResponse.buildErrorMsg("不存在附件简历");
        }

        //判断是否已经申请了该职位
        Apply apply = applyMapper.findByUserIdAndPId(userId,pId);
        if (apply != null){
            return ServerResponse.buildErrorMsg("你以申请该职位，不可重复申请");
        }
        Positions positions = positionsMapper.selectByPrimaryKey(pId);
        apply = new Apply();
        apply.setUserId(userId);
        apply.setpId(pId);
        apply.setResumeId(resumeId);
        apply.setApplyTime(new Date());
        apply.setState(Apply.ApplyState.DCK.value);
        int i = applyMapper.insert(apply);
        Resume resume = new Resume();
        resume.setUserId(userId);
        if (positions.getFlag() == 1){
            resume.setPositionName(TypeCode.SocialZhao.getDesc()+positions.getpName());
        }else{
            resume.setPositionName(TypeCode.CampusZhao.getDesc()+positions.getpName());
        }

        resume.setFlag(resumeId);
        resume.setR(0); //表示未读
        int a = resumeMapper.insert(resume);
        if (i<1 && a <1){
            return ServerResponse.buildErrorMsg("申请失败");
        }
        return ServerResponse.buildSuccessMsg("申请成功");
    }

    //收藏职位
    @Transactional
    public ServerResponse collect(int userId,Integer pId,Integer flag){
        if (pId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        //判断是否已经收藏
        Collection collection = collectionMapper.findCollectionByUserIdAndPId(userId,pId);
        if (collection != null){
            return ServerResponse.buildErrorMsg("已收藏该职位");
        }
        collection = new Collection();
        collection.setUserId(userId);
        collection.setpId(pId);
        collection.setFlag(flag);
        int i = collectionMapper.insert(collection);
        if (i<1){
            return ServerResponse.buildErrorMsg("收藏失败");
        }
        return ServerResponse.buildSuccessMsg("收藏成功");
    }

    public ServerResponse findByRandom(Integer flag){
        if (flag == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        List<Positions> positionsList = positionsMapper.selectRandom(flag);
        if (positionsList.isEmpty()){
            return ServerResponse.buildErrorMsg("不存在相应的职位");
        }
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        return ServerResponse.buildSuccessData(positionsDtos);
    }

    @Override
    public ServerResponse updateApply(Integer state,Integer userId,Integer applyId){
         Map<String,Object> map = new HashMap<>(5);
         map.put("state",state);
         map.put("handleUser",userId);
         map.put("applyId",applyId);
         map.put("handleTime",new Date());
         int i = applyMapper.updateState(map);
        if (i<1){
            return ServerResponse.buildErrorMsg("操作失败");
        }
        return ServerResponse.buildSuccessMsg("操作成功");
    }

    @Override
    public ServerResponse findAllApply(Integer pageIndex, Integer pageSize, Integer userId,String search) {
        if (null != pageIndex && null != pageSize) {
            PageHelper.startPage(pageIndex, pageSize);
        }
        List<ApplyDto> list = applyMapper.findApplys(userId,search);
        if (!CollectionUtils.isEmpty(list)) {
            for (ApplyDto ad : list) {
                ad.setStateTrans(ad.getStateTrans());
            }
        }
        return ServerResponse.buildSuccessData(new PageInfo<>(list));
    }

    /*------------------------校园招聘---------------------------------------*/
    //查询全部
    public ServerResponse findBySchool(int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findAll(2);
        List<PositionsDto> positionsDtos = Lists.newArrayList();
        for (Positions p:positionsList) {
            PositionsDto positionsDto = entityToDto(p);
            positionsDtos.add(positionsDto);
        }
        PageInfo pageInfo = new PageInfo(positionsList);
        pageInfo.setList(positionsDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }


    /*------------------------管理员---------------------------------*/
    /*public ServerResponse findByType(String type,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Positions> positionsList = positionsMapper.findByKeyWord(type);
    }*/



    private PositionsDto entityToDto(Positions positions){
       PositionsDto positionsDto = new PositionsDto();
       positionsDto.setId(positions.getId());
       positionsDto.setpName(positions.getpName());
       positionsDto.setpClassify(positions.getpClassify());
       positionsDto.setpDescribe(positions.getpDescribe());
       positionsDto.setpRequest(positions.getpRequest());
       positionsDto.setpResponsibility(positions.getpResponsibility());
       positionsDto.setpDepartment(positions.getpDepartment());
       positionsDto.setWorkSite(positions.getWorkSite());
       positionsDto.setFlag(positions.getFlag());
       return positionsDto;
    }
}
