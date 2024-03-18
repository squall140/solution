package org.ex.leetcode.stack.dailytemperatures739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/18 09:55
 */
public class Ex01 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++){
            int cur = temperatures[i];
            while(!stack.isEmpty() && cur >= temperatures[stack.peek()]){
                // 弹出栈顶元素索引
                int index = stack.pop();
                // 用i - index 表示间隔几天
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Arrays.stream(dailyTemperatures(temperatures)).forEach(System.out::print);

    }
}
