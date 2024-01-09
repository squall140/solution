package org.ex.leetcode.set.validanagram242;

import java.util.Arrays;

/**
 * @desc: Valid Anagram
 * <p>
 * <p>
 * 思路  哈希表
 *
 * 从另一个角度考虑，t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。
 * 由于字符串只包含 26 个小写字母，因此我们可以维护一个长度为 26 的频次数组 table，
 * 先遍历记录字符串 s 中字符出现的频次，然后遍历字符串 t，减去 table 中对应的频次，
 * 如果出现 table[i]<0，则说明 t 包含一个不在 s 中的额外字符，返回 false 即可
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/valid-anagram/solutions/493231/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * @author: Leif
 * @date: 2024/1/5 11:04
 */
public class Solution02 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() ) return false;
        int count = 26;
        int[] table = new int[count];
        for (int i =0; i<s.length(); i++){
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i< count; i ++){
            if (table[i] != 0) return false;
        }

        return true;

    }
}
