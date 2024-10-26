package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.domain.Positions;
import cn.jia.service.PositionService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matou on 2020/01/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionServiceImplTest {

    @Autowired
    private PositionService positionService;
    @Test
    public void insert() throws Exception {
        Positions positions = new Positions();
        positions.setpClassify("技术");
        positions.setpDescribe("工作经验1-3年");
        positions.setpName("java开发工程师");
        positions.setpRequest("业务技能要求： 1、熟悉服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地。\n" +
                "2、拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，构建异构计算长期竞争力。\n" +
                "专业知识要求：\n" +
                "1. 计算机科学（机器学习、NLP、计算机视觉、并行计算）、统计学或应用数学博士\n" +
                "2. 精通计算机体系结构，精通处理器和GPU微架构；\n" +
                "3. 熟悉ICT行业如服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地；\n" +
                "4. 在ICT行业10年以上研发工作经验，负责过云计算场景下GPU技术的规划、设计和开发，并获得市场成功；\n" +
                "5. 具备出色的沟通能力和项目拓展能力，较强的成就导向和团队合作意识。");
        positions.setpResponsibility("1. 主导计算平台异构计算领域技术规划并输出SP，完成关键技术项目Charter立项并推动落地，确保技术提前Ready;\n" +
                "2. 制定异构计算关键技术落地节奏，确保计算平台如SIGMA、OSCA、芯片应用等技术综合竞争力领先，支撑公司异构计算产品商业成功；\n" +
                "3. 拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，对异构计算产业的技术准备度和长期竞争力负责。");

        positions.setFlag(1);
        positions.setWorkSite("深圳");
        ServerResponse serverResponse = positionService.insert(positions);
        System.out.println(serverResponse.getMsg());
    }

    @Test
    public void findAllBySocial() throws Exception {
        ServerResponse serverResponse = positionService.findAllBySocial(1,10);
        System.out.println(serverResponse.getData());
    }

    @Test
    public void findSocialByCondiction() throws Exception {
        //ServerResponse serverResponse = positionService.findByCondiction("技术","深圳","实习",10,1,5);
        List<String> pClissify = Lists.newArrayList("技术","销售");
        String workSite = "广州,深圳";
        ServerResponse serverResponse = positionService.findByCondiction(pClissify,null,null,1,"",1,5);
        System.out.println(serverResponse.getData());
    }

    @Test
    public void getDeatils() throws Exception {
        ServerResponse serverResponse = positionService.getDeatils("异构计算平台架构师",1);
        System.out.println(serverResponse.getData());
    }



    @Test
    public void update() throws Exception {
        Positions positions = new Positions();
        positions.setId(1);
        positions.setpClassify("技术");
        positions.setpDescribe("工作经验1-3年");
        positions.setpName("异构计算平台架构师");
        positions.setpRequest("业务技能要求： 1、熟悉服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地。\n" +
                "2、拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，构建异构计算长期竞争力。\n" +
                "专业知识要求：\n" +
                "1. 计算机科学（机器学习、NLP、计算机视觉、并行计算）、统计学或应用数学博士\n" +
                "2. 精通计算机体系结构，精通处理器和GPU微架构；\n" +
                "3. 熟悉ICT行业如服务器、异构计算、网络，特别是云计算等新产品的业界发展趋势和关键技术，能够提炼出对异构计算关键需求并推动业务应用落地；\n" +
                "4. 在ICT行业10年以上研发工作经验，负责过云计算场景下GPU技术的规划、设计和开发，并获得市场成功；\n" +
                "5. 具备出色的沟通能力和项目拓展能力，较强的成就导向和团队合作意识。");
        positions.setpResponsibility("1. 主导计算平台异构计算领域技术规划并输出SP，完成关键技术项目Charter立项并推动落地，确保技术提前Ready;\n" +
                "2. 制定异构计算关键技术落地节奏，确保计算平台如SIGMA、OSCA、芯片应用等技术综合竞争力领先，支撑公司异构计算产品商业成功；\n" +
                "3. 拉通技术体系、结合产品业务，主导异构计算产业关键技术和算法的识别、分析、判断及技术Ready，对异构计算产业的技术准备度和长期竞争力负责。");

        positions.setFlag(1);
        positions.setWorkSite("深圳");
        ServerResponse serverResponse = positionService.update(positions);
        System.out.println(serverResponse.getMsg());
    }

    @Test
    public void deleteByNameAngFlag() throws Exception {
    }


    @Test
    public void findByKeyWord() throws Exception {
        ServerResponse serverResponse = positionService.findByKeyWord("算",1,5,1);
        PageInfo pageInfo = (PageInfo) serverResponse.getData();
        System.out.println(pageInfo.getList());
    }

    @Test
    public void apply() throws Exception {
        ServerResponse serverResponse = positionService.apply(1,1,1);
        System.out.println(serverResponse.getMsg());
    }

    @Test
    public void collect() throws Exception {
        ServerResponse serverResponse = positionService.collect(1,1,1);
        System.out.println(serverResponse.getMsg());
    }

    @Test
    public void findBySchool() throws Exception {
        ServerResponse S = positionService.findBySchool(1,5);
        System.out.println(S.getData());
    }

    @Test
    public void  findByRandom(){
        ServerResponse serverResponse = positionService.findByRandom(1);
        System.out.println(serverResponse.getData());
    }

}