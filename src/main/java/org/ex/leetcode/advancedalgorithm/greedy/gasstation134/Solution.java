package org.ex.leetcode.advancedalgorithm.greedy.gasstation134;

/**
 * @desc: Gas Station
 * <p>
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * <p>
 * 思路 贪心法
 * <p>
 * 看b站 Karl视频，白板画图比较细致
 * @author: Leif
 * @date: 2024/1/30 16:58
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curRemain = 0;
        int totalRemain = 0;
        // 起点（答案）
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            // 累计当前里程剩余油量
            curRemain += gas[i] - cost[i];
            // 总剩余油量
            totalRemain += gas[i] - cost[i];
            // 如果从当前i索引的加油站开始不够跑到下一个i+1的加油站的时候
            if (curRemain < 0) {
                // 只能尝试从第 i + 1个加油站重新开始 ，因为是环形，所以取模来计算下一个油站的位置
                // 如果想不到为什么要取模，就想想哈希环一致性的道理
                start = (i + 1) % gas.length;
                curRemain = 0;
            }
        }

        // return totalRemain < 0 ? -1 : start;
        if (totalRemain < 0) return -1;
        return start;

    }
}
