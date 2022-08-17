package vip.epss.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import vip.epss.domain.Cart;
import vip.epss.domain.CartExample;
import vip.epss.domain.dto.CartDto;

public interface CartMapper {
    long countByExample(CartExample example);



    int deleteByPrimaryKey(Integer cartid);
    int insertSelective(Cart row);

    /**
     * listCart
     * @param cartDto
     * @return
     */
    List<CartDto> listCart(CartDto cartDto);

    /**
     * deleteCart
     * @param Cart
     * @return
     */
    int deleteCart(Cart Cart);

    int updateByExampleSelective(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByExample(@Param("row") Cart row, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart row);

    /**
     * updateart
     * @param cart
     * @return
     */
    int updateCart(Cart cart);

    /**
     * insertCart
     * @param cart
     * @return
     */
    int insertCart(Cart cart);
}