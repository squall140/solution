package org.ex.leetcode.top100.heap.topkfrequentelements347;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/10 16:33
 */
public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        // 先做一个字典，记录所有字频
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // 用优先级队列，小顶堆维护k个元素（默认小顶堆）
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.offer(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                // 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
                // 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
                pq.poll();
                pq.offer(key);
            }
        }

        int[] res = new int[k];
        int index = 0;
        // 当前小顶堆中正好维护着k个元素，那么前k个高频元素直接做遍历小顶堆就行了
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Arrays.stream(topKFrequent(nums, k)).forEach(System.out::print);
    }
}
