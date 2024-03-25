package org.ex.leetcode.top100.subarray.subarraysumequalsk560;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Subarray Sum Equals K
 *
 * 思路： 前缀和
 *
 *
 * 考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k 的 pre[j] 即可。
 * 我们建立哈希表 mp，以和为键，出现次数为对应的值，记录 pre[i] 出现的次数，
 * 从左往右边更新 mp 边计算答案，那么以 i 结尾的答案 mp[pre[i]−k] 即可在 O(1) 时间内得到。
 *
 * 时间复杂度：O(n) 我们遍历数组的时间复杂度为 O(n)，中间利用哈希表查询删除的复杂度均为 O(1)，
 * 因此总时间复杂度为 O(n)O(n)O(n)
 *
 * 空间复杂度：O(n) 其中 n 为数组的长度。哈希表在最坏情况下可能有 n 个不同的键值，
 * 因此需要 O(n) 的空间复杂度
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/3/25 11:12
 */
public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        // 对于下标为0的元素，前缀和为0，出现次数为1
        map.put(0, 1);

        int preSum = 0;
        int counter = 0;
        for (int x : nums){
            preSum += x;

            if (map.containsKey(preSum - k)){
                counter += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
