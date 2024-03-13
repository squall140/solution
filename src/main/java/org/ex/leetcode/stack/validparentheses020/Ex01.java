package org.ex.leetcode.stack.validparentheses020;

import java.util.Stack;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 15:04
 */
public class Ex01 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for( char ch : charArray){
            // 如果是左括号，直接压站
            if (ch == '{' || ch == '[' || ch =='('){
                stack.push(ch);
            }else {
                if (!stack.isEmpty()){
                    // 如果是右括号并且此时栈不空
                    if (ch == ')' && stack.pop() != '('){
                        return false;
                    }else if (ch == ']' && stack.pop() != '['){
                        return false;
                    } else if (ch == '}' && stack.pop() != '{') {
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
