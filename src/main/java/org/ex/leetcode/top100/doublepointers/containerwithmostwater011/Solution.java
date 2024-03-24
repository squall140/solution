package org.ex.leetcode.top100.doublepointers.containerwithmostwater011;

/**
 * @desc: Container with most water
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * 思路 双指针，不断球面积（底 x 高），求出最大值
 *
 * @author: Leif
 * @date: 2024/3/24 15:13
 */
public class Solution {
    public static int maxArea(int[] height) {
        int n = height.length;
        int left  = 0, right = n - 1;
        int max = 0;
        // 从两端向中间不断靠拢 right = n - 1
        while (left < right){
            // 求面积建议看图，实际上就是底 x 高
            int cur_area = Math.min(height[left],height[right]) * (right - left);
            // 不断求出最大面积
            max = Math.max(max, cur_area);
            // 看图，注意是从两端向中间靠拢
            if (height[right] > height[left] ){
                left++;
            }else {
                right--;
            }

        }

        return max;

    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
