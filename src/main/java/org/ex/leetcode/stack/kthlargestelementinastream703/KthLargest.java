package org.ex.leetcode.stack.kthlargestelementinastream703;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/2/29 11:42
 */
public class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        // 初始化小根堆
        for (int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        // 返回第k大的元素，即堆顶元素
        return pq.peek();

    }
}
