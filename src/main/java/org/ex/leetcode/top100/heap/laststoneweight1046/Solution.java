package org.ex.leetcode.top100.heap.laststoneweight1046;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/8 16:28
 */
public class Solution {
    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int x : stones){
            pq.offer(x);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                pq.offer( a - b);
            }
        }

        if(pq.size() == 1) return pq.poll();
        return 0;

    }

    public static void main(String[] args) {
        int[] stones = { 2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
