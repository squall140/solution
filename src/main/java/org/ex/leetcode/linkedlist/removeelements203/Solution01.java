package org.ex.leetcode.linkedlist.removeelements203;

/**
 * @desc: Remove Elements
 *
 * <img src= "https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg" />
 *
 * <p>
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * </p>
 * <p>
 * Input: head = [], val = 1
 * Output: []
 * </p>
 *
 *
 * 思路一、迭代（遍历解法） O(n)，O(1)
 *
 *
 * @author: Leif
 * @date: 2023/12/19 14:40
 */
public class Solution01 {
    public static ListNode removeElements(ListNode head, int val){
        // 虚拟投节点
        ListNode dummyNode = new ListNode(-1, head);
        dummyNode = head;
        ListNode pre = dummyNode;
        ListNode cur = head;

        while( cur != null){
            if(cur.val == val){
                // 直接把前一个链接到后一个，移除当前的节点
                pre.next = cur.next;
            }else{
                // 更新前节点
                pre = cur;
            }
            // 当前节点向前一步
            cur = cur.next;
        }
        // 返回处理后的链表的头节点，即dummyNode的下一个节点
        return dummyNode.next;
    }
    public static void main(String[] args) {
        // 创建首节点
        ListNode head = new ListNode(0);
        // 声明下一个节点
        ListNode next;
        // 指向首节点
        next = head;

        for (int i=1; i<5; i++){
            ListNode node = new ListNode(i);
            next.next = node;
            next = next.next;
        }

        //当for循环完成之后 nextNode指向最后一个节点
        next = head;
        print(next);

    }


    static void print(ListNode ln){
        //创建链表节点
        while(ln!=null){
            System.out.println("节点:"+ln.val);
            ln=ln.next;
        }
        System.out.println();
    }




}
