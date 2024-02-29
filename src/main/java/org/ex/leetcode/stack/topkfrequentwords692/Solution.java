package org.ex.leetcode.stack.topkfrequentwords692;

import java.util.*;

/**
 * @desc: Top K Frequent Words
 *
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 *
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 *
 * 思路 小根堆
 *
 * @author: Leif
 * @date: 2024/2/29 11:05
 */
public class Solution {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        // 统计字频
        for (String word : words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // 创建优先队列作为小根堆
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (freq.get(s1).equals(freq.get(s2))) {
                    // 如果词频相同，根据字典序倒序
                    return s2.compareTo(s1);
                } else {
                    // 如果词频不同，根据词频升序
                    return freq.get(s1) - freq.get(s2);
                }
            }
        });

        // 遍历入堆
        for (String word : freq.keySet()){
            pq.offer(word);
            if (pq.size() > k) {
                // 当堆中元素个数大于 k 个的时候，需要弹出堆顶最小的元素。
                pq.poll();
            }
        }

        // 遍历大顶堆输出结果
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        // 从小到大输出
        Collections.reverse(res);

        return res;

    }

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
//        String[] words = {"i","love","leetcode","i","love","coding"};
//        int k = 2;
        System.out.println(topKFrequent(words, k));
    }


}
