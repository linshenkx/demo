package com.linshenkx.quick.demo.util;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @version V1.0
 * @author: lin_shen
 * @date: 2017/12/2
 * @Description: TODO
 */

public class LocalCacheUtil {
    private static CacheManager cacheManager=CacheManager.create();
    private static final String DEFAULT_CACHE_NAME="defaultCache";
    private static final Integer DEFAULT_CACHE_LIVE_TIME=60*60;

    /**
     * 缓存基方法
     * @param cacheName 缓存名
     * @param key 键
     * @param value 值
     * @param time 过期时间
     * @return
     */
    public static boolean hset( String cacheName,String key,Object value,Integer time){
        try {
            Cache cache=cacheManager.getCache(cacheName);
            if(cache==null){
                cacheManager.addCache(cacheName);
                cache=cacheManager.getCache(cacheName);
            }
            Element element=new Element(key,value);
            if(time!=null){
                element.setTimeToLive(time);
            }else {
                element.setTimeToLive(DEFAULT_CACHE_LIVE_TIME);
            }
            cache.put(element);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean hset(String cacheName,String key,Object value){
        return hset(cacheName,key,value,null);
    }
    public static boolean set(String key,Object value,Integer time){
        return hset(DEFAULT_CACHE_NAME,key,value,time);
    }
    public static boolean set(String key,Object value){
        return hset(DEFAULT_CACHE_NAME,key,value,null);
    }


    /**
     * 获取缓存基方法
     * @param cacheName 缓存名
     * @param key 键
     * @return
     */
    public static Object hget(String cacheName,String key){
        try{
            Cache cache=cacheManager.getCache(cacheName);
            if(cache==null){
                return null;
            }
            Element element= cache.get(key);
            if(element==null){
                return null;
            }
            return element.getObjectValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Object get(String key){
        return hget(DEFAULT_CACHE_NAME,key);
    }

    /**
     * 删除缓存基方法
     * @param cacheName 缓存名
     * @param key 键
     * @return 删除成功或者本来没有该key都返回true
     */
    public static boolean delete(String cacheName,String key){
        try{
            Cache cache=cacheManager.getCache(cacheName);
            if(cache==null){
                return true;
            }
            cache.remove(key);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean delete(String key){
        return delete(DEFAULT_CACHE_NAME,key);
    }



}
