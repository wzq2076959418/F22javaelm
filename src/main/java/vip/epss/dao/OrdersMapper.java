package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Orders;
import vip.epss.domain.OrdersExample;

public interface OrdersMapper {
    long countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer orderid);

    /**
     * saveOrders
     * @param orders
     * @return
     */
    int saveOrders(Orders orders);

    int insertSelective(Orders row);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("row") Orders row, @Param("example") OrdersExample example);

    int updateByExample(@Param("row") Orders row, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders row);

    int updateByPrimaryKey(Orders row);
}