package vip.epss.service;

import vip.epss.domain.Deliveryaddress;
import vip.epss.domain.DeliveryaddressExample;
import vip.epss.domain.dto.OrderDto;

import java.util.List;

public interface DeliveryAddressService {





    int updateDeliveryAddress(Deliveryaddress deliveryAddress);

    List<Deliveryaddress> listDeliveryAddressByUserId(String userId);

    int saveDeliveryAddress(Deliveryaddress deliveryAddress);

    int removeDeliveryAddress(Integer daId);

    Deliveryaddress getDeliveryAddressById(Integer daid);


}
