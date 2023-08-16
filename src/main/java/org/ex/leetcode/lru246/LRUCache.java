package org.ex.leetcode.lru246;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc:
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 解法，使用JDK自带的LinkedHashMap,
 * HashMap利用哈希表进行数据存取，其底层实现结构为数组+链表或者数组+红黑树，LinkedHashMap在使用HashMap进行数据存储的过程中，又维护了一个双向链表来维持顺序，通过accessOrder支持链表的双向遍历。
 * 相比HashMap的访问操作，put、get方法，LinkedHashMap在进行元素访问后都会调用回调函数afterNodeAccess进行元素排序操作，在put元素后还会额外调用afterNodeInsertion回调方法进行后续操作，并且根据removeEldestEntry方法的返回结果判定是否进行旧元素移除，默认不进行删除。
 *
 *
 * @author: Leif
 * @date: 2023/8/11 21:35
 */
class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    public LRUCache(int capacity) {
        // 当accessOrder=true,get了的数据被放到了双向链表尾部，也就是按照了访问时间进行排序,这就是访问顺序的含义.
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当HashMap的size大于预设的最大容纳元素数量capacity时移除旧的元素
        return this.size() > this.capacity;
    }

    @Override
    public V get(Object key) {
        return super.getOrDefault(key, null);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    /**
     * 插入的时候调用了afterNodeAccess()方法以及afterNodeInsertion()方法,
     * 当accessOrder=true,get了的数据被放到了双向链表尾部，也就是按照了访问时间进行排序,这就是访问顺序的含义。
     * @param args
     */
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("k1",1);
        cache.put("k2",2);
        cache.put("k3",3);
        print(cache);  // 1, 2, 3
        System.out.println("====================");

        cache.get("k3"); // 1, 2, 3
        cache.get("k2"); // 1, 3, 2
        cache.get("k1"); // 3, 2, 1
        print(cache);
        System.out.println("====================");

        cache.put("k4",4);  // 3, 2, 1, 4
        // Cache中最大容纳元素数量为设定数量3，超过3的元素会被丢弃.
        print(cache);   // 2, 1, 4
    }

    public static void print(LRUCache<String, Integer> cache) {
        cache.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}