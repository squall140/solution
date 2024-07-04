package org.ex.leetcode.set.firstuniquecharacterinastring387;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: Fist unique character in a string
 *
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 * 思路
 *
 * 遍历字符串 s ，使用哈希表统计 “各字符数量是否 >1 ”。
 * 再遍历字符串 s ，在哈希表中找到首个 “数量为 1 的字符”，并返回。
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/first-unique-character-in-a-string/solutions/2361521/387-zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-c5md/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/5 17:11
 */
public class Solution {
    public static int firstUniqueChar(String s){
        HashMap<Character,Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        // 遍历字符数组
        for (char c : sc){
            // 若 dic 中 不包含 键(key) c ：则向 dic 中添加键值对 (c, True) ，代表字符 c 的数量为 1。
            // 若 dic 中 包含 键(key) c ：则修改键 c 的键值对为 (c, False) ，代表字符 c 的数量 >1 。
            dic.put(c, !dic.containsKey(c));
        }
        for( int i =0; i < sc.length; i++){
            // 重新遍历字符数组，找数量为 1（True） 的字符： 遍历字符串 s 中的每个字符 c
            // 若 dic中键 c 对应的值为 True ：，则返回其索引。
            if (dic.get(sc[i])) return i;
        }
        // 否则，返回 -1 ，代表不存在数量为 111 的字符。
        return -1;

    }


    public static int firstUniqueChar2(String s){
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0 ) + 1);
        }

        for(int i = 0; i < s.toCharArray().length; i++){
            char ch = s.toCharArray()[i];
            if ( 1 == freq.get(ch)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(firstUniqueChar2(s));
    }


}
