package cn.jia;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		String password = "123456";
		Md5Hash md5Hash = new Md5Hash(password,"");
		System.out.println(md5Hash.toString());  //827ccb0eea8a706c4c34a16891f84e7b
	}

	@Test
	public void test(){

	}

}
