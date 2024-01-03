package org.ex.leetcode.stack.largestrectangleinhisogram84;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Largest Rectangle In Histogram
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * 思路 单调栈
 *
 *
 * @author: Leif
 * @date: 2024/1/3 15:34
 */
public class Solution {
    public int largestRectangleArea(int[] heights){
        int ans = 0;
        // 哨兵，为了保证栈能被清空，定义新数组尾部追加 -1,具体看B站收藏视频
        int[] newHeights = Arrays.copyOf(heights,heights.length + 1);
        newHeights[newHeights.length - 1 ] = -1;
        int n = newHeights.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++){
            // 当栈不为空且当前高度小于栈顶高度的时
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){
                // 弹出栈顶元素（作为中间元素，当前元素heights[i]为右边界高度）
                int index = stack.pop();
                // 定义左边界为新的栈顶元素，如果此时栈空，则为-1
                int left = stack.isEmpty() ? -1 : stack.peek();
                // 因为此时确定了左右边界（其中右边界就是当前元素的下标），直接计算
                ans = Math.max(ans, (i - left - 1) * newHeights[index]);
            }
            stack.push(i);
        }
        return ans;
    }
}
