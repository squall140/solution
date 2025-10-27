package org.ex.leetcode.top100.hash.twosum001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: Leif
 * @date: 2025/10/27 13:46
 */
public class Practice01 {
  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    int[] res = null;
    Map<Integer, Integer> dic = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int another = target - nums[i];
      if (dic.containsKey(another)) {
        res = new int[]{i, dic.get(another)};
      }
      dic.put(nums[i], i);
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }
}
