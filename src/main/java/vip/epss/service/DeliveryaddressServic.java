package vip.epss.service;

import vip.epss.domain.Deliveryaddress;

import java.util.List;

public interface DeliveryaddressServic {
    List<Deliveryaddress> listDeliveryAddressByUserId(String userId);
}
