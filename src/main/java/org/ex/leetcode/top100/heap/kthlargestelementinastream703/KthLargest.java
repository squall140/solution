package org.ex.leetcode.top100.heap.kthlargestelementinastream703;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/8 15:34
 */
public class KthLargest {
    private Queue<Integer> pq;
    private int limit;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        limit = k;
        for( int x : nums){
            add(x);
        }
    }

    public int add(int val) {
        if (pq.size() < limit) {
            pq.add(val);
        }else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
