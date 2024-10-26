package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Resume;
import cn.jia.domain.Skill;
import cn.jia.dto.SkillDto;
import cn.jia.mapper.ResumeMapper;
import cn.jia.mapper.SkillMapper;
import cn.jia.service.SkillService;
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
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    @Transactional
    public ServerResponse addOrUpdate(Skill skill, Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        skill.setUserId(userId);
        Skill skill1 = skillMapper.selectByUserId(userId);
        if (skill1 == null){
            //新增
            int i = skillMapper.insert(skill);
            if (i < 1){
                return ServerResponse.buildErrorMsg("新增技能失败");
            }
            return ServerResponse.buildSuccessData(entityToDto(skill));
        }
        skill.setUpdateTime(new Date());
        int i = skillMapper.updateByUserIdSelective(skill);
        if (i<1){
            return ServerResponse.buildErrorMsg("更新失败");
        }
        List<Resume> resumes = resumeMapper.findByUserId(userId);
        if (resumes == null || resumes.size() == 0){
            Resume resume = new Resume();
            resume.setUserId(userId);
            resumeMapper.insert(resume);
        }
        return ServerResponse.buildSuccessData(entityToDto(skill));
    }

    @Override
    public ServerResponse findByUserId(Integer userId) {
        if (userId == null){
            return ServerResponse.buildErrorMsg("参数不能为空");
        }
        Skill skill = skillMapper.selectByUserId(userId);
        if (skill == null){
            return null;
        }
        return ServerResponse.buildSuccessData(entityToDto(skill));
    }

    public SkillDto entityToDto(Skill skill){
        SkillDto skillDto = new SkillDto();
        BeanUtils.copyProperties(skill,skillDto);
        return skillDto;
    }
}
