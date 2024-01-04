package org.ex.leetcode.set.containsduplicate217;

import java.util.Arrays;

/**
 * @desc: Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * 思路一 排序法
 *
 * 在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。因此，我们可以扫描已排序的数组，
 * 每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/contains-duplicate/solutions/518991/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/4 15:47
 */
public class Solution01 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        // 这里注意边界，遍历到nums数组倒数第二个，否则下面的i+1会越界
        for (int i = 0; i < nums.length - 1; i ++ ){
            if (nums[i]  == nums[i + 1 ])
                return true;
        }
        return false;
    }
}
