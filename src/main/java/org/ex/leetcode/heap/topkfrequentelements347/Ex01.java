package org.ex.leetcode.heap.topkfrequentelements347;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 14:24
 */
public class Ex01 {
    public static int[] topKFrequent(int[] nums, int k) {
        // define a map to calculate all the elements appearance in nums
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // try to use a PQ for smallest heap to maintain the largest elements of nums
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> { return map.get(o1) - map.get(o2); });

        // iterate the map and put the key with elements count into the PQ
        for(Integer key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                // if current element count is greater than the element on the peek of PQ,
                // let the peek element out of the queue and enqueue the current key.
                pq.poll();
                pq.add(key);
            }
        }

        // prepare an integer array for the result output
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { 1,1,1,2,2,3 };
        int k = 2;
        int[] topK = topKFrequent(nums, k);
        System.out.println(Arrays.toString(topK));
    }
}
