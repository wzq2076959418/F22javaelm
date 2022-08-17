package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.BusinessMapper;
import vip.epss.dao.CartMapper;
import vip.epss.domain.Cart;
import vip.epss.domain.dto.CartDto;
import vip.epss.utils.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CartServiceImpl implements CartService{
    CartMapper cartMapper= null;

    public CartServiceImpl(){
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
        cartMapper = sqlSession.getMapper(CartMapper.class);
    }


    @Override
    public List<CartDto> queryCartList(CartDto cartDto) {
        List<CartDto> list =cartMapper.listCart(cartDto);
        return list;
    }

    @Override
    public int saveCart(Cart cart) {
        int result = 0;

        try {
            DBUtil.getConnection();
            result = cartMapper.insertCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtil.close();
        }

        return result;
    }

    @Override
    public int deleteCart(Cart Cart) {
        int result = 0;

        try {
           DBUtil.getConnection();
           result =cartMapper.deleteCart(Cart);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int updateCart(Cart cart) {
        int result =0;

        try {
            DBUtil.getConnection();
             result = cartMapper.updateCart(cart);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }

}
