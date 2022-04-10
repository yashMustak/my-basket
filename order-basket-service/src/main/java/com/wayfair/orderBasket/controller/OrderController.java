package com.wayfair.orderBasket.controller;

import com.wayfair.orderBasket.controller.BasketService;
import com.wayfair.orderBasket.http.header.HeaderGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrderController {
    
    @Autowired
    HeaderGenerator headerGenerator;
    @Autowired
    BasketService basketService;

    @GetMapping(value = "/basket")
    public ResponseEntity<List<Object>> getbasketId(@RequestHeader(value = "Cookie") String basketId){
        List<Object> basket = basketService.getBasket(basketId);
        if(!basket.isEmpty()) {
            return new ResponseEntity<List<Object>>(
                    basket,
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<List<Object>>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/basket", params = {"productId", "quantity"})
    public ResponseEntity<List<Object>> addItemToBasket(
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") Integer quantity,
            @RequestHeader(value = "Cookie") String basketId,
            HttpServletRequest request) {
        List<Object> basket = basketService.getBasket(basketId);
        if(basket != null) {
            if(basket.isEmpty()){
                basketService.addItemToCart(basketId, productId, quantity);
            }else{
                if(basketService.checkIfItemIsExist(basketId, productId)){
                    basketService.changeItemQuantity(basketId, productId, quantity);
                }else {
                    basketService.addItemToCart(basketId, productId, quantity);
                }
            }
            return new ResponseEntity<List<Object>>(
                    basket,
                    headerGenerator.getHeadersForSuccessPostMethod(request, Long.parseLong(basketId)),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<List<Object>>(
                headerGenerator.getHeadersForError(),
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/basket", params = "productId")
    public ResponseEntity<Void> removeItemFromBasket(
            @RequestParam("productId") Long productId,
            @RequestHeader(value = "Cookie") String basketId){
        List<Object> cart = basketService.getCart(basketId);
        if(cart != null) {
            basketService.deleteItemFromCart(basketId, productId);
            return new ResponseEntity<Void>(
                    headerGenerator.getHeadersForSuccessGetMethod(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<Void>(
                headerGenerator.getHeadersForError(),
                HttpStatus.NOT_FOUND);
    }
}

