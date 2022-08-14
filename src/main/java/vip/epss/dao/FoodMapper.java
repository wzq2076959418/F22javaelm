package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Food;
import vip.epss.domain.FoodExample;

public interface FoodMapper {
    long countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer foodid);

    int insert(Food row);

    int insertSelective(Food row);

    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Integer foodid);

    int updateByExampleSelective(@Param("row") Food row, @Param("example") FoodExample example);

    int updateByExample(@Param("row") Food row, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food row);

    int updateByPrimaryKey(Food row);
}