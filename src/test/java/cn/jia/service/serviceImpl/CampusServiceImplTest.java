package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Campus;
import cn.jia.service.CampusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.in;
import static org.junit.Assert.*;

/**
 * Created by matou on 2020/01/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CampusServiceImplTest {
    org.slf4j.Logger logger = LoggerFactory.getLogger(CampusServiceImplTest.class);
    @Autowired
    private CampusService campusService;
    @Test
    public void add() throws Exception {
        Campus campus = new Campus();
        campus.setAward("国家奖学金");
        campus.setDuty("当任班长");
        ServerResponse serverResponse = campusService.addOrUpdate(campus,1);
        logger.info("-----"+serverResponse.getData().toString());
    }
    @Test
    public void update(){
    }
    @Test
    public void findByUserId() throws Exception {
        ServerResponse serverResponse  = campusService.findByUserId(1);
        logger.info("---------"+serverResponse.getData());

    }

}