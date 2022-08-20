package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.domain.UserExample;
import vip.epss.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl extends UserService {
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


//    @Override
//    public int saveUser(User user) {
//        int i=0;
////        i=userMapper.saveUser(user);
//        i = userMapper.insertSelective(user);
//        return i;
//    }
//
//    @Override
//    public User getUserByIdByPass(String userId, String password) {
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andUseridEqualTo(userId).andPasswordEqualTo(password);
//
//
//        List<User> list = userMapper.selectByExample(userExample);
//
//        return list.get(0);
////        return null;
//    }
//
//    @Override
//    public User getUserById(String userId) {
////        User user=userMapper.getUserById(userId);
//        User user1 = userMapper.selectByPrimaryKey(userId);
//        return user1;
////        return null;
//    }
}
