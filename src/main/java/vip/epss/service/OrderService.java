package vip.epss.service;

import vip.epss.domain.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> searchOrder(Integer orderTypeId) throws Exception;
}
