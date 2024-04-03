package org.ex.leetcode.top100.linkedlist.lrucache146;

import java.util.HashMap;

/**
 * @desc: LRU Cache
 *
 * 思路， 双向链表 + 哈希表
 *
 * 双向链表为了解决顺序问题（后进先出）
 * 哈希表解决查找get时的O(1)问题
 *
 * 参考题解
 * https://leetcode.cn/problems/lru-cache/solutions/2685219/lru-jian-dan-cu-bao-jie-fa-by-liquor-nx-fqei/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/4/3 10:38
 */
public class LRUCache01 {

    /**
     * 双向链表定义
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){}
        DLinkedNode(int key, int value) {this.key = key; this.value = value;}
    }

    // 哈希表存储键值对
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    // 当前大小
    private int size;
    // 缓存容量
    private int capacity;
    // 双向链表的头部和尾部
    private DLinkedNode head, tail;

    public LRUCache01(int capacity){
        this.size = 0;
        this.capacity = capacity;

        // 创建头、尾哨兵节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 双向链表头部插入新节点
     * @param node
     */
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除节点
     * @param node
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /**
     * 将节点移动到链表头部
     * @param node
     */
    private void moveToHead(DLinkedNode node){
        // 先删除
        removeNode(node);
        // 再添加到头部
        addNode(node);
    }

    /**
     * 弹出链表尾部节点（表最久未使用）
     * @return
     */
    private DLinkedNode popTail(){
        // 这里tail实际上也是一个尾部哨兵
        DLinkedNode node = tail.prev;
        // 队列中删除此node
        removeNode(node);
        return node;
    }

    // 获取节点
    private int get(int key){
        DLinkedNode node = cache.get(key);
        // 未找到，返回-1
        if (node == null) return -1;
        // 把最近使用的移动到头部
        moveToHead(node);
        return node.value;
    }

    // 添加节点
    private void put(int key, int value){
        DLinkedNode node = cache.get(key);
        // 如果节点不存在，创建新节点并添加到哈希表和双向链表
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加新节点到链表
            addNode(newNode);
            // 添加到哈希表
            cache.put(key, newNode);

            ++size;

            //如果超出了容量，自动删除尾部节点（最久未使用）
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            // 如果节点存在，直接更新节点值，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }


}
