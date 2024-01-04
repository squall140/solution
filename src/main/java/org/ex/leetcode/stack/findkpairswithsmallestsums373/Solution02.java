package org.ex.leetcode.stack.findkpairswithsmallestsums373;

import java.util.*;

/**
 * @desc: Find K pairs with Smallest sums
 * <p>
 * You are given two integers arrays nums1 and nums2 sorted in non-decreasing order
 * and an integer k.
 * Define a pair(u, v) which consists of one element from the first array and one element
 * from the second array.
 * Return the k pairs(u1, v1), (u2, v2), ... (uk,vk) with the smallest sums.
 * <p>
 * <br />
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * 思路 暴力解法 数组(清晰版)
 *
 * @author: Leif
 * @date: 2024/1/4 10:01
 */
public class Solution02 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<List<Integer>>();

        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Pair[] pairs = new Pair[nums1.length * nums2.length];

        int len = 0;
        // 把两个nums数组中的所有值全部塞进新的枚举类型Pairs数组中
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pairs[len++] = new Pair(nums1[i], nums2[j]);
            }
        }

        // 使用自定义的排序类，按照升序排列
        Arrays.sort(pairs, new mySort());

        // 遍历新数组取最小第k对儿
        for (int i = 0; i < Math.min(k, pairs.length); i++){
            tmp.add(pairs[i].x);
            tmp.add(pairs[i].y);
            ans.add(tmp);
            tmp.clear();
        }

        return ans;

    }

    private class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class mySort implements Comparator<Pair> {
        // 重写排序方法
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.x + o2.y - o2.x - o2.y;
        }
    }


}
