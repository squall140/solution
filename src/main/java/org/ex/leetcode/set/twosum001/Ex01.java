package org.ex.leetcode.set.twosum001;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 16:14
 */
public class Ex01 {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = null;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        for(int i = 0 ; i < n; i++){
            int another = target - nums[i];
            if (map.containsKey(another)) {
                res = new int[]{i, map.get(another)};
            }
            map.put(nums[i],i);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 18;
        int[] arr = twoSum(numbers, target);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
