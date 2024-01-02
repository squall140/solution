package org.ex.leetcode.stack.trappingtrainwater42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Trapping rain water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * 思路 单调栈
 * https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
 *
 * 复杂度分析
 * 时间复杂度：O(n), n 是数组 height 的长度。从 0 到 n−1 的每个下标最多只会入栈和出栈各一次。
 * 空间复杂度：O(n), n 是数组 height 的长度。空间复杂度主要取决于栈空间，栈的大小不会超过 n。
 *
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * @author: Leif
 * @date: 2024/1/2 21:48
 */
public class Solution {
    public int trap(int[] height){
        int ans =0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 弹出栈顶元素（低洼处），同时记录
                int top = stack.pop();
                // 此时如果栈中为空，直接跳过
                if(stack.isEmpty()){
                    break;
                }
                // 获取此时的栈顶元素，即原栈顶元素的下一个元素（top的左侧柱子）
                int left = stack.peek();
                // 获取低洼处的宽度，使用当前的下标减去左侧柱子(left)下标，得到宽度
                int curWidth = i - left - 1;
                // 获取top的左、右两个柱子高度的最小值，减去top（低洼处）的高度
                int curHeight = Math.min(height[left], height[i]) - height[top];
                // 累加积水面积
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
