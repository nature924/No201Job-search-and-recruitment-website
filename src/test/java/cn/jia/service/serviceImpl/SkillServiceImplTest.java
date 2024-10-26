package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Skill;
import cn.jia.service.SkillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by matou on 2020/01/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillServiceImplTest {
    Logger logger = LoggerFactory.getLogger(SkillServiceImplTest.class);
    @Autowired
    private SkillService skillService;
    @Test
    public void addOrUpdate() throws Exception {
        Skill skill = new Skill();
        skill.setSkill1("熟悉javaSe,会多线程");
        skill.setSkill2("熟悉javaEE");
        skill.setSkill3("熟悉java开源框架");
        skill.setSkill4("能够使用mysql");
        ServerResponse serverResponse = skillService.addOrUpdate(skill,1);
        logger.info("-----"+serverResponse.getData());
    }

    @Test
    public void findByUserId() throws Exception {
        ServerResponse serverResponse = skillService.findByUserId(1);
        logger.info("-----"+serverResponse.getData());
    }

}