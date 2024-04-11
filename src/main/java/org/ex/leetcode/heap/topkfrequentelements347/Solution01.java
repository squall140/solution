package org.ex.leetcode.heap.topkfrequentelements347;

import java.util.*;

/**
 * @desc: Top K Frequent Elements
 *
 * Given n integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * 思路  小顶堆（最小堆）
 *
 * @author: Leif
 * @date: 2024/2/28 23:44
 */
public class Solution01 {
    public static int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计数字出现的次数，key是字符，value是次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 遍历map，使用最小堆来保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        // 维护一个元素数目为 k 的最小堆
        for (Integer key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else if(map.get(key) > map.get(pq.peek())){
                // 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
                // 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
                pq.poll();
                pq.add(key);
            }
        }
        //将小顶堆中的k个数字放到数组中
        int [] res = new int[k];
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
