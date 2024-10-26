package cn.jia.service.serviceImpl;

import cn.jia.common.ServerResponse;
import cn.jia.service.CollectionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by matou on 2020/01/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionServiceImplTest {

    @Autowired
    private CollectionService collectionService;
    @Test
    public void show() throws Exception {
        ServerResponse serverResponse = collectionService.show(1,1,5);
        System.out.println(serverResponse.getData());
    }

    @Test
    public void cancelCollection() throws Exception {
        ServerResponse serverResponse = collectionService.cancelCollection(2);
        System.out.println(serverResponse.getMsg());
    }

}