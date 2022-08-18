package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Deliveryaddress;
import vip.epss.domain.DeliveryaddressExample;

public interface DeliveryaddressMapper {
    long countByExample(DeliveryaddressExample example);



    int deleteByPrimaryKey(Integer daid);

    int insert(Deliveryaddress row);







    int updateByExampleSelective(@Param("row") Deliveryaddress row, @Param("example") DeliveryaddressExample example);

    int updateByExample(@Param("row") Deliveryaddress row, @Param("example") DeliveryaddressExample example);

    int updateByPrimaryKeySelective(Deliveryaddress row);

    int updateDeliveryAddress(Deliveryaddress deliveryAddress);

    List<Deliveryaddress> listDeliveryAddressByUserId(String userId);

    int saveDeliveryAddress(Deliveryaddress deliveryAddress);

    int removeDeliveryAddress(Integer daId);
    Deliveryaddress getDeliveryAddressById(Integer daid);
}