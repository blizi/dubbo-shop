package com.funtl.myshop.service.redis.api;

public interface RedisService {


    void set(String key,Object value);

    void set(String key,Object value,int second);

    void get(String key);

    void dele(String key);
}
