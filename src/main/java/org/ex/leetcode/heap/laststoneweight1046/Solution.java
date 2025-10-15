package org.ex.leetcode.heap.laststoneweight1046;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc: Last stone weight
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y.
 *
 * The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 *
 *
 * Example 1:
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 *
 *
 * 大顶堆（最大堆）
 *
 * @author: Leif
 * @date: 2024/7/17 15:37
 */
public class Solution {
    public int lastStoneWeight(int[] stones){
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int x : stones){
            pq.offer(x);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                // 最大堆，a比b先出堆，那么一定是a > b
                pq.offer(a - b);
            }
        }

        if(pq.size() == 1) return pq.poll();
        return 0;
    }
}
