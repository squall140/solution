package org.ex.leetcode.linkedlist.oddevenlinkedlist328;

/**
 * @desc: Odd Even LinkedList
 *
 * Given the head of a singly linked list,
 * group all the nodes with odd indices together followed by the nodes with even indices,
 * and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * <p>
 *     Example1:
 *     <img src= "https://assets.leetcode.com/uploads/2021/03/10/oddeven-linked-list.jpg" />
 *     <br />
 *     Input: head = [1,2,3,4,5]
 *      <br />
 *     Output: [1,3,5,2,4]
 *
 *
 * </p>
 *
 * 思路一、奇偶链表法（迭代法）
 *
 * 对于原始链表，每个节点都是奇数节点或偶数节点。头节点是奇数节点，头节点的后一个节点是偶数节点，相邻节点的奇偶性不同。
 * 因此可以将奇数节点和偶数节点分离成奇数链表和偶数链表，然后将偶数链表连接在奇数链表之后，合并后的链表即为结果链表。
 *
 * 原始链表的头节点 head 也是奇数链表的头节点 以及 结果链表的头节点，head 的后一个节点是偶数链表的头节点。
 * 令 evenHead = head.next，则 evenHead 是偶数链表的头节点。
 *
 * 维护两个指针 odd 和 even 分别指向奇数节点和偶数节点，初始时 odd = head，even = evenHead。
 * 通过迭代的方式将奇数节点和偶数节点分离成两个链表，
 * 每一步首先更新奇数节点，然后更新偶数节点。
 *
 * 更新奇数节点时，奇数节点的后一个节点需要指向偶数节点的后一个节点，
 * 因此令 odd.next = even.next，然后令 odd = odd.next，此时 odd 变成 even 的后一个节点。
 *
 * 更新偶数节点时，偶数节点的后一个节点需要指向奇数节点的后一个节点，
 * 因此令 even.next = odd.next，然后令 even = even.next，此时 even 变成 odd 的后一个节点。
 *
 * 重复上述操作，直到全部节点分离完毕。
 * 全部节点分离完毕的条件是 even 为空节点或者 even.next 为空节点，此时 odd 指向最后一个奇数节点（即奇数链表的最后一个节点）
 *
 * 最后令 odd.next = evenHead，将偶数链表连接在奇数链表之后，即完成了奇数链表和偶数链表的合并，结果链表的头节点仍然是 head。
 *
 * <img src ="https://assets.leetcode-cn.com/solution-static/328/1.png" />
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/odd-even-linked-list/solutions/482737/qi-ou-lian-biao-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 *
 * @author: Leif
 * @date: 2023/12/20 10:44
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // 偶总是在奇后面
        while (even !=null && even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // 全部节点分离完毕的条件是 even 为空节点或者 even.next 为空节点，
        // 此时 odd 指向最后一个奇数节点（即奇数链表的最后一个节点），
        // 最后把odd尾部节点指向even的头结点，完成合并，结果链表的头节点仍然是 head。
        odd.next = evenHead;
        return head;

    }



}
