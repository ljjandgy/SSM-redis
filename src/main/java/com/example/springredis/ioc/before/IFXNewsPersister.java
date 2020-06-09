package com.example.springredis.ioc.before;

public interface IFXNewsPersister {
    /**
     * 存储新闻信息
     * @param fxNewsBean 需要存储的新闻对象
     */
    void persistNews(FXNewsBean fxNewsBean);
}
