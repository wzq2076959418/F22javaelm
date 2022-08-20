package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Deliveryaddress;
import vip.epss.domain.DeliveryaddressExample;

public interface DeliveryaddressMapper {
    long countByExample(DeliveryaddressExample example);

    int deleteByExample(DeliveryaddressExample example);

    int deleteByPrimaryKey(Integer daid);

    int insert(Deliveryaddress row);

    int insertSelective(Deliveryaddress row);

    /**
     *
     * @param userId
     * @return
     */
    List<Deliveryaddress> listDeliveryAddressByUserId(String userId);


    Deliveryaddress selectByPrimaryKey(Integer daid);

    int updateByExampleSelective(@Param("row") Deliveryaddress row, @Param("example") DeliveryaddressExample example);

    int updateByExample(@Param("row") Deliveryaddress row, @Param("example") DeliveryaddressExample example);

    int updateByPrimaryKeySelective(Deliveryaddress row);

    int updateByPrimaryKey(Deliveryaddress row);
}