package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.api.IShoppingCartService;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping(value = "/get")
    public ShoppingCartDto queryShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto){
        return shoppingCartService.queryShoppingCart(shoppingCartDto);
    }

}
