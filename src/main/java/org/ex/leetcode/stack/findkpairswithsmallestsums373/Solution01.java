package org.ex.leetcode.stack.findkpairswithsmallestsums373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 思路 方法一：暴力解法 数组
 * 思路：
 * 设数组nums1的长度为n1,数组num2的长度为n2。我们可以暴力枚举全部的n1*n2对数字，
 * 然后对他们的和按照由小到大的顺序进行排序，然后选取前K对数来解决该问题。
 * <p>
 * 算法：
 * 暴力枚举全部n1*n2对数字，排序后取其前K对。
 * 时间复杂度O(n1 * n2)，空间复杂度O(n1 * n2)
 * <p>
 * 作者：KLEA123
 * 链接：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/21750/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-lenn123/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: Leif
 * @date: 2024/1/4 08:57
 */
public class Solution01 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0) return res;

        int[][] arr = new int[n1 * n2][2];
        int idx = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[idx][0] = nums1[i];
                arr[idx][1] = nums2[j];
                idx++;
            }
        }

        Arrays.sort(arr, (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[i][0]);
            temp.add(arr[i][1]);
            res.add(temp);
        }

        return res;
    }


}
