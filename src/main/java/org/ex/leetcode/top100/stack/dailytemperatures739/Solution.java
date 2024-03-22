package org.ex.leetcode.top100.stack.dailytemperatures739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Daily temperatures
 * @author: Leif
 * @date: 2024/3/22 15:37
 */
public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temperatures)).forEach(System.out::print);

    }
}
