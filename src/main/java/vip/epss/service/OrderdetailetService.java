package vip.epss.service;

import vip.epss.domain.Orderdetailet;

import java.util.List;

public interface OrderdetailetService {
    List<Orderdetailet> listOrderDetailetByOrderId(Integer orderId);
    int saveOrderDetailetBatch(List<Orderdetailet> list);
}
