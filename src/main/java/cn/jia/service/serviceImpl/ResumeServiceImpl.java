package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Grade;
import cn.jia.domain.Information;
import cn.jia.domain.Resume;
import cn.jia.dto.*;
import cn.jia.mapper.*;
import cn.jia.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by matou on 2019/11/25.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private InformationService informationService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private WorkService workService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CampusService campusService;
    @Autowired
    private SkillService skillService ;

    @Autowired
    private ResumeMapper resumeMapper;

  /*  @Autowired
    private UserMapper userMapper;*/
    //展现简历
 //   @Cacheable("resumeCache")
    public ServerResponse show(int userId){
        List<Resume> resume = resumeMapper.findByUserId(userId);
        if(resume == null || resume.size() == 0){
            return  null;
        }
        ResumeDto resumeDto = entityToDto(resume.get(0));
        return ServerResponse.buildSuccessData(resumeDto);
    }


    public ServerResponse showAll(int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<ResumeDto> resumeDtos = Lists.newArrayList();
        List<Resume> resumes = resumeMapper.findAll();
        if (resumes == null || resumes.size() == 0){
            return ServerResponse.buildErrorMsg("没有投递的信息");
        }
        for (Resume resume:resumes) {

            ResumeDto resumeDto = entityToDto(resume);
            resumeDtos.add(resumeDto);
        }
        /*List<Integer> integers = resumeMapper.findUserId();
        if (integers == null || integers.size() == 0){
            return ServerResponse.buildErrorMsg("没有投递的信息");
        }
        for (int userId:integers){
            Resume resume = resumeMapper.findByUserId(userId);
            ResumeDto resumeDto = entityToDto(resume);
            resumeDtos.add(resumeDto);
        }*/
        PageInfo pageInfo = new PageInfo(resumes);
        pageInfo.setList(resumeDtos);
        return ServerResponse.buildSuccessData(pageInfo);
    }

    /**
     * 判断是投递的是在线简历是附件简历
     * @param userId
     * @return
     */
    public ServerResponse judge(int userId,String pName){
        int flag = resumeMapper.findFlagByUserIdAndPName(userId,pName);
        int r = resumeMapper.updateR(userId,pName);
         if (flag == 1 && r > 0){
             //在线简历
             return ServerResponse.buildSuccessData(1);
         }
         if (flag == 2 && r > 0){
             //附件文件
             InformationDto informationDto =(InformationDto) informationService.findByUserId(userId).getData();
             String file = informationDto.getFiles();
             return ServerResponse.buildSuccessData(file);
         }
        return  null;
    }


    //查找
    public ServerResponse query(String positionName,int pageIndex,int pageSize){
        PageHelper.startPage(pageIndex,pageSize);
        List<ResumeDto> dtoList = Lists.newArrayList();
        List<Resume> resumeList = resumeMapper.findPositionLikeName(positionName);
        if (resumeList == null && resumeList.size() == 0){
            return ServerResponse.buildErrorMsg("不存在相应的简历");
        }
        for (Resume r:resumeList) {
            ResumeDto dto = entityToDto(r);
            dtoList.add(dto);
        }
        PageInfo pageInfo = new PageInfo(resumeList);
        pageInfo.setList(dtoList);
        return ServerResponse.buildSuccessData(pageInfo);
    }

    @Override
    @Transactional
    public ServerResponse delete(Integer id) {
        if (id == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        int a = resumeMapper.delete(id);
        if (a < 1){
            return ServerResponse.buildErrorMsg("删除失败");
        }
        return ServerResponse.buildSuccessMsg("删除成功");
    }

    private ResumeDto entityToDto(Resume resume){
        ResumeDto resumeDto = new ResumeDto();
        resumeDto.setId(resume.getId());
        resumeDto.setUserId(resume.getUserId());
        resumeDto.setFlag(resume.getFlag());
        resumeDto.setPositionName(resume.getPositionName());
        if (resume.getInformation() != null){
            InformationDto informationDto = informationService.entityToDto(resume.getInformation());
            resumeDto.setInformationDto(informationDto);
        }else{
            InformationDto informationDto = new InformationDto();
            informationDto.setName("----");
            informationDto.setDescribes("------");
            resumeDto.setInformationDto(informationDto);
        }
        if (resume.getCampus() != null){
            CampusDto campusDto = campusService.entityToDto(resume.getCampus());
            resumeDto.setCampusDto(campusDto);
        }
        if (resume.getProject() != null){
            ProjectDto projectDto = projectService.entityToDto(resume.getProject());
            resumeDto.setProjectDto(projectDto);
        }
        if (resume.getEducation() != null){
            EducationDto educationDto = educationService.entityToDto(resume.getEducation());
            resumeDto.setEducationDto(educationDto);
        }else{
            EducationDto educationDto = new EducationDto();
            educationDto.setLevel("-----");
            resumeDto.setEducationDto(educationDto);
        }
        if (resume.getSkill() != null){
            SkillDto skillDto = skillService.entityToDto(resume.getSkill());
            resumeDto.setSkillDto(skillDto);
        }
        if (resume.getWork() != null){
            WorkDto workDto = workService.entityToDto(resume.getWork());
            resumeDto.setWorkDto(workDto);
        }
        if (resume.getGrade()!=null){
            GradeDto gradeDto =new  GradeDto();
            gradeDto.setId(resume.getGrade().getId());
            gradeDto.setScore(resume.getGrade().getScore());
            gradeDto.setClassify(resume.getGrade().getClassify());
            gradeDto.setOrigQuest(resume.getGrade().getOrigQuest());
            gradeDto.setScoreDetail(resume.getGrade().getScoreDetail());
            resumeDto.setGradeDto(gradeDto);
        }else{
            GradeDto gradeDto = new GradeDto();
            
            
            gradeDto.setScore(0f);
            gradeDto.setClassify("");
            resumeDto.setGradeDto(gradeDto);
        }
        resumeDto.setR(resume.getR());
        return resumeDto;
    }
}
