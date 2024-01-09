package org.ex.leetcode.set.isomorphicstrings205;

import java.util.HashMap;

/**
 * @desc: Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p>
 * 解法一
 * 题目描述中已经很详细了，两个字符串同构的含义就是字符串 s 可以唯一的映射到 t ，同时 t 也可以唯一的映射到 s 。
 * <p>
 * 举个具体的例子。
 * <p>
 * egg 和 add 同构，就意味着下边的映射成立
 * e -> a
 * g -> d
 * 也就是将 egg 的 e 换成 a, g 换成 d, 就变成了 add
 * <p>
 * 同时倒过来也成立
 * a -> e
 * d -> g
 * 也就是将 add 的 a 换成 e, d 换成 g, 就变成了 egg
 * <p>
 * foo 和 bar 不同构，原因就是映射不唯一
 * o -> a
 * o -> r
 * 其中 o 映射到了两个字母
 * <p>
 * 作者：windliang
 * 链接：https://leetcode.cn/problems/isomorphic-strings/solutions/60994/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: Leif
 * @date: 2024/1/5 10:14
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                if (map.get(c1) != c2) return false;
            }else{
                map.put(c1,c2);
            }
        }
        return true;
    }
}
