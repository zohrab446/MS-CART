package com.example.mscart.service.Cart;

import com.example.mscart.dto.request.cart.CreateCartRequest;
import com.example.mscart.dto.request.cart.UpdateCartRequest;
import com.example.mscart.dto.response.CartDto;
import com.example.mscart.entity.Cart;
import com.example.mscart.entity.Item;
import com.example.mscart.repository.CartRepository;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements CartServiceInter {
    private final CartRepository cartRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createCart(CreateCartRequest createCartRequest) {
        Cart cart=Cart.builder()
                .cartId(Long.valueOf(createCartRequest.getCartId()))
                .userId(Long.valueOf(createCartRequest.getUserId()))
                .build();
        cartRepository.save(cart);
    }
    @Override
    public CartDto findById(Long id) {

            Cart cart= cartRepository.findByCartId(id);
            CartDto cartDto = modelMapper.map(cart,CartDto.class);
            return cartDto;
    }
    @Override
    public CartDto updateCart(Long id, UpdateCartRequest updateCartRequest) {
        Cart cart=cartRepository.findByCartId(id);
        cart.setCartId(updateCartRequest.getCartId());
        cart.setUserId(updateCartRequest.getUserId());

        cartRepository.save(cart);
        return modelMapper.map(cart,CartDto.class);
    }
    @Override
    public void deleteCart(Long id) {
        Cart cart=cartRepository.findByCartId(id);
        cartRepository.delete(cart);
    }


    @Override
    public void removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (cart != null) {
            cart.getCartItemIds().remove(itemId);
            cartRepository.save(cart);
        }
    }

    @Override
    public void clearCart(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        optionalCart.ifPresent(cart -> {
            cart.clearItems();
            cartRepository.save(cart);
        });
    }

    @Override
    public void addItemToCart(Long cartId, Long itemId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            Item item = new Item();
            item.setItemId(itemId);
            cart.add(item);
            cartRepository.save(cart);
        } else {
            // Hata durumu veya uygun işlem
        }
    }


    @Override
    public List<CartDto> getAll() {
        return null;
    }
}
