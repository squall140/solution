package org.ex.leetcode.top100.heap.designtwitterfeed355;

import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/17 16:29
 */
public class Solution {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);

        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);

    }


}
