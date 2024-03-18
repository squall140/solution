package org.ex.leetcode.array.threesum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/18 10:41
 */
public class Ex01 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) return res;
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 如果开局nums[i] 就大于0，那么后面的2个元素相加以后也会大于0
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 双指针
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重
                    while (l < r && nums[i] == nums[i + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums).forEach(System.out::print);
    }
}
