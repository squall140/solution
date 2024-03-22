package org.ex.leetcode.heap.findkpairswithsmallestsums373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @desc: Find K pairs with Smallest sums
 * <p>
 * You are given two integers arrays nums1 and nums2 sorted in non-decreasing order
 * and an integer k.
 * Define a pair(u, v) which consists of one element from the first array and one element
 * from the second array.
 * Return the k pairs(u1, v1), (u2, v2), ... (uk,vk) with the smallest sums.
 * <p>
 * 思路 优先队列，最小堆（最优解）
 * @author: Leif
 * @date: 2024/1/4 14:03
 */
public class Solution04 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 定义最小堆，comparator 是直接比较两个数组的元素和
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]])
        );
        List<List<Integer>> res = new ArrayList<>();
        // 边界条件
        if (nums1.length == 0 || nums2.length == 0) return res;

        // 以nums1的长度为基准，初始化一个数量为k的最小堆
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            // 注意这里加入堆的是下标，这样有利于得到堆顶元素的下一个元素
            queue.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !queue.isEmpty()) {
            // 弹出堆顶元素（数组），这里数组中存储的是下标
            int[] pair = queue.poll();
            List<Integer> item  = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);

            // 如果nums2还有与nums1的下一个组合，那么也要入堆
            if(pair[1] < nums2.length -1){
                // 加入堆顶元素的下一个元素
                queue.offer(new int[]{pair[0],pair[1] + 1});
            }
            res.add(item);
        }

        return res;

    }


}
