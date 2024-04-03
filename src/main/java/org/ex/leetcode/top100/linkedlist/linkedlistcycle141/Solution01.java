package org.ex.leetcode.top100.linkedlist.linkedlistcycle141;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/2 09:07
 */
public class Solution01 {
    public boolean hasCycle(ListNode head){
        Set<ListNode> visited = new HashSet<>();
        while( head != null){
            // 如果某个节点能够被遍历两次，视为有环
            if(visited.contains(head)){
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;

    }
}
