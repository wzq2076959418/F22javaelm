package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.BusinessMapper;
import vip.epss.dao.FoodMapper;
import vip.epss.domain.Food;
import vip.epss.domain.dto.OrderDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    BusinessMapper businessMapper= null;
    FoodMapper foodMapper =null;

    public FoodServiceImpl(){
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
        businessMapper = sqlSession.getMapper(BusinessMapper.class);
        foodMapper = sqlSession.getMapper(FoodMapper.class);
    }


    @Override
    public List<OrderDto> searchOrder(Integer orderTypeId) throws Exception{

        List<OrderDto>  list=businessMapper.selectByOrderId(orderTypeId);

        return list;
    }

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list =foodMapper.listFoodByBusinessId(businessId);
        return list;
    }
}
