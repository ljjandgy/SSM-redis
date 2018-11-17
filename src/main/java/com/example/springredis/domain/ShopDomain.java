package com.example.springredis.domain;


import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 商店实体
 */
@Table(name = "eb_base_shop")
public class ShopDomain {
    @Column(name = "shop_id")
    @Id
    private String shopId;//主键

    private String vendId;//商家内码
    private String shopName;//商铺名称
    private String shopAddr;//商铺地址

    public ShopDomain(String shopId) {
        this.shopId = shopId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getVendId() {
        return vendId;
    }

    public void setVendId(String vendId) {
        this.vendId = vendId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }
}
