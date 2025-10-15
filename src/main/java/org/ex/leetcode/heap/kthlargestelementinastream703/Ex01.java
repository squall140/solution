package org.ex.leetcode.heap.kthlargestelementinastream703;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/17 14:20
 */
public class Ex01 {
    private Queue<Integer> pq;
    private int limit;

    public Ex01(int k, int[] nums){
        pq = new PriorityQueue<>(k);
        limit = k;
        for(int x : nums){
            add(x);
        }
    }

    private int add(int val){
        if (pq.size() < limit){
            pq.offer(val);
        }else if (pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
