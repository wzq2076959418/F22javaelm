package vip.epss.service;

import vip.epss.domain.Cart;
import vip.epss.domain.dto.CartDto;

import java.util.List;

public interface CartService {

    List<CartDto> queryCartList(CartDto cartDto);
    int saveCart(Cart cart);
    int deleteCart(Cart Cart);
    int updateCart(Cart cart);
}
