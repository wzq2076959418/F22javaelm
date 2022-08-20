package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Orderdetailet;
import vip.epss.domain.OrderdetailetExample;

public interface OrderdetailetMapper {
    long countByExample(OrderdetailetExample example);

    int deleteByExample(OrderdetailetExample example);

    int deleteByPrimaryKey(Integer odid);

    /**
     * saveOrderDetailetBatch
     * @param list
     * @return
     */
    int saveOrderDetailetBatch(List<Orderdetailet> list);




    /**
     *
     * @param orderId
     * @return
     */
    List<Orderdetailet> listOrderDetailetByOrderId(Integer orderId);

    int updateByExampleSelective(@Param("row") Orderdetailet row, @Param("example") OrderdetailetExample example);

    int updateByExample(@Param("row") Orderdetailet row, @Param("example") OrderdetailetExample example);

    int updateByPrimaryKeySelective(Orderdetailet row);

    int updateByPrimaryKey(Orderdetailet row);
}