package org.ex.leetcode.top100.stack.validparentheses020;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/5/15 15:07
 */
public class Solution02 {
    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> dic = new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        for (char ch : s.toCharArray()){
            if (dic.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != dic.get(ch)) {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
