package org.ex.leetcode.top100.doublepointers.trappingrainwater042;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/25 09:26
 */
public class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++){
            // 当前元素柱子高度大于栈顶元素时
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 弹出栈顶元素作为当前的低洼处高度
                int top = stack.pop();
                // 如果此时栈为空，则终止循环
                if(stack.isEmpty()) break;
                // 栈不为空的话，拿到此时的栈顶元素，即上面弹出栈顶元素的前一个元素（左柱子）
                int left = stack.peek();
                // 尝试计算此时的宽度
                int curWidth = i - left - 1;
                // 尝试求接水高度，即两个柱子之间的最小高度减去低洼处高度
                int curHeight = Math.min(height[i],height[left]) - height[top];
                // 不断累计面积
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
