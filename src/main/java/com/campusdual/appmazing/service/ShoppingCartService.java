package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IShoppingCartService;
import com.campusdual.appmazing.model.ShoppingCart;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dao.ShoppingCartDao;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import com.campusdual.appmazing.model.dto.dtomapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Override
    public ShoppingCartDto queryShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = ShoppingCartMapper.INSTANCE.toEntity(shoppingCartDto);
        return ShoppingCartMapper.INSTANCE.toDTO(shoppingCartDao.getReferenceById(shoppingCart.getId()));
    }

    @Override
    public List<ShoppingCartDto> queryAllShoppingCarts() {
        return null;
    }

    @Override
    public int insertShoppingCart(ShoppingCartDto shoppingCartDto) {
        return 0;
    }

    @Override
    public int updateShoppingCart(ShoppingCartDto shoppingCartDto) {
        return 0;
    }

    @Override
    public int deleteShoppingCart(ShoppingCartDto shoppingCartDto) {
        return 0;
    }
}
