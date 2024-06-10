package org.ex.leetcode.array.containerwithmostwater011;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/10 22:45
 */
public class Practice01 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int cur_area = (right - left ) * Math.min(height[left], height[right]);
            max = Math.max(max, cur_area);
            if(height[left] < height[right]){
                left++;
            }else{
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
