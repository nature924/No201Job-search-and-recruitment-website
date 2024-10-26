package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Information;
import cn.jia.service.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by matou on 2019/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResumeServiceImplTest {
    org.slf4j.Logger logger = LoggerFactory.getLogger(ResumeServiceImplTest.class);
    @Autowired
    private ResumeService resumeService;
    @Test
    public void addResume() throws Exception {
        Information information = new Information();
        information.setPoliStatus("团员");
        information.setPhone("1211111");
        information.setName("123");
        information.setSex("男");
        information.setEmail("920358803@qq.com");
        information.setJobIntension("java开发");
        information.setDescribes("henhao");
        information.setUserId(1);

       // ServerResponse response = resumeService.addOrUpdateResume(information,eduWork);
       // logger.info(response.toString());
    }

    @Test
    public void updateResume() throws Exception {
        Information information = new Information();
        information.setPoliStatus("中共党员");
        information.setPhone("122222");
        information.setName("shujia");
        information.setSex("男");
        information.setEmail("920358803@qq.com");
        information.setJobIntension("java开发");
        information.setDescribes("henhao");
        information.setCreateTime(new Date());
        information.setUpdateTime(new Date());
        information.setUserId(1);

       // ServerResponse response = resumeService.addOrUpdateResume(information,eduWork);
        //logger.info(response.toString());
    }

    @Test
    public void upload() throws Exception {
          String condiction = "深圳  广州  ";
          //String[] arr = condiction.split(" ");
          char[] arr = condiction.toCharArray();
          for (int i = 0;i<arr.length;i++){
              System.out.println((int)arr[i]);
          }

         // System.out.println("dayin:"+arr.toString());

    }

    @Test
    public void findAll(){
       ServerResponse serverResponse = resumeService.showAll(1,5);
      System.out.println(serverResponse.getData());
    }

}