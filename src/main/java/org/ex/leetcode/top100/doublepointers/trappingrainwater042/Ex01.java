package org.ex.leetcode.top100.doublepointers.trappingrainwater042;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/11 10:53
 */
public class Ex01 {
    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[i], height[left]) - height[top];
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

}
