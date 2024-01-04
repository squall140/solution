package org.ex.leetcode.set.containsduplicate217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
 * 思路二 哈希表
 *
 * 对于数组中每个元素，我们将它插入到哈希表中。
 * 如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/contains-duplicate/solutions/518991/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/4 15:47
 */
public class Solution02 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if (!set.add(i)) return true;
        }
        return false;

    }
}
