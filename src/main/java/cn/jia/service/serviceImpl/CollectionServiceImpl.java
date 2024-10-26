package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Collection;
import cn.jia.domain.Positions;
import cn.jia.dto.CollectionDto;
import cn.jia.mapper.CollectionMapper;
import cn.jia.mapper.PositionsMapper;
import cn.jia.service.CollectionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by matou on 2020/01/5.
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private PositionsMapper positionsMapper;

    //展现收藏
    public ServerResponse show(int userId,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<Collection> collectionList = collectionMapper.findByUserId(userId);
        if (collectionList == null || collectionList.isEmpty()){
            return ServerResponse.buildErrorMsg("不存在相应的收藏");
        }
        int count = collectionMapper.countByUserId(userId);
        List<CollectionDto> collectionDtos = Lists.newArrayList();
        for (Collection c:collectionList) {
            Positions positions = positionsMapper.selectByPrimaryKey(c.getpId());
            CollectionDto collectionDto = entyToDto(c.getId(),count,positions);
            collectionDtos.add(collectionDto);
        }
        PageInfo pageInfo = new PageInfo(collectionList);
        pageInfo.setList(collectionDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }

    //取消收藏
    @Transactional
    public ServerResponse cancelCollection(int id){
        int i = collectionMapper.deleteByPrimaryKey(id);
        if (i<1){
            return ServerResponse.buildErrorMsg("取消失败");
        }
        return ServerResponse.buildSuccessMsg("取消成功");
    }

    private CollectionDto entyToDto(int id,int count,Positions positions){
        CollectionDto collectionDto = new CollectionDto();
        collectionDto.setId(id);
        collectionDto.setCount(count);
        collectionDto.setpName(positions.getpName());
        collectionDto.setpClassify(positions.getpClassify());
        collectionDto.setpRequest(positions.getpRequest());
        collectionDto.setWorkSpace(positions.getWorkSite());
        collectionDto.setDepartment(positions.getpDepartment());
        collectionDto.setFlag(positions.getFlag());
        return collectionDto;
    }
}
