package org.ex.leetcode.advance.greedy.lemonadechange860;

import java.util.Arrays;

/**
 * @desc: Lemonade Change
 *
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 * Note that you do not have any change in hand at first.
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
 *
 * Example 1:
 * Input: bills = [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 *
 * Example 2:
 * Input: bills = [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can not give the change of $15 back because we only have two $10 bills.
 * Since not every customer received the correct change, the answer is false.
 *
 * 思路 贪心法
 *
 * 方法一：贪心
 *
 * 由于顾客只可能给你三个面值的钞票，而且我们一开始没有任何钞票，因此我们拥有的钞票面值只可能是 555 美元，101010 美元和 202020 美元三种。基于此，我们可以进行如下的分类讨论。
 * 5 美元，由于柠檬水的价格也为 5 美元，因此我们直接收下即可。
 * 10 美元，我们需要找回 5 美元，如果没有 5 美元面值的钞票，则无法正确找零。
 * 20 美元，我们需要找回 15 美元，此时有两种组合方式，
 *  一种是一张 10 美元和 5 美元的钞票，
 *  一种是 3 张 5 美元的钞票，
 * 如果两种组合方式都没有，则无法正确找零。
 *
 * 当可以正确找零时，两种找零的方式中我们更倾向于第一种，
 * 即如果存在 5 美元和 10 美元，我们就按第一种方式找零，否则按第二种方式找零，
 * 因为需要使用 5 美元的找零场景会比需要使用 10 美元的找零场景多，我们需要尽可能保留 5 美元的钞票。
 *
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/lemonade-change/solutions/515708/ning-meng-shui-zhao-ling-by-leetcode-sol-nvp7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * @author: Leif
 * @date: 2024/1/24 15:17
 */
public class Solution {
    public static boolean lemonadeChange(int[] bills){
        int five = 0, ten = 0;

        for (int bill: bills){
            if(bill == 5 ){
                five++;
            }else if (bill == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }else{
                // 遇到20面值大钞时
                // 策略一，使用 1张5元 和 1张10元的
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    // 策略二，如果10元的没有了，直接使用3张五元的
                    five -= 3;
                }else{
                    // 找不开了
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,5,20,5,10,5,20};
        // 15, 15 + 10 + (5 - 10), 25, 25 + 20 + (5 - 20)= 30, 35, 35 + 10 + (5 - 10) =
        int[] bills = {5,5,10,10,20};
       // 10, 10 + 10 + (5-10) = 15, 15 + 10 + (5-10) = 20
        System.out.println(lemonadeChange(bills));
    }


}
