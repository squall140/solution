package org.ex.leetcode.advance.greedy.jumpgame055;

import java.util.HashMap;

/**
 * @desc: Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * 思路 贪心
 *
 * 其实跳几步无所谓，关键在于可跳的覆盖范围！
 * 那么这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！
 * 每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
 * 贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），
 * 整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
 *
 * https://leetcode.cn/problems/jump-game/solutions/2566732/dai-ma-sui-xiang-lu-leetcode55tiao-yue-y-yels/
 *
 * @author: Leif
 * @date: 2024/1/31 10:01
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 如果只有一个元素，即便是0，也一定能跳过去
        if (n == 1) return true;
        int coverRange = 0;

        for (int i = 0; i <= coverRange; i++ ){
            // 这里的 i + nums[i] 代表当前元素可以跳到到最远距离
            // 只要一直遍历，找出某个元素所能达到的最远距离是否 >=n - 1，这个问题就结束了
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= n - 1) return true;
        }

        return false;
    }

}
