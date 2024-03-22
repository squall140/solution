package org.ex.leetcode.top100.stack.validparentheses020;

import java.util.*;

/**
 * @desc: Valid Parentheses
 * @author: Leif
 * @date: 2024/3/22 14:19
 */
public class Solution {
    public static boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> dic = new HashMap<>(){{
            put(']','[');
            put('}','{');
            put(')','(');
        }};

        for (char ch : s.toCharArray()){
            // 重点是这里的判断
            if (dic.containsKey(ch)){
                // 如果当前栈为空，或者栈顶元素在字典里找不到相对应的key
                if(stack.isEmpty() || stack.peek() != dic.get(ch)) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }

        }
        // 这里注意return 时候的判断，如果栈是空的，且没有出现以上的问题
        // 那么就证明所有的字符都在栈内抵消
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }


}
