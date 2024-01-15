package org.ex.leetcode.array.productofarrayexceptself238;

import java.util.Arrays;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/1/15 21:26
 */
public class Solution {
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int answer[] = new int[n];

        // L 和 R 分别代表左右两侧的前缀积数组
        int[] L = new int[n];
        int[] R = new int[n];

        // 先遍历左侧前缀积，由于第一个元素的左侧没有元素，则第一个元素的前缀积为1
        L[0] = 1;
        for (int i = 1; i < n; i++){
            // 累计i元素的左侧所有元素的乘积，所以这里是i-1，也就是累计到i元素的前一个元素
            L[i] = nums[i - 1] * L[i - 1];
        }

        // 反之亦然
        R[n - 1] = 1;
        // 这里的 n - 2 是因为最后一个元素的右乘积是累计到R[n-1]的位置，所以从 n-2的位置开始向左遍历
        for (int i = n - 2; i >= 0; i--){
            // 逐个向左侧累计乘积
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 最后，对于索引i , 除了nums[i]之外的其余所有元素的乘积=== 左前缀积 * 右前缀积
        for (int i = 0; i < n; i++){
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 7, 9};
        Arrays.stream(productExceptSelf(nums)).forEach(v -> System.out.print(v + ", "));

    }


}
