package org.ex.leetcode.top100.stack.minstack155;

import java.util.Stack;

/**
 * @desc: Min Stack
 * @author: Leif
 * @date: 2024/3/22 15:18
 */
public class Solution {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;


    public void push(int val) {
        // 如果当前元素小于等于最小栈的栈顶，或者此时最小栈为空
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
        stack.push(val);

    }

    public void pop() {
        // 如果最小栈的栈顶元素与stack栈顶弹出的元素相同，那么也同样弹出最小栈，继续维护最小性
        if(min_stack.peek() == stack.pop()) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
