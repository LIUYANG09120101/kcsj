package cn.kcsj.Test;


import cn.kcsj.Dao.UserDao;
import cn.kcsj.javaBean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        UserDao dao = session.getMapper(UserDao.class);
        // 查询所有数据
        List<User> list = dao.findAllUser();
        for(User user : list){
            System.out.println(user);
        }
        // 关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        User user = new User();
        user.setUserName("李东");
        user.setUserId("11703990639");
        user.setPassword("lidongsb");

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        UserDao dao = session.getMapper(UserDao.class);

        // 保存
        dao.insertUser(user);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

}
