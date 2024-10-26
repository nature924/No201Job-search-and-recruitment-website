package cn.jia.service;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Skill;
import cn.jia.dto.SkillDto;

/**
 * Created by matou on 2020/01/11.
 */
public interface SkillService {
    ServerResponse addOrUpdate(Skill skill, Integer userId);
    ServerResponse findByUserId(Integer userId);
    SkillDto entityToDto(Skill skill);
}
