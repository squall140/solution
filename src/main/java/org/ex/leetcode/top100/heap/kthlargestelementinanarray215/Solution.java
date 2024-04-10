package org.ex.leetcode.top100.heap.kthlargestelementinanarray215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc: Kth Largest Element in an Array
 * @author: Leif
 * @date: 2024/4/10 16:14
 */
public class Solution {
    public static int findKthLargest(int[] nums, int k){
        Queue<Integer> minHeap = new PriorityQueue<>();
        // 前k个元素依次先入堆
        for(int i = 0; i < k; i++){
            minHeap.offer(nums[i]);
        }

        // 从第k+1个元素开始，遍历对比数组中当前元素和堆顶元素大小
        // 如果当前元素大于堆顶元素，那么堆顶元素出堆，直到遍历结束，维护堆顶元素是最大值
        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                // 堆顶元素出堆
                minHeap.poll();
                // 当前元素入堆
                minHeap.offer(nums[i]);
            }
        }

        // 遍历结束后，小顶堆一直维护着k个元素，那么堆顶就是第k个最大值
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int target = 3;
        System.out.println(findKthLargest(nums, target));
    }
}
