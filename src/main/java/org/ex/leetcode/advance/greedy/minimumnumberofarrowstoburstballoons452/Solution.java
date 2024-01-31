package org.ex.leetcode.advance.greedy.minimumnumberofarrowstoburstballoons452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @desc: Minimum Number of Arrows to Burst Balloons
 *
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 *
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 *
 *
 * 思路 贪心算法，先排序
 *
 * 把气球跨度看成区间
 *
 * 当我们把每个区间按照右端点升序排序后，显然第一个区间就是我们最开始要找的第一个区间，后序也可以进一步找到满足条件的最小右端点区间。具体的过程如下：
 * 首先将区间按照右端点升序排序，此时位序为1的区间就是我们要找的第一个区间（图1），我们需要记录下第一个区间的右端点right（射出第一支箭），然后继续遍历，此时就会存在两种情况：
 * 对于左端点小于等于right的区间，说明该区间能被前面的箭（right）穿过。
 * 对于接下来左端点大于right的区间，说明前面这支箭无法穿过该区间（即：该区间就是未被箭穿过的区间集合的第一个区间），我们又找到了第一个未被箭穿过的区间，此时我们用一把新的箭穿过该区间的右端点（即更新right：right = points[i][1]），并将使用的箭数+1。如此往复。
 *
 *
 * 作者：ydnacyw
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/solutions/2539356/java-tan-xin-tu-jie-yi-dong-by-cao-yang-yjv4c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/24 19:53
 */
public class Solution {
    public int findMinArrowShots(int[][] points){
        if (points.length == 0 ) return 0;
        // 区间排序，即二维数组排序，按照最右侧端点，从小到大
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] > o2[1]){
//                    return 1;
//                }else if (o1[1] < o2[1]){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });

        // 区间排序，即二维数组排序，按照最右侧端点，从小到大
        Arrays.sort(points, (o1, o2) -> Long.compare(o1[1],o2[1]));
        int ans = 1;
        // 找到最小区间右端点
        // 第一支箭射出
        int arrow = points[0][1];
        for(int[] balloon : points){
            if(balloon[0] <= arrow){
                // 该区间可能可能被当前箭穿过
                continue;
            }
            arrow = balloon[1]; // 继续射出箭
            ans++;
        }
        return ans;
    }
}
