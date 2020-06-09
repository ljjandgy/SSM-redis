package com.example.springredis.ioc.before;

/**
 * 新闻提供类，通过从外部获取新闻信息，然后存入自己的数据库，类似于新闻同步
 */
public class FXNewsProvider {
    /** 新闻获取接口，通常由第三方提供 **/
    private IFXNewsListener newsListener;
    /** 新闻存储接口 **/
    private IFXNewsPersister newPersistener;
    //不使用ioc时，需要自己去获取依赖对象
    public FXNewsProvider(){
        //根据Dow Jones报社实现进行初始化（假如一开始就只有一家报社）
        newsListener = new DowJonesNewsListener();
        newPersistener = new DowJonesNewsPersister();
    }
    //使用ioc时，通过第三方注入依赖对象
    public FXNewsProvider(IFXNewsListener newsListener,
                          IFXNewsPersister newPersistener){
        this.newsListener = newsListener;
        this.newPersistener = newPersistener;
    }

    /*public void getAndPersistNews()
    {
        //获取可用新闻
        String[] newsIds = newsListener.getAvailableNewsIds();
        if(ArrayUtils.isEmpty(newsIds))
        {
            return;
        }
        //记录获取到的新闻
        for(String newsId : newsIds)
        {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newPersistener.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        } }*/
}
