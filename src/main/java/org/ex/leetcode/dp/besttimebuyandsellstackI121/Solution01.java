package org.ex.leetcode.dp.besttimebuyandsellstackI121;

/**
 * @desc: 简单的DP，从当前价格找到之前的最小价格，从而求出当前利润
 *
 * https://www.bilibili.com/video/BV13J4m187tN/?spm_id_from=333.337.search-card.all.click&vd_source=0eb0031fa1113525cca7513d09425eff
 *
 * @author: Leif
 * @date: 2024/6/18 17:19
 */
public class Solution01 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min_price = prices[0];
        int max_profit = 0;
        for(int i = 1; i < n; i++){
            // 如果当天价格小于之前的价格，则更新最低价格
            if(prices[i] < min_price){
                min_price = prices[i];
            }else{
                // 计算当前利润，并累计最大利润
                int cur_profit = prices[i] - min_price;
                max_profit = Math.max(max_profit, cur_profit);
            }
        }

        return max_profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        // 最大利润 6 - 1 = 5
        System.out.println(maxProfit(prices));
    }
}
