package org.ex.leetcode.linkedlist.designcircularqueue622;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/1/4 15:02
 */
public class Solution {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        boolean param_1 = queue.enQueue(5);
        boolean param_2 = queue.deQueue();
        int param_3 = queue.Front();
        int param_4 = queue.Rear();
        boolean param_5 = queue.isEmpty();
        boolean param_6 = queue.isFull();
    }

}
