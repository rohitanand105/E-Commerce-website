package com.example.Cart_Service.controller;

import com.example.Cart_Service.entity.Cart;
import com.example.Cart_Service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addItemToCart(@RequestParam String username,
                                              @RequestParam String productName,
                                              @RequestParam Integer quantity,
                                              @RequestParam Double price) {
        Cart cart = cartService.addItemToCart(username, productName, quantity, price);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@RequestParam String username, @PathVariable Long itemId) {
        Cart cart = cartService.removeItemFromCart(username, itemId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Cart> checkout(@RequestParam String username) {
        Cart cart = cartService.checkout(username);
        return ResponseEntity.ok(cart);
    }
}
