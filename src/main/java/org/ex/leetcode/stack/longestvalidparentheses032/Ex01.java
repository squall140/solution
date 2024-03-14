package org.ex.leetcode.stack.longestvalidparentheses032;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/14 22:59
 */
public class Ex01 {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        //哨兵，方便后续程序做判断
        stack.push(-1);

        for (int i = 0 ; i < n; i++){
            char ch = s.charAt(i);
            if (ch == '('){
                // 如果是左括号直接入栈
                stack.push(i);
            }else{
                // 此时哨兵节点的-1派上用场了，首次弹栈，相当于把-1弹出去了
                stack.pop();
                // 如果弹出后此时栈位空，那么相当于就是空栈
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    // 累计计算栈顶到栈底的距离
                    res  = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;


    }
    public static void main(String[] args) {
        String s = ")()())";
//        String s = "(()";
//        String s = "";
        System.out.println(longestValidParentheses(s));

    }
}
