package org.ex.leetcode.top100.linkedlist.swapnodesinpairs024;

/**
 * @desc:
 * 思路 迭代法
 * 清晰题解
 * https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/2374872/tu-jie-die-dai-di-gui-yi-zhang-tu-miao-d-51ap/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author: Leif
 * @date: 2024/4/3 15:37
 */
public class Solution02 {
    public ListNode swapPairs(ListNode head) {
       if (head == null || head.next == null) return head;
         // 设置虚拟头节点（哨兵节点）
         ListNode dummy = new ListNode(0,head);
         ListNode node0 = dummy;
         ListNode node1 = head;

         while (node1 != null && node1.next!= null){ // 至少有2个节点
             ListNode node2 = node1.next;
             ListNode node3 = node2.next;

             // 先把指针调整好，参考题目注释中的图示
             // 0 -> 2  node0就是dummy
             node0.next = node2;
             // 2 -> 1
             node2.next = node1;
             // 1 -> 3
             node1.next = node3;

             // node0        node1    node2   node3
             //  0(node0),      1,      2,      3,      4 ...

             // 此时，把node0更新为原来的node1，为了后面的3，4交换
             //  0,      2,      1(新node0),      3(新node1),      4 ...

             // 准备下一轮交换，把原node0(dummy)指向了node1，原node1指向了node3
             // 进行下一轮交换之前，必须要把node0(dummy)调整到 3,4之前
             node0 = node1;
             node1 = node3;

         }
         // 返回新链表的头节点
         return dummy.next;

    }
}
