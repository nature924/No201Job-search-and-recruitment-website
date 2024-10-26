package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Campus;
import cn.jia.domain.Resume;
import cn.jia.domain.Skill;
import cn.jia.dto.CampusDto;
import cn.jia.mapper.CampusMapper;
import cn.jia.mapper.ResumeMapper;
import cn.jia.service.CampusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by matou on 2020/01/11.
 */
@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    private CampusMapper campusMapper;

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    @Transactional
    public ServerResponse addOrUpdate(Campus campus, Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        campus.setUserId(userId);
        Campus campus1 = campusMapper.selectByUserId(userId);
        if (campus1 == null){
            //新增
            int i = campusMapper.insert(campus);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增校园情况失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(campus));
        }
        campus.setUpdateTime(new Date());
        int i = campusMapper.updateByUserIdSelective(campus);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        List<Resume> resumes = resumeMapper.findByUserId(userId);
        if (resumes == null || resumes.size() == 0){
            Resume resume = new Resume();
            resume.setUserId(userId);
            resumeMapper.insert(resume);
        }
        return ServerResponse.buildSuccessData(entityToDto(campus));
    }

    @Override
    public ServerResponse findByUserId(Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
       Campus campus = campusMapper.selectByUserId(userId);
        if (campus == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(campus));
    }

    public CampusDto entityToDto(Campus campus){
        CampusDto campusDto = new CampusDto();
        BeanUtils.copyProperties(campus,campusDto);
        return campusDto;
    }
}
