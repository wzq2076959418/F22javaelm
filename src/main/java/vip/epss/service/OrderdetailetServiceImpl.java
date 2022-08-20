package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.BusinessMapper;
import vip.epss.dao.OrderdetailetMapper;
import vip.epss.domain.Orderdetailet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OrderdetailetServiceImpl implements OrderdetailetService {
    OrderdetailetMapper orderdetailetMapper;

    public OrderdetailetServiceImpl(){
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
        orderdetailetMapper = sqlSession.getMapper(OrderdetailetMapper.class);
    }


    @Override
    public List<Orderdetailet> listOrderDetailetByOrderId(Integer orderId) {
        List<Orderdetailet> list = new ArrayList<>();
       list= orderdetailetMapper.listOrderDetailetByOrderId(orderId);

        return list;
    }

    @Override
    public int saveOrderDetailetBatch(List<Orderdetailet> list) {


        return 0;
    }
}
