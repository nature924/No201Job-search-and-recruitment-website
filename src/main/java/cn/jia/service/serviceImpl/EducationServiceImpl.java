package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Education;
import cn.jia.domain.Resume;
import cn.jia.dto.EducationDto;
import cn.jia.mapper.EducationMapper;
import cn.jia.mapper.ResumeMapper;
import cn.jia.service.EducationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by matou on 2020/01/11.
 */
@Service
public class EducationServiceImpl implements EducationService{

   @Autowired
   private EducationMapper educationMapper;

   @Autowired
   private ResumeMapper resumeMapper;
    @Override
    public ServerResponse addOrUpdate(Education education, Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        education.setUserId(userId);
        Education education1 = educationMapper.selectByUserId(userId);
        if (education1 == null){
            //新增
            int i = educationMapper.insert(education);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增教育失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(education));
        }
        education.setUpdateTime(new Date());
        int i = educationMapper.updateByUserIdSelective(education);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        List<Resume> resumes = resumeMapper.findByUserId(userId);
        if (resumes == null || resumes.size() == 0){
            Resume resume = new Resume();
            resume.setUserId(userId);
            resumeMapper.insert(resume);
        }
        return ServerResponse.buildSuccessData(entityToDto(education));
    }

    @Override
    public ServerResponse findByUserId(Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Education education = educationMapper.selectByUserId(userId);
        if (education == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(education));
    }
    public EducationDto entityToDto(Education education){
        EducationDto educationDto = new EducationDto();
        educationDto.setFromTime(education.getFromTime());
        educationDto.setLevel(education.getLevel());
        educationDto.setToTime(education.getToTime());
        educationDto.setSchool(education.getSchool());
        return educationDto;
    }
}
