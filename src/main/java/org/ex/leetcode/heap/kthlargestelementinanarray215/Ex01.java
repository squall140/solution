package org.ex.leetcode.heap.kthlargestelementinanarray215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/17 15:01
 */
public class Ex01 {
    public int findKthLargest(int[] nums, int k){
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }

        for (int i = k; i < n; i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();

    }
}
