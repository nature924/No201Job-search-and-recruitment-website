package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Project;
import cn.jia.service.ProjectService;
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
public class ProjectServiceImplTest {
    Logger logger = LoggerFactory.getLogger(ProjectServiceImplTest.class);
    @Autowired
    private ProjectService projectService;
    @Test
    public void addOrUpdate() throws Exception {
        Project project = new Project();
        project.setProjectName("OA办公自动化化系统");
        project.setFromTime("2017/09");
        project.setToTime("2017/10");
        project.setDescribes("集成Activiti工作流和使用Spring全家桶");
        ServerResponse serverResponse = projectService.addOrUpdate(project,1);
        logger.info("------"+serverResponse.getData());
    }

    @Test
    public void findByUserId() throws Exception {
        ServerResponse serverResponse = projectService.findByUserId(1);
        logger.info("----"+serverResponse.getData());
    }

}