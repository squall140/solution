package org.ex.leetcode.stack.validparentheses020;

import java.util.Stack;

/**
 * @desc: Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * 思路，使用栈的特性
 * 判断如果是左括号，直接入栈，如果是右括号，判断栈顶是否有对应的左括号，直接弹栈，
 * 如果不为空，则弹出对应的左括号
 * 返回栈是否为空
 *
 * @author: Leif
 * @date: 2023/12/20 21:05
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        // 开始遍历单个字符
        for (char ch : charArray){
            // 如果是左括号，直接压栈
            if ('(' == ch || '[' == ch || '{' == ch){
                stack.push(ch);
            }else {
                if(!stack.isEmpty()){
                    // 如果是右括号并且此时栈不空
                    if (')' == ch && stack.pop() != '('){
                        return false;
                    }else if (']' == ch && stack.pop() != '['){
                        return false;
                    }else if ('}' == ch && stack.pop() != '{'){
                        return false;
                    }
                }else{
                    //栈是空的返回false
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
