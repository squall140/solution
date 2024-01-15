package org.ex.leetcode.linkedlist.lrucache146;

/**
 * @desc: LRUCache
 * @author: Leif
 * @date: 2024/1/15 16:36
 */
public class Solution01 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));

        cache.put(3, 3);
        System.out.println(cache.get(2));

    }
}
