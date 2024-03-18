package org.ex.leetcode.stack.findpriceswithaspecialdiscountinashop1475;

/**
 * @desc: 直接模拟
 * @author: Leif
 * @date: 2024/3/15 10:00
 */
public class Solution02 {
    public int[] finalPrices(int[] prices){
        for (int i = 0; i < prices.length; i++){
            int index = i;
            while (index < prices.length){
                index ++;
                if (prices[i] >= prices[index]){
                    prices[i] = prices[i] - prices[index];
                    break;
                }
            }
        }
        return prices;
    }

}
