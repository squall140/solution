package org.ex.leetcode.advancedalgorithm.greedy.canplaceflowers605;

/**
 * @desc: Can Place Flowers
 * <p>
 * You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's,
 * where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * 思路 贪心算法，如果有就先种花
 *
 * @author: Leif
 * @date: 2024/1/24 09:55
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0   // 当前元素
                    && (i == 0 || flowerbed[i - 1] == 0) // 起始元素或者前一个元素
                    && (i + 1 == len || flowerbed[i + 1] == 0)) { // 末尾元素或者后一个元素
                flowerbed[i] = 1; // 当前元素插花
                ans++;
            }

        }
        return ans >= n;
    }
}
