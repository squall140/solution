package org.ex.leetcode.top100.heap.kthlargestelementinanarray215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/8 14:42
 */
public class Ex01 {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for(int i = k; i < n; i++){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int target = 3;
        System.out.println(findKthLargest(nums, target));
    }
}
