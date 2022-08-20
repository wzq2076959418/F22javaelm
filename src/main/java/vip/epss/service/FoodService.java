package vip.epss.service;

import vip.epss.domain.Food;
import vip.epss.domain.dto.OrderDto;

import java.util.List;

public interface FoodService {
    List<OrderDto> searchOrder(Integer orderTypeId) throws Exception;
    List<Food> listFoodByBusinessId(Integer businessId);
}
