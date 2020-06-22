package cn.kcsj.Test;

import cn.kcsj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *测试Spring
 */
public class TestSpring {
    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        UserService as = (UserService) ac.getBean("userService");
        // 调用方法
        as.findAllUser();
    }
}
