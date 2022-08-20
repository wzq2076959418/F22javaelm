package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.service.UserService;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceImpl implements UserService {
    UserMapper userMapper = null;

    public UserServiceImpl() {
        String resource = "mybatis.xml";
        InputStream inputStream;//静态工厂方法

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//建造者模式

        SqlSession sqlSession = sqlSessionFactory.openSession(true);//当前session是自动commit的
        //        sqlSession.方法();
        //拿到动态代理生成的实现类
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    @Override
    public int saveUser(User user) {
        int i=0;
        i=userMapper.saveUser(user);
        return i;
    }

    @Override
    public User getUserByIdByPass(String userId, String password) {
        User user=userMapper.getUserByIdByPass(userId,password);
        return user;
    }

    @Override
    public User getUserById(String userId) {
        User user=userMapper.getUserById(userId);
        return user;
    }
}
