package org.ex.leetcode.dp.besttimebuyandsellstackI121;

/**
 * @desc: 常规DP解法（股票类通用）
 * <p>
 * 1.dp数组定义
 * dp[i][0]: 持有股票（之前买入 或者 当天买入 都算持有）
 * dp[i][1]: 不持有古朴奥（之前卖出 或者 当天卖出 都算不持有）
 * <p>
 * 2.状态转移方程
 * 2.1 dp[i-1][0] 代表之前就持有股票的资产状态， -prices[i] 代表当天买入股票的资产状态
 * 推导出 dp[i][0] = max (dp[i-1][0], -prices[i])  代表在第i天的两种持股状态（之前就买入后的资产状态 / 当天买入后的资产状态）
 * <p>
 * 2.2 dp[i-1][1] 代表之前就买入股票的状态， dp[i-1][0]+prices[i] 代表当天买入股票后的资产状态
 * 推导出 dp[i][1] = max (dp[i-1][1], dp[i-1][0]+prices[i])
 * <p>
 * 3.dp数组初始化（枚举两种状态）
 * dp[i][0] = -prices[i] 代表刚开始第一天就买入的状态 （持有股票）
 * dp[i][1] = 0  代表第一天不持股的状态
 * <p>
 * <p>
 * 4.结果
 * 最终，手头上的现金一定是不持有股票（卖出后）要比持有股票的多，所以只需要返回一个状态 dp[n-1][1]
 * <p>
 * <p>
 * <p>
 * 看卡尔的视频
 * https://www.bilibili.com/video/BV1Xe4y1u77q/?spm_id_from=pageDriver&vd_source=0eb0031fa1113525cca7513d09425eff
 * <p>
 * 代码这里
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solutions/38477/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 * @author: Leif
 * @date: 2024/6/18 17:19
 */
public class Solution02 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][2];

        // dp[i][0] 持股
        // dp[i][1] 不持股
        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        // 从第2天开始遍历
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        // 返回不持股的状态（现金最多）
        return dp[n - 1][1];

    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // 最大利润 6 - 1 = 5
        System.out.println(maxProfit(prices));
    }
}
