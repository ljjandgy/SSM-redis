package com.example.springredis.ioc.beanfactory;

import com.example.springredis.ioc.before.DowJonesNewsListener;
import com.example.springredis.ioc.before.DowJonesNewsPersister;
import com.example.springredis.ioc.before.FXNewsBean;
import com.example.springredis.ioc.before.IFXNewsListener;
import com.example.springredis.ioc.before.IFXNewsPersister;

import java.util.Collections;

/**
 * 新闻提供类，通过从外部获取新闻信息，然后存入自己的数据库，类似于新闻同步
 */
public class FXNewsProvider {
    /** 新闻获取接口，通常由第三方提供 **/
    private IFXNewsListener newsListener;
    /** 新闻存储接口 **/
    private IFXNewsPersister newPersistener;

    //使用ioc时，通过第三方注入依赖对象
    public FXNewsProvider(IFXNewsListener newsListener,
                          IFXNewsPersister newPersistener){
        this.newsListener = newsListener;
        this.newPersistener = newPersistener;
    }

    public void getAndPersistNews()
    {
        System.out.println("开始进行新闻同步");
        //获取可用新闻
        String[] newsIds = newsListener.getAvailableNewsIds();
        if(newsIds.length==0)
        {
            return;
        }
        //记录获取到的新闻
        for(String newsId : newsIds)
        {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        } }
}
