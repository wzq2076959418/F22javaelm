package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.DeliveryaddressMapper;
import vip.epss.domain.Deliveryaddress;
import vip.epss.service.DeliveryAddressService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    DeliveryaddressMapper deliveryaddressMapper= null;

    public DeliveryAddressServiceImpl(){
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
        deliveryaddressMapper = sqlSession.getMapper(DeliveryaddressMapper.class);
    }


    @Override
    public int updateDeliveryAddress(Deliveryaddress deliveryAddress) {
        int i=0;
        i = deliveryaddressMapper.updateDeliveryAddress(deliveryAddress);

        return i;
    }

    @Override
    public List<Deliveryaddress> listDeliveryAddressByUserId(String userId) {
        List<Deliveryaddress> li = deliveryaddressMapper.listDeliveryAddressByUserId(userId);
        return li;
    }

    @Override
    public int saveDeliveryAddress(Deliveryaddress deliveryAddress) {
        int i=0;
        i = deliveryaddressMapper.saveDeliveryAddress(deliveryAddress);
        return i;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        int i=0;
        i = deliveryaddressMapper.removeDeliveryAddress(daId);
        return i;
    }

    @Override
    public Deliveryaddress getDeliveryAddressById(Integer daid) {
        Deliveryaddress deliveryaddress=deliveryaddressMapper.getDeliveryAddressById(daid);
        return deliveryaddress;
    }
}
