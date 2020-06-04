package com.datastructure.learning.basicTest.实现一个本地缓存cache;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lipan
 * @date: 2020/6/4
 * @description: ConcurrentHashMap实现一个本地缓存
 *     <p>https://www.cnblogs.com/parryyang/p/5779984.html
 *     <p>为什么要是用内部缓存?
 *     在系统中，有些数据量不大、不常变化，但是访问十分频繁，例如省、市、区数据。针对这种场景，可以将数据加载到应用的内存中，以提升系统的访问效率，减少无谓的数据库和网路的访问。
 *     内部缓存的限制就是存放的数据总量不能超出内存容量，毕竟还是在 JVM 里的。
 *
 *     本地缓存的优点：
 *     直接使用内存，速度快，通常存取的性能可以达到每秒千万级
 *     可以直接使用 Java 对象存取
 *
 *     本地缓存的缺点：
 *     数据保存在当前实例中，无法共享
 *     重启应用会丢失
 */
public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<String, String> cacheMap = new ConcurrentHashMap<>();

    /**
     * 获取缓存的对象
     *
     * @param account
     * @return
     */
    public static String getCache(String account) {

        account = getCacheKey(account);
        // 如果缓冲中有该账号，则返回value
        if (cacheMap.containsKey(account)) {
            return cacheMap.get(account);
        }
        // 如果缓存中没有该账号，把该帐号对象缓存到concurrentHashMap中
        initCache(account);
        return cacheMap.get(account);
    }

    /**
     * 初始化缓存
     * @param account
     */
    private static void initCache(String account) {
        // 一般是进行数据库查询，将查询的结果进行缓存
        cacheMap.put(account, "17671226463");
    }

    /**
     * 拼接一个缓存key
     *
     * @param account
     * @return
     */
    private static String getCacheKey(String account) {
        return Thread.currentThread().getId() + "-" + account;
    }

    /**
     * 移除缓存信息
     *
     * @param account
     */
    public static void removeCache(String account) {
        cacheMap.remove(getCacheKey(account));
    }

  public static void main(String[] args) {
    //

    // 1、获取缓存对象
    System.out.println(getCache("lipan"));


  }
}