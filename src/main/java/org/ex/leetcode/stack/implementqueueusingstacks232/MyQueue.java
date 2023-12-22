package org.ex.leetcode.stack.implementqueueusingstacks232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: Implement Queue Using Stacks (Two Stacks)
 *
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 *
 * 思路 双栈实现
 *
 * 将一个栈当作输入栈，用于压入 push 传入的数据；另一个栈当作输出栈，用于 pop 和 peek 操作。
 * 每次 pop 或 peek 时，若输出栈为空，则将输入栈的全部数据依次弹出并压入输出栈，
 * 这样输出栈 从栈顶往栈底 的顺序就是 队列 从 队首往队尾 的顺序。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks/solutions/632369/yong-zhan-shi-xian-dui-lie-by-leetcode-s-xnb6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 时间复杂度： push 和 empty 为 O(1), pop 和 peek 均摊 O(1)。
 * 空间复杂度： O(n) ，n是操作总数，对于有n次的 push 的操作，队列中会有n个元素，故空间复杂度O(n)
 *

 * @author: Leif
 * @date: 2023/12/22 16:19
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()){
            stackTranfer();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()){
            stackTranfer();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // inStack -> outStack
    public void stackTranfer(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

}
