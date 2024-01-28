package org.ex.leetcode.stack.removekdigits402;

import java.util.*;

/**
 * @desc: Remove K digits
 *
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 *
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *  Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 *
 * 思路，贪心 + 单调栈
 *
 * 大概的思路看这个题解
 * https://leetcode.cn/problems/remove-k-digits/solutions/1800873/by-straicat-oixa/
 *
 *
 * @author: Leif
 * @date: 2024/1/25 13:03
 */
public class Solution {
    public static String removeKdigits(String num, int k){
        // 字符串栈存储要保留的数字
        Deque<Character> stk = new ArrayDeque<>();
        // 从左到右遍历字符串
        for (char c: num.toCharArray()){
            // 如果此时
            // 1. 栈不为空
            // 2. 栈顶元素大于当前的元素
            // 3. 还没有删除足够多的数字，即 k >0
            // 那么这个时候需要把栈顶元素弹出，同时递减k
            while (!stk.isEmpty() && stk.peek() > c && k > 0 ){
                stk.pop();
                k--;
            }
            // 如果发现当前遍历到的自负是0并且此时栈是空的
            // 那么就不能把0入栈，否则最终结果会以0开头
            if (c == '0' && stk.isEmpty()){
                continue;
            }

            // 当前字符直接入栈
            stk.push(c);
        }

        // 遍历完所有的字符后如果发现还没有删除足够多的元素那么需要继续删除
        // 什么数字会出现这种情况呢?
        // 比如数字为123456789，删除的数字k为1 （也就是说  stk.peek() 一直小于 c )
        while (!stk.isEmpty() && k > 0) {
            // 不断的弹出栈顶元素
            stk.pop();
            // 直到k为0位置
            k--;
        }

        // 操作完毕之后，如果发现栈为空，按上面逻辑我们会返回字符"",
        // 但根据题目的示例3，num = "10"，k = 2时，从原数字移除所有的数字，剩余为空就是О
        // 需要返回"0"
        if (stk.isEmpty()) {
            return "0";
        }


        StringBuilder result = new StringBuilder();
        // 如果栈中还有元素
        while (!stk.isEmpty()) {
            // 那么从栈顶到栈底把字符添加到result上
            result.append(stk.peek());
            // 同时不断的弹出栈顶元素
            stk.pop();
        }
        // 由于stack中的栈底是数字的最高位。栈顶是最低位
        // 所以此时result保存的顺序是最低位到最高位
        // 需要执行一次翻转操作
        return result.reverse().toString();


    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num,k));
    }
}
