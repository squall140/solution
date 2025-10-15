package org.ex.leetcode.top100.heap.designtwitterfeed355;

/**
 * @desc: 推文类，就是一个单链表（结点视角）
 * @author: Leif
 * @date: 2024/7/17 16:33
 */
public class Tweet {
    public int id;
    public int timestamp;
    public Tweet next;

    public Tweet(int id, int timestamp){
        this.id = id;
        this.timestamp = timestamp;
    }

}
