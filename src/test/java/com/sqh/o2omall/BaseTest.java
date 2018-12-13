package com.sqh.o2omall;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 整合Spring和junit,junit启动时加载SpringIOC容器
 *
 * @author sqh
 * @date 2018/12/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BaseTest {

}
