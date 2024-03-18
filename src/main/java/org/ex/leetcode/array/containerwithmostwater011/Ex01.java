package org.ex.leetcode.array.containerwithmostwater011;

import java.util.Arrays;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/18 10:32
 */
public class Ex01 {
    public static int maxArea(int[] height) {
        // 双指针
        int i = 0 , j = height.length -1;
        int ans = 0;
        while (i < j){
            ans = Math.max(ans,Math.min(height[i],height[j]) * (j - i));
            if (height[i] < height[j]){
                i++;
            }else{
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
