package org.ex.leetcode.twosum001;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 001-Two Sum
 * 两种解法，
 *  第二种查找表法
 *  在遍历过程中记录一些信息，以省去一层循环，利用空间换时间对思路实现
 *  时间复杂度是 O(n)， 空间复杂度是 O(n)
 *
 * @author: Leif
 * @date: 2023/8/4 22:16
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        // Attention the capacities of the hashMap.
        Map<Integer, Integer> hashMap = new HashMap<>(len -1 );
        // There is no elements before the first elements of array nums.
        hashMap.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            // to extract variable another for the "target - nums[i]".
            int another = target - nums[i];
            if (hashMap.containsKey(another)){
                return new int[]{i, hashMap.get(another)};
            }
            hashMap.put(nums[i], i);
        }

        // otherwise
        throw new IllegalArgumentException("I can't make it!");

    }
}
