package vip.epss.service;

import vip.epss.domain.Business;
import vip.epss.domain.dto.OrderDto;

import java.util.List;

public interface BusinessService {
    List<OrderDto> selectByKey(String Key) throws Exception;
    Business getBusinessById(Integer businessid);
}
