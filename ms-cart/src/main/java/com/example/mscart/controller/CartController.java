package com.example.mscart.controller;

import com.example.mscart.dto.request.cart.CreateCartRequest;
import com.example.mscart.dto.request.cart.UpdateCartRequest;
import com.example.mscart.dto.response.CartDto;
import com.example.mscart.service.Cart.CartServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/Brend",method = RequestMethod.PUT)
@RequiredArgsConstructor
public class CartController {


        private final CartServiceInter cartServiceInter;

        @PutMapping("/createCart")
        public void createCart(@RequestBody CreateCartRequest cart){
            cartServiceInter.createCart(cart);
        }
        @GetMapping("/findCart/{id}")
        public CartDto findByCartID(@PathVariable long id){
            return cartServiceInter.findById((long)id);
        }

        @DeleteMapping("/removeCart/{id}")
        public void deleteCart(@PathVariable long id){
            cartServiceInter.deleteCart((long)id);
        }

        @DeleteMapping("/remove/{cartId}/{itemId}")
        public void removeCartItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        cartServiceInter.removeItemFromCart(cartId, itemId);
        }

        @PatchMapping("/updateCart/{id}")
        public CartDto updateCart(@PathVariable long id, @RequestBody UpdateCartRequest updateCartRequest){
            return cartServiceInter.updateCart((long)id,updateCartRequest);
        }
        @GetMapping("/listCart")
        public List<CartDto> getAll(){
            return cartServiceInter.getAll();
        }

        @DeleteMapping("/{cartId}/clear-cart")
        public CartDto  clearCart(@PathVariable Long cartId) {
        cartServiceInter.clearCart(cartId);
        return CartDto.builder().build();
        }

        @PostMapping("/{cartId}/add-item")
        public CartDto addItemToCart(@PathVariable Long cartId, @RequestParam long itemId) {
        cartServiceInter.addItemToCart(cartId, itemId);
        return CartDto.builder().build();
        }

}
