package org.ex.leetcode.stack.longestvalidparentheses032;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')',
 * return the length of the longest valid (well-formed) parentheses
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 * 思路解法
 * 力扣官方 解法二 栈的解法
 * https://leetcode.cn/problems/longest-valid-parentheses/solutions/314683/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 *
 * <p>
 * 注意，这张图代表的就是下文注释中提到的 <b>分割元素</b>
 * 这里的分割元素就是 下标为2 的 ')'
 * <img src = "https://assets.leetcode-cn.com/solution-static/32/5.png" />
 * </p>
 *
 *
 * O(n)：遍历一次字符串
 * O(n)：栈的大小最大可以达到n
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/22 15:23
 */
public class Solution {

    public int longestValidParentheses(String s){
        int n = s.length();
        int res = 0 ;
        // 辅助栈，用来存储字符元素的索引（整形）
        Deque<Integer> stack = new LinkedList<>();
        // 首次放到栈底，为了方便处理边界条件，计算后续的元素位置，因为栈的第一个元素的下标为0
        /**
         * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，
         * 这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，
         * 我们在一开始的时候往栈中放入一个值为 −1 的元素。
         * 也可以理解为 栈底的 -1 就是哨兵节点（参照物）
         */
        stack.push(-1);

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == '('){
                // 如果是'('入栈
                stack.push(i);
            }else{
                // ch == ')'
                stack.pop();
                if (stack.isEmpty()){
                    // 如果出栈后，此时的栈为空，也就是最开始的哨兵节点（-1）也被弹出去了，
                    // 可以视为当前的元素实际上就是字符串括号之间的分割元素，
                    // 直接入栈，分割元素如果不清楚查看笔记
                    stack.push(i);
                }else{
                    // 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;



    }



}
