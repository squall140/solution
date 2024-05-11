package org.ex.leetcode.top100.linkedlist.lrucache146;

import java.util.HashMap;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/10 09:49
 */
public class LRUCache03 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode(){}
        DLinkedNode(int key, int value){ this.key = key; this.value = value;}
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache03(int capacity){
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    /**
     * 无论链表是否为空，插入和删除操作都可以以统一的方式处理。
     * 因为哨兵节点保证了链表始终有一个非空的头部和尾部节点，
     * 从而避免了在执行插入或删除操作时需要检查链表是否为空的额外步骤。
     *
     * @param node
     */
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

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
        // 再添加
        addNode(node);
    }

    /**
     * 弹出链表尾部节点（表最久未使用）
     * @return
     */
    private DLinkedNode popTail(){
        // 这里tail实际上也是一个尾部哨兵（虚节点）
        DLinkedNode node = tail.prev;
        // 删除后再返回
        removeNode(node);
        return node;
    }

    private int get(int key){
        DLinkedNode node = cache.get(key);
        // 未找到，返回-1
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void put(int key, int value){
        // 先看下缓存中有没有这个key
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果没有，则添加新的
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加到队列头部
            addNode(newNode);
            // 添加到哈希表
            cache.put(key, newNode);
            // 计数器
            size++;
            // 如果超出队列了，那么移除尾部元素（最少使用）
            if (size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            // 如果节点存在，则更新信息并移动到队列头部
            node.value = value;
            moveToHead(node);
        }
    }


}
