package vip.epss.test;

import org.apache.ibatis.session.SqlSession;
import vip.epss.dao.UserMapper;
import vip.epss.domain.User;
import vip.epss.utils.GetSqlSession;

public class Test {
    public static void main(String[] args) {
        SqlSession session= GetSqlSession.createSq1Session();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.queryUserByName("whh");
        System.out.println(user);


    }
}
