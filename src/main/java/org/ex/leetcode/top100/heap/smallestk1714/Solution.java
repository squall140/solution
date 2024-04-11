package org.ex.leetcode.top100.heap.smallestk1714;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc: Smallest K
 * @author: Leif
 * @date: 2024/4/11 15:23
 */
public class Solution {
    public static int[] smallestK(int[] arr, int k) {
        // 1st. EnQueue all elements in a priority queue
        // 2nd. Poll k elements from the queue and return the result
        if(arr == null || arr.length == 0 || k <= 0) return arr;

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(int x : arr){
            queue.offer(x);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        System.out.println("The k smallest numbers are: ");
        // 循环打印数组
        Arrays.stream(smallestK(arr, k)).forEach(System.out::println);


    }
}
