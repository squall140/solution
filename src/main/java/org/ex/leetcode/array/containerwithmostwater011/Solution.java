package org.ex.leetcode.array.containerwithmostwater011;

/**
 * @desc: Container With Most Water
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" />
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation:
 *      The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 *      In this case, the max area of water (blue section) the container can contain is 49
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * 双指针法
 *
 * @author: Leif
 * @date: 2024/1/29 15:14
 */
public class Solution {
    public static int maxArea(int[] height) {
        // 求面积 = 底 * 高
        // 盛水的话，得用绝对值, (j - i) * Math.min(height[i], height[j])
        int ans = 0;
        int i = 0, j = height.length - 1;

        while ( i < j){
            // 连续计算求最大面积放入ans
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            // 双指针，两端向中心靠拢
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
