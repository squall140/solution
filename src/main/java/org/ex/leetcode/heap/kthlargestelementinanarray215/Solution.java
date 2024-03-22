package org.ex.leetcode.heap.kthlargestelementinanarray215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc: Kth largest Element in an Array
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 思路 堆解法
 *
 * 可以先构造一个空间大小为k的堆
 * 再从nums[k+1]开始与堆顶元素比较
 * 如果nums[i] > heap则将当前堆顶元素出堆,并将nums[i]入堆
 * 这样遍历完数组后堆顶元素就是ans
 *
 * 这样的解法实际上时间复杂度是达不到O(n)的
 * 我们共执行了n轮入堆和出堆,堆的最大长度为k,入堆和出堆的时间复杂度为O(logk)
 * 所以整个算法的时间复杂度为O(nlogk)
 * 空间复杂度为O(k)->构造了一个大小为k的堆
 * 这个算法主要是用来理解堆这种数据结构
 * 如果要达到O(n)的时间复杂度和O(1)的空间复杂度,快排也许是最优解
 *
 * 时间复杂度: O(nlogk)
 * 空间复杂度: O(k)
 *
 *
 * 作者：杰瑞不想刷题
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/2559996/li-yong-dui-jie-jue-top-kwen-ti-by-kiski-1747/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * @author: Leif
 * @date: 2023/12/22 21:32
 */
public class Solution {
    public int findKthLargest(int[] nums, int k){
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<>();
        // 将数组前 k 个元素入堆
        for (int i = 0; i < k; i++){
            heap.offer(k);
        }
        // 从第 k + 1 个元素开始与堆顶元素进行比较
        // 若大于堆顶元素则将当前元素入堆，并将当前堆顶元素出堆
        // 保持堆堆长度为 k
        for (int i = k; i < nums.length; i++){
            if (nums[i] > heap.peek()) {
                // 堆顶元素出堆
                heap.poll();
                // 当前元素入堆
                heap.offer(nums[i]);
            }
        }

        // 返回堆顶元素，即第K个最大元素
        return heap.peek();
    }
}
