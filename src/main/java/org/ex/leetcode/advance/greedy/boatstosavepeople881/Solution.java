package org.ex.leetcode.advance.greedy.boatstosavepeople881;

import java.util.Arrays;


/**
 * @desc: Boats To Save People
 *
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 *
 * Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 *
 * <p>
 *
 * Example 1:
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 *
 * Example 2:
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 *
 * Example 3:
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 *
 * </p>
 *
 * 思路  贪心
 *
 * 题目中说“返回承载所有人所需的最小船数”，那么也就是可以理解为，一条船在不过载的前提下都做2人就是最好的（贪心）。
 *
 *
 * @author: Leif
 * @date: 2024/1/30 14:49
 */
public class Solution {
    public static int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int ans = 0;

        // 先排序，降低遍历复杂度，假设limit = 3，那么people数组超过2的元素，都只能每人1条船
        // 同时也是一种贪心策略，先遍历people更小更轻的元素，也就是让一条船尽量多承载更多的人
        Arrays.sort(people);
        // 双指针遍历
        int left = 0, right = n - 1;
        while ( left <= right){
            // 每艘船最多可同时载两人
            if (people[left] + people[right] <= limit){
                ans++;
                // 左指针右移, 右指针左移
                left++;
                right--;
            }else{
                ans++;
                right--;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));

    }


}
