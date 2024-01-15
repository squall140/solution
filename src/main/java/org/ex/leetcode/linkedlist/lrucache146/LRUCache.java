package org.ex.leetcode.linkedlist.lrucache146;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: LRU Cache
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used(LRU) cache.
 * Implement the LRUCache class:
 * <p>
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if the key exists. Otherwise,
 * add the key-value pair to the cache. If the number of keys exceeds the capacity
 * from this operation, evict the least recently used key.
 * <p>
 * The functions get() and put() must each run in O(1) average time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
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
 * <p>
 * 思路 哈希表 + 双向链表
 * <p>
 * 查询get O(1)，第一时间会想到HashMap
 * 插入put O(1)，应该会想到链表，因为Array插入时候需要移位，时间复杂度是O(n)，
 * 只有LinkedList数据结构比较符合
 * @author: Leif
 * @date: 2024/1/15 16:05
 */
public class LRUCache {
    // 定义哨兵节点（头节点、尾节点）
    ListNode head, tail;
    // 缓存容量
    int capacity;
    // 当前缓存存入的数据个数
    int size;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        initLinkedList();
        size = 0;
        // TODO:
        cache = new HashMap<>(capacity + 2);
    }


    // 双向链表初始化
    public void initLinkedList() {
        // 创建头/尾节点（哨兵）
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.pre = head;

    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        // 如果存在，那么更新缓存中节点值
        if (node != null) {
            // 使用新值覆盖缓存中的旧值
            node.value = value;
            moveToHead(node);
            return;
        }

        // 如果不存在，那么新增节点
        // 此时如果缓存已满，则删除尾节点tail
        if (size == capacity) {
            ListNode lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }

        // 如果未满，直接新增
        ListNode newNode = new ListNode(key, value);
        addNode(newNode);
        cache.put(key, newNode);
        size++;

    }

    /**
     * 如果找到旧返回，找不到旧返回-1
     *
     * @param key
     * @return entry.value | -1
     */
    public Integer get(int key) {
        ListNode entry = cache.get(key);
        if (entry != null) {
            moveToHead(entry);
            return entry.value;
        } else {
            return -1;
        }
    }


    private void moveToHead(ListNode node) {
        deleteNode(node);
        addNode(node);

    }

    // 把node放到head头节点后面，作为第一个节点
    private void addNode(ListNode node) {
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
