package com.example.springredis.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleRateLimiter {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 判断本次请求是否有效
     * @param userId 用户id
     * @param actionKey 行为的key（比如回帖是一个key，点赞是一个key）
     * @param period 窗口时间
     * @param maxCount 窗口时间内行为的最大值
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        List<Object> list = redisTemplate.executePipelined(new SessionCallback() {
            //必须返回null，在管道中使用sessioncallback的时候
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundZSetOps(key).add(""+nowTs,nowTs);//用管道添加zset的内容
                redisOperations.boundZSetOps(key).removeRangeByScore(0, nowTs - period * 1000);//获取窗口时间请求内容
                redisTemplate.opsForZSet().zCard(key);//获取窗口时间内请求的数量
                return null;
            }
        });
        Long count = Long.valueOf(list.get(2).toString());
        return count<=maxCount;
    }
}
