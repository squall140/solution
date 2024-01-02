package org.ex.leetcode.stack.dailytemperatures739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Daily temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * 思路 单调栈
 * 官方解法看视频
 * https://leetcode.cn/problems/daily-temperatures/solutions/283196/mei-ri-wen-du-by-leetcode-solution/
 *
 * 还有其他的一系列单调栈问题
 *
 *  序号	题目	类型	解法
 *  1	No.739 每日温度	中等	单调栈
 *  2	No.496 下一个更大元素 I	简单	单调栈
 *  3	No.496 下一个更大元素 II	中等	单调栈
 *  4	No.901 股票价格跨度	中等	单调栈
 *  5	No.402 移掉K位数字	中等	单调栈
 *  6	No.581 最短无序连续子数组	中等	单调栈
 *  7	No.84 柱状图中最大的矩形	困难	单调栈
 *  8	No.42 接雨水

作者：Lemon
链接：https://leetcode.cn/problems/daily-temperatures/solutions/868874/yi-pian-ti-jie-gao-ding-dan-diao-zhan-we-2pkf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/2 14:30
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int cur_temperature = temperatures[i];
            while(!stack.isEmpty() && cur_temperature > temperatures[stack.peek()]){
                // 弹出栈顶元素，并记录其下标
                int index = stack.pop();
                // 计算下标之间的差值
                ans[i] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
