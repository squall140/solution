package org.ex.leetcode.linkedlist.lrucache146;

/**
 * @desc: LRU Cache
 *
 * Design a data structure that follows the constraints of a Least Recently Used(LRU) cache.
 * Implement the LRUCache class:
 *
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists. Otherwise,
 *   add the key-value pair to the cache. If the number of keys exceeds the capacity
 *   from this operation, evict the least recently used key.
 *
 * The functions get() and put() must each run in O(1) average time complexity.
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * 思路 哈希表 + 双向链表
 *
 * 查询get O(1)，第一时间会想到HashMap
 * 插入put O(1)，应该会想到链表，因为Array插入时候需要移位，时间复杂度是O(n)，
 *              只有LinkedList数据结构比较符合
 *
 *
 * @author: Leif
 * @date: 2024/1/15 16:05
 */
public class ListNode {
    public ListNode pre;
    public ListNode next;
    public int key;
    public int value;

    public ListNode(){};
    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }


}
