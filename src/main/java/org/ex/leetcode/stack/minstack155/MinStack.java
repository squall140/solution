package org.ex.leetcode.stack.minstack155;

import java.util.Stack;

/**
 * @desc:  Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * 解题思路：
 * 借用一个辅助栈 min_stack，用于存获取 stack 中最小值。
 *
 * 算法流程：
 *
 * push() 方法： 每当push()新值进来时，如果 小于等于 min_stack 栈顶值，则一起 push() 到 min_stack，即更新了栈顶最小值；
 * pop() 方法： 判断将 pop() 出去的元素值是否是 min_stack 栈顶元素值（即最小值），如果是则将 min_stack 栈顶元素一起 pop()，这样可以保证 min_stack 栈顶元素始终是 stack 中的最小值。
 * getMin()方法： 返回 min_stack 栈顶即可。
 * min_stack 作用分析：
 *
 * min_stack 等价于遍历 stack所有元素，把升序的数字都删除掉，留下一个从栈底到栈顶降序的栈。
 * 相当于给 stack 中的降序元素做了标记，每当 pop() 这些降序元素，min_stack 会将相应的栈顶元素 pop() 出去，保证其栈顶元素始终是 stack 中的最小元素。
 * 复杂度分析：
 *
 * 时间复杂度 O(1) ：压栈，出栈，获取最小值的时间复杂度都为 O(1) 。
 * 空间复杂度 O(N) ：包含 NNN 个元素辅助栈占用线性大小的额外空间。
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/min-stack/solutions/9036/min-stack-fu-zhu-stackfa-by-jin407891080/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2023/12/21 08:58
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // 如果val小于等于最小栈中的栈顶元素，那么val要比min_stack的栈顶元素更小，那么就一起押入min_stack
        if (min_stack.isEmpty() || val <= min_stack.peek() ){
            min_stack.push(val);
        }
    }

    public void pop() {
        // 如果当前栈stack栈顶元素等于最小栈的栈顶元素的时候，一起出栈，保持最小栈中栈顶的元素值一只是stack中最小的
        if (stack.pop().equals(min_stack.peek())){
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
