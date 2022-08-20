package vip.epss.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vip.epss.dao.BusinessMapper;
import vip.epss.dao.CartMapper;
import vip.epss.dao.OrderdetailetMapper;
import vip.epss.dao.OrdersMapper;
import vip.epss.domain.Business;
import vip.epss.domain.Cart;
import vip.epss.domain.Orderdetailet;
import vip.epss.domain.Orders;
import vip.epss.domain.dto.CartDto;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    OrdersMapper ordersMapper;
    BusinessMapper businessMapper;
    CartMapper cartMapper;
    OrderdetailetMapper orderdetailetMapper;


    public OrdersServiceImpl() {
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
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        businessMapper = sqlSession.getMapper(BusinessMapper.class);
        cartMapper = sqlSession.getMapper(CartMapper.class);
        orderdetailetMapper = sqlSession.getMapper(OrderdetailetMapper.class);

    }

    @Override
    public int saveOrders(Orders orders) {
        //1、查询当前用户购物车中当前商家的所有食品
        CartDto cartDto = new CartDto();
        cartDto.setBusinessid(orders.getBusinessid());
        cartDto.setUserid(orders.getUserid());
        List<CartDto> cartList = cartMapper.listCart(cartDto);

        //2、查询商家信息（需要使用商家的配送费信息）
        Business business = businessMapper.getBusinessById(orders.getBusinessid());

        //3、获取订单总额
        BigDecimal ordersTotal = BigDecimal.ZERO;  //订单总额
        for (CartDto c : cartList) {
            //累计所有食品总价格
            ordersTotal = ordersTotal.add(c.getFoodprice().multiply(new BigDecimal(c.getQuantity())));
        }
        //加上配送费
        ordersTotal = ordersTotal.add(business.getDeliveryprice());

        //4、创建订单，并获取订单编号
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = simpleDateFormat.format(date);
        orders.setOrderdate(format);
        orders.setOrdertotal(ordersTotal);
        int i = ordersMapper.saveOrders(orders);

        //5、处理相关数据：获取订单明细集合
        List<Orderdetailet> orderDetailetList = new ArrayList<>();  //订单明细集合
        for (CartDto c : cartList) {
            Orderdetailet od = new Orderdetailet();
            od.setOrderid(orders.getOrderid());
            od.setFoodid(c.getFoodid());
            od.setQuantity(c.getQuantity());
            orderDetailetList.add(od);
        }

        //6、批量添加订单明细
        if (orderDetailetList.size() > 0 && orderDetailetList != null) {
            orderdetailetMapper.saveOrderDetailetBatch(orderDetailetList);
        }

        //7、清空当前用户购物车中当前商家的所有食品
        Cart cart = new Cart();
        cart.setBusinessid(orders.getBusinessid());
        cart.setUserid(orders.getUserid());
        cartMapper.deleteCart(cart);
        return orders.getOrderid();
    }
}
