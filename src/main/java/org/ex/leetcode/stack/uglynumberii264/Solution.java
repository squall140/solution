package org.ex.leetcode.stack.uglynumberii264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @desc: Ugly Number II
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 *
 * <br />
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 *
 *
 * 思路 最小堆（优先队列）
 * 看动画演示
 * https://leetcode.cn/problems/ugly-number-ii/solutions/712102/chou-shu-ii-by-leetcode-solution-uoqd/
 *
 * 初始时堆为空。首先将最小的丑数 111 加入堆。
 * 每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x,3x,5x 也是丑数，
 * 因此将 2x,3x,5x 加入堆。
 * 比如，1  -> 2, 3, 5
 *      2  -> 4, 6, 10
 *      3  -> 6, 9, 15
 *      4  -> 8, 12, 20
 *
 * 上述做法会导致堆中出现重复元素的情况。为了避免重复元素，可以使用哈希集合去重，避免相同元素多次加入堆。
 *
 * @author: Leif
 * @date: 2024/1/3 22:32
 */
public class Solution {
    public int nthUglyNumber(int n){
        // 质因子
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        // 初始化
        seen.add(1L);
        heap.add(1L);
        int ans = 0;
        for (int i = 0; i < n ; i++){
            // 取出堆顶值
            long curr = heap.poll();
            // 直接返回给结果ugly
            ans = (int) curr;
            for (int factor : factors){
                // 通过乘以质因子逐一得出相应的丑数
                long next = curr * factor;
                if (seen.add(next)){
                    // 这里通过seen哈希集合来去重，如果能添加的，一定不是重复的，同时入堆
                    heap.offer(next);
                }
            }
        }
        return ans;
    }
}
