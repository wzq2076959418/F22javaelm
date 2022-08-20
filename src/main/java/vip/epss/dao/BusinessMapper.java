package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Business;
import vip.epss.domain.BusinessExample;
import vip.epss.domain.dto.OrderDto;

public interface BusinessMapper {
    long countByExample(BusinessExample example);

    int deleteByExample(BusinessExample example);

    int deleteByPrimaryKey(Integer businessid);

    int insert(Business row);

    int insertSelective(Business row);

    List<Business> selectByExample(BusinessExample example);

    Business getBusinessById(Integer businessid);

    int updateByExampleSelective(@Param("row") Business row, @Param("example") BusinessExample example);

    int updateByExample(@Param("row") Business row, @Param("example") BusinessExample example);

    int updateByPrimaryKeySelective(Business row);

    int updateByPrimaryKey(Business row);
    List<OrderDto> selectByOrderId(Integer orderTypeId);
    List<OrderDto> selectByKey(String key);

}