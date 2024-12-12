package com.example.Cart_Service.service;

import com.example.Cart_Service.entity.Cart;
import com.example.Cart_Service.entity.CartItem;
import com.example.Cart_Service.repository.CartRepository;
import com.example.Cart_Service.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // Add item to cart
    public Cart addItemToCart(String username, String productName, Integer quantity, Double price) {
        Optional<Cart> cartOptional = cartRepository.findByUsername(username);
        Cart cart;
        if (cartOptional.isPresent()) {
            cart = cartOptional.get();
        } else {
            cart = new Cart();
            cart.setUsername(username);
        }

        CartItem cartItem = new CartItem();
        cartItem.setProductName(productName);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);


        cart.getItems().add(cartItem);
        cart.setTotalAmount(cart.getTotalAmount() + (quantity * price));

        cartItemRepository.save(cartItem);
        return cartRepository.save(cart);
    }

    // Remove item from cart
    public Cart removeItemFromCart(String username, Long itemId) {
        Optional<Cart> cartOptional = cartRepository.findByUsername(username);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.getItems().removeIf(item -> item.getId().equals(itemId));
            return cartRepository.save(cart);
        }
        return null;
    }

    // Checkout
    public Cart checkout(String username) {
        Optional<Cart> cartOptional = cartRepository.findByUsername(username);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            // Process payment logic could be here
            return cart;
        }
        return null;
    }
}
