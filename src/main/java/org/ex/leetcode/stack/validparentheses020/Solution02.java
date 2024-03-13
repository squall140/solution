package org.ex.leetcode.stack.validparentheses020;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 15:17
 */
public class Solution02 {
    public static boolean isValid(String s) {
        int n = s.length();
        // 如果是奇数个，直接返回，肯定不对称
        if (n % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        // 注意key / value的顺序，因为括号是先有左括号，再有右括号的
        Map<Character, Character> pairs  = new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        for (int i = 0; i < n; i ++){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                // 如果此时栈空，或者栈顶元素不是相应的反括号，那么直接返回false
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)){
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
