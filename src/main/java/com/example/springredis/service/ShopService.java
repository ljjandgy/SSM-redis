package com.example.springredis.service;

import com.example.springredis.dao.ShopDao;
import com.example.springredis.domain.ShopDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 商铺service
 */
@Service("ShopService")
public class ShopService implements IShopService  {
    @Autowired
    ShopDao shopDao;

    @Override
    public List<ShopDomain> getShopList() {
        return shopDao.selectAll();
    }

    @Override
    public void insertShop(ShopDomain shopDomain) {
        shopDao.insert(shopDomain);
    }

    @Override
    public void updateShop(ShopDomain shopDomain, Example example) {
        shopDao.updateByExample(shopDomain,example);
    }

    @Override
    public void updateShopByKey(ShopDomain shopDomain) {
        shopDao.updateByPrimaryKey(shopDomain);
    }

    @Override
    public ShopDomain selectShopOne(ShopDomain shopDomain) {
       return shopDao.selectOne(shopDomain);
    }

    @Override
    public void deleteOne(ShopDomain shopDomain) {
        shopDao.delete(shopDomain);
    }

}
