package org.ex.leetcode.stack.minstack155;

import java.util.Stack;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/3/13 15:40
 */
public class Ex01 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int val) {
            if (min_stack.peek() >= val || min_stack.isEmpty()){
                min_stack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop().equals( min_stack.peek())){
                min_stack.pop();
            }

        }

        public int top() {
            return stack.pop();

        }

        public int getMin() {
            return min_stack.pop();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
