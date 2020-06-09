package com.example.springredis.ioc.before;

public interface IFXNewsListener {
    /**
     * 获取有效id信息
     * @return id信息
     */
    String[] getAvailableNewsIds();

    /**
     * 根据id获取新闻信息
     * @param id id信息
     * @return 新闻对象
     */
    FXNewsBean getNewsByPK(String id);

    /**
     * 通知是否存储成功
     * @param newsId 新闻id
     */
    void postProcessIfNecessary(String newsId);
}
