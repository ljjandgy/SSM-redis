package com.example.springredis.service;

import com.example.springredis.domain.ShopDomain;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public interface IShopService {
    public List<ShopDomain> getShopList();
    public void insertShop(ShopDomain shopDomain);
    public void updateShop(ShopDomain shopDomain, Example example);
    public ShopDomain selectShopOne(ShopDomain shopDomain);
    public void deleteOne(ShopDomain shopDomain);
    public void updateShopByKey(ShopDomain shopDomain);
}
