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
 * 思路 优先队列，大顶堆
 * @author: Leif
 * @date: 2024/1/4 14:03
 */
public class Solution03 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            // PriorityQueue 默认是小顶堆
            // 这里使用的是lambda表达式，也是同样的实现了Comparator，定义大顶堆（最大堆）
            // PriorityQueue<E> queue = new PriorityQueue<>(initialCapacity, Comparator<? super E>);
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });

        // 这里由于nums1遍历了k次，nums2遍历了k次，那么这里空间复杂度就是O(k2) k的平方
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                // 条件1. 如果堆未满
                // 条件2. 如果当前两个数组堆元素堆和比当前堆顶堆元素还要小
                if (queue.size() != k ||
                        nums1[i] + nums2[j] < queue.peek().get(0) + queue.peek().get(1)) {
                    // 基于上述条件，如果堆已经达到了数量k个数量，那么删除堆顶元素
                    if (queue.size() == k) queue.poll();
                    // 把当前堆元素加入到pair中
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    // pair入堆（新堆顶）
                    queue.offer(pair);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res.add(i, queue.poll());
        }

        return res;

    }


}
