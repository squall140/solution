package org.ex.leetcode.set.containsduplicate217;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/4 16:06
 */
public class Ex01 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if (!set.add(x)) return true;
        }
        return false;
    }
}
