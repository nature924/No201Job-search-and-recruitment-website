package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Work;
import cn.jia.service.WorkService;
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
public class WorkServiceImplTest {
    Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class);
    @Autowired
    private WorkService workService;
    @Test
    public void addOrUpdate() throws Exception {
        Work work = new Work();
        work.setCompany("广州亿程交通信息");
        work.setDuty("java开发");
        work.setResponsibility("负责服务端的东西");
        work.setFromTime("2018/01/15");
        work.setToTime("2020/01/01");
        ServerResponse serverResponse = workService.addOrUpdate(work,1);
        logger.info("-------"+serverResponse.getData());
    }

    @Test
    public void findByUserId() throws Exception {
        ServerResponse serverResponse = workService.findByUserId(1);
        logger.info("-------"+serverResponse.getData());
    }

}