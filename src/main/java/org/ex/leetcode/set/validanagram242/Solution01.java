package org.ex.leetcode.set.validanagram242;

import java.util.Arrays;

/**
 * @desc: Valid Anagram
 * <p>
 * <p>
 * 思路  排序法
 *
 * 方法一：排序
 * t 是 s 的异位词等价于「两个字符串排序后相等」。因此我们可以对字符串 s 和 t 分别排序，
 * 看排序后的字符串是否相等即可判断。此外，如果 s 和 t 的长度不同，t 必然不是 s 的异位词。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/valid-anagram/solutions/493231/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为 (nlogn)，
 * 空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。
 *
 *
 * @author: Leif
 * @date: 2024/1/5 11:04
 */
public class Solution01 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        return Arrays.equals(arrS, arrT);


    }
}
