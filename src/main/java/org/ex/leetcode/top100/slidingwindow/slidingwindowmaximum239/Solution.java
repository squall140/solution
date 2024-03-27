package org.ex.leetcode.top100.slidingwindow.slidingwindowmaximum239;

import java.util.*;

/**
 * @desc: Sliding Window Maximum
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 思路 单调队列
 *
 * 入（元素进入队尾，同时维护队列单调性）
 * 出（元素离开队首）
 * 记录/维护答案（根据队首）
 *
 * 时间复杂度 ：O(n)
 * 空间复杂度：O(min（k,U))  其中 U 是 nums 元素个数，
 *
 * https://leetcode.cn/problems/sliding-window-maximum/solutions/2499715/shi-pin-yi-ge-shi-pin-miao-dong-dan-diao-ezj6/?envType=study-plan-v2&envId=top-100-liked
 *
 *
 * @author: Leif
 * @date: 2024/3/26 14:31
 */
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n ; i++){
            // 1.保证从大到小 如果前面数小则需要依次弹出，直至满足要求， 维护队列单调性（单调递减）
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.removeLast();
            }
            // 1.入队，对尾（右侧）加入一个新元素
            queue.addLast(i);
            // 2.出队，当前队首（左侧）删除一个元素，队首已经离开窗口了，通过这里来维护窗口为k个元素大小
            if(i - queue.getFirst() >= k ){
                queue.removeFirst();
            }
            // 3.记录答案，遍历到最大下标时
            if(i >= k - 1){
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                res[i + 1 - k] = nums[queue.getFirst()];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Arrays.stream(maxSlidingWindow(nums, k)).forEach(System.out::print);
    }

}
