package org.ex.leetcode.array.subarraysumequalsk560;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Subarray Sum Equals K
 * <p>
 * Given an array and integers nums and an integer k,
 * return the local number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * <p>
 * 思路，前缀和 优化版  配合哈希表
 *
 * 由于只关心次数，不关心具体的解，我们可以使用[哈希表]加速运算；
 * 由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了 O(N)。
 *
 * 时间复杂度：O(N)，这里 N 是数组的长度；
 * 空间复杂度：O(N)。
 *
 *
 * 解释一开始 preSumFreq.put(0, 1); 的意义
 * 想一想算法的意思：计算完包括了当前数前缀和以后，我们去查一查在当前数之前，有多少个前缀和等于 preSum - k 呢？
 * 这是因为满足 preSum - (preSum - k) == k 的区间的个数是我们所关心的。
 * 对于一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个，
 * 因此 preSumFreq.put(0, 1);，这一点是必要且合理的。
 *
 * 作者：liweiwei1419
 * 链接：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/247577/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 看官方题解的小动画
 * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/
 *
 * @author: Leif
 * @date: 2024/1/9 13:32
 */
public class Solution02 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // key: 前缀和， value: key对应的前缀和的个数
        Map<Integer,Integer> preSumFrequency = new HashMap<>();
        // 对于下标为0的元素，前缀和为0，个数为1
        preSumFrequency.put(0, 1);

        int preSum = 0;
        int ans = 0;
        for (int x : nums){
            preSum += x;
            // 先获得前缀为 preSum - k 的个数，累加到计数器变量ans中
            if (preSumFrequency.containsKey(preSum - k)){
                ans += preSumFrequency.get(preSum - k);
            }
            // 然后维护 preSumFrequency 的定义, 即遍历数组，把每个元素的前缀和preSum放入map
            // 如果当前前缀和之前重复出现过，那么次数+1
            preSumFrequency.put(preSum, preSumFrequency.getOrDefault(preSum, 0) + 1);
        }

        return ans;

    }

}
