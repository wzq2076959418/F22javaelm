package vip.epss.service;

import vip.epss.domain.dto.OrderDto;

import java.util.List;

public interface BusinessService {
    List<OrderDto> searchOrder(Integer orderTypeId);
}
