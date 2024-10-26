package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Education;
import cn.jia.service.EducationService;
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
public class EducationServiceImplTest {
    Logger logger = LoggerFactory.getLogger(EducationServiceImplTest.class);
    @Autowired
    private EducationService educationService;
    @Test
    public void addOrUpdate() throws Exception {
        Education education = new Education();
        education.setLevel("硕士");
        education.setFromTime("2014/9");
        education.setToTime("2018/06");
        education.setSchool("东莞理工学院");
        ServerResponse serverResponse = educationService.addOrUpdate(education,1);
        logger.info("-----" + serverResponse.getData());
    }

    @Test
    public void findByUserId() throws Exception {
        ServerResponse serverResponse = educationService.findByUserId(1);
        logger.info("-----" + serverResponse.getData());
    }

}