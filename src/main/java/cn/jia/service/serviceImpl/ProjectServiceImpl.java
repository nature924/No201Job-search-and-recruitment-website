package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Project;
import cn.jia.domain.Resume;
import cn.jia.dto.ProjectDto;
import cn.jia.mapper.ProjectMapper;
import cn.jia.mapper.ResumeMapper;
import cn.jia.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by matou on 2020/01/11.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public ServerResponse addOrUpdate(Project project, Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        project.setUserId(userId);
        Project project1 = projectMapper.selectByUserId(userId);
        if (project1 == null){
            //新增
            int i = projectMapper.insert(project);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增项目失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(project));
        }
        project.setUpdateTime(new Date());
        int i = projectMapper.updateByUserIdSelective(project);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        List<Resume> resumes = resumeMapper.findByUserId(userId);
        if (resumes == null || resumes.size() == 0){
            Resume resume = new Resume();
            resume.setUserId(userId);
            resumeMapper.insert(resume);
        }
        return ServerResponse.buildSuccessData(entityToDto(project));
    }

    @Override
    public ServerResponse findByUserId(Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Project project = projectMapper.selectByUserId(userId);
        if (project == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(project));
    }

    public ProjectDto entityToDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(project,projectDto);
        return projectDto;
    }
}
