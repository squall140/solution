package org.ex.leetcode.set.validanagram242;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 15:56
 */
public class Ex01 {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if ( m != n ) return false;

        int count = 26;
        int[] table = new int[count];

        for(int i = 0; i < m; i++){
            table[s.charAt(i) - 'a']--;
            table[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < count; i++){
            if (table[i] != 0) return false;
        }

        return true;
    }
}
