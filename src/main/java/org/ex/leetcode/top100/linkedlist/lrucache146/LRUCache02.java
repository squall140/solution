package org.ex.leetcode.top100.linkedlist.lrucache146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc: LRUCache
 *
 * HashMap 大家都清楚，底层是 数组 + 红黑树 + 链表 （不清楚也没有关系），同时其是无序的，
 * 而 LinkedHashMap 刚好就比 HashMap 多这一个功能，就是其提供 有序，
 * 并且，LinkedHashMap的有序可以按两种顺序排列，一种是按照插入的顺序，一种是按照 读取 的顺序
 * （这个题目的示例就是告诉我们要按照读取的顺序进行排序），
 * 其内部是靠 建立一个双向链表 来维护这个顺序的，在每次插入、删除后，都会调用一个函数来进行 双向链表的维护 ，
 * 准确的来说，是有三个函数来做这件事，这三个函数都统称为 回调函数 ，这三个函数分别是：
 *
 * void afterNodeAccess(Node<K,V> p) { }
 * 其作用就是在访问元素之后，将该元素放到双向链表的尾巴处(所以这个函数只有在按照读取的顺序的时候才会执行)，
 * 之所以提这个，是建议大家去看看，如何优美的实现在双向链表中将指定元素放入链尾！
 * void afterNodeRemoval(Node<K,V> p) { }
 * 其作用就是在删除元素之后，将元素从双向链表中删除，还是非常建议大家去看看这个函数的，
 * 很优美的方式在双向链表中删除节点！
 *
 *
 * void afterNodeInsertion(boolean evict) { }
 * 这个才是我们题目中会用到的，在插入新元素之后，需要回调函数判断是否需要移除一直不用的某些元素！
 *
 *
 * LinkedHashMap 的构造函数！
 * 其主要是两个构造方法，一个是继承 HashMap ，一个是可以选择 accessOrder 的值
 * (默认 false，代表按照插入顺序排序)来确定是按插入顺序还是读取顺序排序。
 *
 * 作者：jeromememory
 * 链接：https://leetcode.cn/problems/lru-cache/solutions/81045/yuan-yu-linkedhashmapyuan-ma-by-jeromememory/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/4/3 14:19
 */
public class LRUCache02 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    /**
     * 注意这里的构造器
     * @param capacity
     */
    public LRUCache02(int capacity){
        // loadFactor 代表加载因子
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, - 1);
    }
    public void put(int key, int value){
        super.put(key, value);
    }

    /**
     * 是否移除队尾元素（最长时间不使用）
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
