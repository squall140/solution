package org.ex.leetcode.linkedlist.removenthnodefromendoflist019;

/**
 * @desc: Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * <p>
 * Example 1:
 * <img src= "https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" />
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * </p>
 *
 * <p>
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 *
 * </p>
 *
 *
 * 思路看视频
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
 *
 * 一、暴力解法， O(2n), O(1)
 * 二、快慢指针解法， O(n), O(1)
 *
 * 快慢指针法
 *
 * 标签：链表
 * 整体思路是让前面的指针先移动 n 步，之后前后指针共同移动直到前面的指针到尾部为止
 * 首先设立预先指针 pre，预先指针是一个小技巧，在第 2 题中进行了讲解
 * 设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
 * start 先向前移动n步
 * 之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
 * 因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
 * 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
 * 时间复杂度：O(n)O(n)O(n)
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/7803/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2023/12/19 15:21
 */
public class Solution01 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;
        ListNode start = dummy, end = dummy;

        // 让start先跑起来，start和end间隔为n
        while (n != 0){
            start = start.next;
            n--;
        }

        // 双指针开始同时跑，当快指针start跑到链表末尾的时候，也就是null的时候，那么此时的end正好和末尾保持了n个间隔
        while (start.next != null){
            start = start.next;
            end = end.next;
        }

        // 此时的end的位置正好是链表倒数第n个
        // 直接移除end的后置元素，使其链接到它后面的后面的那个元素
        end.next = end.next.next;

        //返回链表首节点
        return dummy.next;
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


        //


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
