package com.example.springredis.ioc.before;

import java.util.Arrays;

public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public String[] getAvailableNewsIds() {
        return Arrays.asList("1","2","3").toArray(new String[3]);
    }

    @Override
    public FXNewsBean getNewsByPK(String id) {
        return null;
    }

    @Override
    public void postProcessIfNecessary(String newsId) {
        System.out.println("同步成功");
    }
}
