package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Resume;
import cn.jia.domain.Work;
import cn.jia.dto.WorkDto;
import cn.jia.mapper.ResumeMapper;
import cn.jia.mapper.WorkMapper;
import cn.jia.service.WorkService;
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
public class WorkServiceImpl implements WorkService{

    @Autowired
    private WorkMapper workMapper;
    @Autowired
    private ResumeMapper resumeMapper;


    @Override
    @Transactional
    public ServerResponse addOrUpdate(Work work, Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        work.setUserId(userId);
        Work work1 = workMapper.selectByUserId(userId);
        if (work1 == null){
            //新增
            int i = workMapper.insert(work);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增工作失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(work));
        }
        work.setUpdateTime(new Date());
        int i = workMapper.updateByUserIdSelective(work);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        List<Resume> resumes = resumeMapper.findByUserId(userId);
        if (resumes == null || resumes.size() == 0){
            Resume resume = new Resume();
            resume.setUserId(userId);
            resumeMapper.insert(resume);
        }
        return ServerResponse.buildSuccessData(entityToDto(work));
    }

    @Override
    public ServerResponse findByUserId(Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Work work = workMapper.selectByUserId(userId);
        if (work == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(work));
    }

    public WorkDto entityToDto(Work work){
        WorkDto workDto = new WorkDto();
        BeanUtils.copyProperties(work,workDto);
        return workDto;
    }
}
