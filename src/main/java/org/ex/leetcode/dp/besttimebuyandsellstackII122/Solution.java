package org.ex.leetcode.dp.besttimebuyandsellstackII122;

/**
 * @desc: 注意这里和上一题不一样，这里由于可以买卖多次
 * @author: Leif
 * @date: 2024/6/19 15:05
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];

        // 已持有状态（第一天）
        dp[0][0] = -prices[0];
        // 未持有状态（第一天）
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            // 已持有状态（当日购买或者之前已经购买），这里由于可以买卖多次，所以是 dp[i - 1][1] - prices[i]

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 未持有状态（当日抛售或者之前就已经抛售了）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

        // 返回抛售后的现金流（一定是未持有的时候最大）
        return dp[n - 1][1];

    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // 最大利润 6 - 1 = 5
        System.out.println(maxProfit(prices));
    }
}
