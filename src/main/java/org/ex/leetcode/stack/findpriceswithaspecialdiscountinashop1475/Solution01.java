package org.ex.leetcode.stack.findpriceswithaspecialdiscountinashop1475;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
 * 思路比较简单，我们以prices = [8,4,6,2,3]为例，看一下具体操作逻辑：
 *
 * 步骤1：遍历prices[4]=3元素，由于堆栈是空的，所以直接将3入栈。
 * 步骤2：遍历prices[3]=2元素，由于小于栈顶元素3，所以将3踢出堆栈，此时堆栈为空，则将2入栈。
 * 步骤3：遍历prices[2]=6元素，由于大于栈顶元素2，所以执行6减2得到优惠价格4，将prices[2]修改为4，并将6入栈。
 * 步骤4：遍历prices[1]=4元素，由于小于栈顶元素6，所以将6踢出堆栈，此时再对比栈顶元素2，由于大于栈顶元素2，所以执行4减2得到优惠价格2，将prices[1]修改为2，并将4入栈。
 * 步骤5：遍历prices[0]=8元素，由于大于栈顶元素4，所以执行8减4得到优惠价格4，将prices[0]修改为4，并将8入栈。
 *
 * ============================================
 * <b>把上面的步骤反过来想，就是以下的代码实现</b>
 * 注意单调栈里面维护的只是索引下标
 * ============================================
 *
 * @author: Leif
 * @date: 2024/1/2 14:09
 */
public class Solution01 {
    public static int[] finalPrices(int[] prices){
        Deque<Integer> stack = new LinkedList<>();
        int n = prices.length;
        for (int i = 0; i < n; i++){
            int price = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] >= price){
                // 获取栈顶元素索引
                int idxTop = stack.pop();
                prices[idxTop] = prices[idxTop] - price;
            }
            stack.push(i);
        }
        return prices;

    }

    public static void main(String[] args) {
//        int[] prices = {8,4,6,2,3};
        int[] prices = {1,2,3,4,5};
        Arrays.stream(finalPrices(prices)).forEach(System.out::println);

    }

}
