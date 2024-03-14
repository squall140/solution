package org.ex.leetcode.stack.basiccalculator224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/14 23:33
 */
public class Ex02 {
    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int n = s.length();
        // 定义符号标识，默认正数
        int sign = 1;
        stack.push(sign);
        int res = 0;
        // 开始遍历
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == ' '){
                continue;
            }else if (ch == '+'){
                sign = stack.peek();
            }else if (ch == '-'){
                sign = -stack.peek();
            }else if (ch == '('){
                // 入括号，优先级高，压入符号栈
                stack.push(sign);
            }else if (ch == ')'){
                // 弹出符号
                stack.pop();
            }else{
                // 开始计算具体操作数
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // 累计结果
                res += num * sign;

            }
        }

        return res;


    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
