package org.ex.leetcode.dp.besttimebuyandsellstackI121;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/6/18 21:36
 */
public class Ex01 {
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // 持有，当天就买了股票或者之前就买过股票
        dp[0][0] = -prices[0];
        // 未持有，当天没买卖股票或者之前卖了但是当天没卖
        dp[0][1] = 0;

        for(int i = 1; i < n; i++){
            // 持有
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            // 未持有
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] +prices[i]);
        }

        // 返回未持有的状态，也就是说未持有一定就是之前都抛售了，那么此时手里的现金肯定是要比持有时候多的
        return dp[n - 1][1];

    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // 最大利润 6 - 1 = 5
        System.out.println(maxProfit(prices));
    }


}
