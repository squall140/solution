package org.ex.leetcode.top100.array.mergeintervals056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: Merge Intervals
 * 思路 合并区间
 *
 * 经验：区间类的问题，一般而言是需要画图思考的。(绝大部分都需要打草稿)
 *
 * 链表问题：穿针引线如果不画图容易把自己绕晕；
 * 回溯算法问题：根据示例画图发现每一步的选择和剪枝的条件
 * 动态规划问题：画示意图发现最优子结构。
 *
 *
 * 可以被合并的区间一定是有交集的区间，前提是区间按照左端点排好序，这里的交集可以是一个点
 * 接着说，直觉上，只需要对所有的区间按照左端点升序排序，然后遍历。
 * - 如果当前遍历到的区间的左端点 > 结果集中最后一个区间的右端点，说明它们没有交集，此时把区间添加到结果集；
 * - 如果当前遍历到的区间的左端点 <= 结果集中最后一个区间的右端点，说明它们有交集，此时产生合并操作，即：对结果集中最后一个区间的右端点更新（取两个区间的最大值）。
 *
 * 作者：liweiwei1419
 * 链接：https://leetcode.cn/problems/merge-intervals/solutions/204898/tan-xin-suan-fa-java-by-liweiwei1419-3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/3/28 11:05
 */
public class Solution {
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        // 区间排序，从小到大，按照左端点（主要是画图能想到）
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        // 先加入第一个区间，这里的res视为一个辅助数据结构来取最后一个值（前一个区间）
        res.add(intervals[0]);
        // 从第二个区间开始，对比区间
        for(int i = 1; i < n; i++){
            int[] curInterval = intervals[i];
            // 如果当前区间左端点大于上一个区间的右端点，那么一定不重合
            int[] lastInterval = res.get(res.size() - 1);
            if (curInterval[0] > lastInterval[1]) {
                res.add(intervals[i]);
            }else{
                // 如果当前区间左断点小于或等上一个区间的右断点，那么视为重合
                // 求出两个重叠区间的最大右断点
                // [注意点], 因为 lastInterval 是对象，表示的是一个内存地址，通过内存地址修改里面的值是可以的哦。
                // 引用数据类型，存储的是对象的引用  res.get(res.size() - 1) 和 peek[] 实际引用的是同一个对象 因此可以更新
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            }
        }
        // 这里是需要返回二维数组，所以要写成new int[0][]
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }


}
