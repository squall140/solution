package org.ex.leetcode.advancedalgorithm.greedy.assigncookies455;

import java.util.Arrays;

/**
 * @desc: Assign Cookies
 *
 * Assume you are an awesome parent and want to give your children some cookes.
 * But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that
 * the child will be content with; and each cookie j has a size s[j].
 *
 * If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Example 1:
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 *
 * 思路 贪心算法
 *
 * 根据题意,每个小孩只能分到一个饼干,并且每个小孩都有对应的一个最小胃口值;
 * 可以得出这是一道很经典的排序+贪心算法题,双指针可以用来优化时间复杂度
 *
 * 1. 我们将小孩的满足度数组和饼干尺寸数组进行升序排序
 * 2. 以小孩g满足度数组为最外层遍历,并找到是否有能满足本次遍历到的小孩的饼干(题解中的while循环逻辑即是)
 * 3. 因为步骤1中已经对两个数组进行升序排序,那么即可以用一个left指针来记录饼干已经用到了哪一个，
 *    因为是升序排序所以不可能存在之前一个小孩先用的是后面的饼干这种情况,以此来优化时间复杂度
 *
 *
 * 作者：石楠烟斗的雾
 * 链接：https://leetcode.cn/problems/assign-cookies/solutions/2606967/chao-guo-9987chao-jian-dan-yi-kan-jiu-hu-t7vb/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/24 14:48
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 先排序从小到大
        Arrays.sort(g);
        Arrays.sort(s);

        int lg = g.length;
        int ls = s.length;
        int ans = 0;
        int left = 0;

        // 双指针遍历，外循环是孩子数量
        for (int i = 0; i < lg; i++){
            // 内循环是孩子的胃口值
            while (left < ls){
                // 从左到右遍历，为了最大化满足更多的孩子，
                // 如果当前的胃口值满足最小的孩子数量，那么就是答案，满足贪心策略
                if (g[i] <= s[left]){
                    ans++;
                    left++;
                    break;
                }else{
                    left++;
                }
            }
        }

        return ans;
    }
}
