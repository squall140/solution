package org.ex.leetcode.linkedlist.intersectionoftwolinkedlists160;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: Intersection of Two Linked Lists
 *
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * <img src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png" />
 *
 * Note that the linked lists <b>must retain their original structure</b> after the function returns.
 *
 * Custom Judge:
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 *</p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * </p>
 * <p>Output: Intersected at '8'
 * </p>
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 *
 *
 *
 * 迭代法、哈希集合解法
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
 * 力扣官方解法一
 *  时间复杂度：O(n+m)
 *  空间复杂度：O(m) : 其中 m 是链表 headA的长度, 需要使用哈希集合存储链表 headA 中的全部节点。
 *
 *
 *
 * </p>
 *
 * @author: Leif
 * @date: 2023/12/19 10:45
 */
public class Solution01 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode tmp = headA;

        //先把headA遍历一遍，放入哈希集合
        while( tmp != null){
            visited.add(tmp);
            tmp = tmp.next;
        }

        //然后使用headB，遍历headB，是否能找到headA的匹配项（tmp)
        tmp = headB;
        while(tmp != null){
            //HashMap.containsKey
            if(visited.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }

        // 如果找不到，那么两个链表就是没有交点
        return null;

    }

}
