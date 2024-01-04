package org.ex.leetcode.set.intersectionoftwoarrays349;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: Intersection of Two Arrays
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 * <p>
 * xample 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * <p>
 * 思路一  两个集合
 * <p>
 * 使用数组
 * 计算两个数组的交集，直观的方法是遍历数组 nums1，对于其中的每个元素，遍历数组 nums2 判断该元素是否在数组 nums2 中，
 * 如果存在，则将该元素添加到返回值。假设数组 nums1 和 nums2 的长度分别是 m 和 n，
 * 则遍历数组 nums1 需要 O(m) 的时间，判断 nums1 中的每个元素是否在数组 nums2 中需要 O(n) 的时间，
 * 因此总时间复杂度是 O(m * n)。
 * <p>
 * 使用集合
 * 如果使用哈希集合存储元素，则可以在 O(1) 的时间内判断一个元素是否在集合中，从而降低时间复杂度。
 * 首先使用两个集合分别存储两个数组中的元素，然后遍历较小的集合，判断其中的每个元素是否在另一个集合中，
 * 如果元素也在另一个集合中，则将该元素添加到返回值。该方法的时间复杂度可以降低到 O(m + n)
 * <p>
 *
 * 复杂度分析
 *
 * 时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。
 * 使用两个集合分别存储两个数组中的元素需要 O(m+n) 的时间，
 * 遍历较小的集合并判断元素是否在另一个集合中需要 O(min(m,n)) 的时间，因此总时间复杂度是 O(m+n)。
 *
 * 空间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。空间复杂度主要取决于两个集合。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays/solutions/469445/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays/solutions/469445/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: Leif
 * @date: 2024/1/4 16:00
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        return getIntersection(set1, set2);
    }


    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size() > set2.size()){
            // 使用元素数量少的集合
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        // 遍历元素数量少的集合，降低时间复杂度
        for (int num : set1){
            if (set2.contains(num)){
                intersectionSet.add(num);
            }
        }
        // 声明结果数组
        int[] intersectionArray = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet){
            intersectionArray[index++] = num;
        }

        return intersectionArray;

    }


}
