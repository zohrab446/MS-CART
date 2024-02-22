package com.example.mscart.service.Cart;

import com.example.mscart.dto.request.cart.CreateCartRequest;
import com.example.mscart.dto.request.cart.UpdateCartRequest;
import com.example.mscart.dto.response.CartDto;
import com.example.mscart.dto.response.ItemDto;
import com.example.mscart.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CartServiceInter {
    void createCart(CreateCartRequest createCartRequest);
    CartDto findById(Long id);
    CartDto updateCart(Long id, UpdateCartRequest updateCartRequest);
    void deleteCart(Long id);
    void removeItemFromCart(Long cartId, Long itemId);
    void clearCart(Long cartId);

    void addItemToCart(Long cartId, Long itemId);

    List<CartDto> getAll();
}
