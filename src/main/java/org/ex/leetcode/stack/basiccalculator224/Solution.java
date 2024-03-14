package org.ex.leetcode.stack.basiccalculator224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Basic Calculator
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it,
 * and return the result of the evaluation.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 * such as eval().
 *
 * <br /><br />
 * <p >
 * Example 1:
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 *
 * </p>
 *
 * @author: Leif
 * @date: 2024/1/3 09:19
 */
public class Solution {
    public int calculate(String s){
        Deque<Integer> stack = new LinkedList<Integer>();
        // 标记正负 , 1为正，-1为负
        int sign = 1;
        stack.push(sign);

        int res = 0;
        // 字符串指针
        int i = 0;
        while (i < s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                // 如果是空格，直接跳过
                i++;
            }else if(ch == '+'){
                // sign 此时标记为加号，正数
                sign = stack.peek();
                i++;
            }else if(ch == '-'){
                // 标记为减号，负数
                sign = -stack.peek();
                i++;
            }else if(ch == '('){
                // 压栈，开始标记状态
                stack.push(sign);
                i++;
            }else if(ch == ')'){
                // 出栈，解除标记状态
                stack.pop();
                i++;
            }else{
                // 剩下的都是数字，计算
                int num = 0;
                // 由于 i 在发生变化，获取字符要动态截取拼接
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    /**
                     * 操作数可以由多个字符组成，字符串 "123" 表示数字 123，它可以被构造为：123 >> 120 + 3 >> 100 + 20 + 3。
                     *
                     * 0 * 10 + 1 = 1
                     * 1 * 10 + 2 = 12
                     * 12 * 10 + 3 = 123
                     *
                     * 如果我们读取的字符是一个数字，则我们要将读取的数字乘以 10 的幂并将当前数字相加，形成操作数。
                     * 因为我们是按逆序处理字符串。
                     *
                     * 这里的 s.charAt(i) -'0' 是位了把 s.charAt(i)的字符转换成整形，也可以换成 Integer.parseInt(s.charAt(i))
                     *
                     */
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // sign 这里起到变号（+,-)作用
                res += sign * num;
            }

        }

        return res;
    }
}
