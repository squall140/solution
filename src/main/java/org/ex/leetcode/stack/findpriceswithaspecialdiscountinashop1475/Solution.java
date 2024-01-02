package org.ex.leetcode.stack.findpriceswithaspecialdiscountinashop1475;

/**
 * @desc: Find price in a special discount in a shop
 *
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop.
 * If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i].
 * Otherwise, you will not receive any discount at all.
 *
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop,
 * considering the special discount.
 *
 * <br /><br />
 * <p>
 *     Example 1:
 *      Input: prices = [8,4,6,2,3]
 *      Output: [4,2,4,2,3]
 *      Explanation:
 *      For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 *      For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 *      For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 *      For items 3 and 4 you will not receive any discount at all.
 * </p>
 *
 * <br /><br />
 * <p>
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 * </p>
 *
 * 思路  单调栈解法
 *
 * <img src= "https://pic.leetcode-cn.com/1661986086-pdKzcG-1.png" />
 *
 * case1：如果堆栈中为空，则直接入栈。
 * case2：如果待入栈的元素大于等于栈顶元素，则计算入栈元素与栈顶元素之差，作为优惠后的价格，然后执行入栈操作。
 * case3：如果待入栈的元素小于栈顶元素，则执行出栈操作。
 *
 * 作者：爪哇缪斯
 * 链接：https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/solutions/1790574/by-muse-77-nh2d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/2 14:09
 */
public class Solution {
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
