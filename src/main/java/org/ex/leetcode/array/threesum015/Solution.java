package org.ex.leetcode.array.threesum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: Three Sum
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * <p>
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * 思路 双指针法
 *
 * https://leetcode.cn/problems/3sum/solutions/39722/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/comments/1284967
 *
 *
 *
 *
 * @author: Leif
 * @date: 2024/1/29 10:46
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 创建结果集
        ArrayList<List<Integer>> res = new ArrayList<>();
        // 判断初始条件
        int len = nums.length;
        if (len < 3) return res;

        // 先左数组排序
        Arrays.sort(nums);

        // 双指针遍历
        for (int i = 0; i < len; i++) {
            // 排除条件，在遍历时发现数组当前元素大于0，那么就直接结束循环，因为排序后（从小到大）后面的元素都大于0了
            if (nums[i] > 0) {
                break;
            }

            // 排除条件，去重，当起始元素等于前一个元素，那么得到的三数之和是和上一轮遍历一样的，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //开始双指针
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                // 计算当前的三数之和
                int sum = nums[i] + nums[l] + nums[r];
                // 符合答案的嗨
                if (sum == 0) {
                    // 加入到结果集
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 排除条件，去重，当 i 不变时，如果此时的 l 值和前一个数值相同，则 l 右移
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // 反之亦然
                    while (l < r && nums[r] == nums[r - 1]) r++;
                    // 移动指针
                    l++;
                    r--;
                } else if (sum < 0) {
                    // 小于0的时候左指针右移
                    l++;
                } else if (sum > 0) {
                    // 右指针左移
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums ={-1,0,1,2,-1,-4};
//        int[] nums = {0,1,1};
        int[] nums = {0, 0, 0};
        System.out.println(threeSum(nums));
    }


}
