package org.ex.leetcode.top100.heap.designtwitterfeed355;

import java.util.*;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/7/17 16:29
 */
public class Twitter {
    /**
     * 用户 id 和 推文（单链表）的对应关系
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    /**
     * 合并 k 组推文使用的数据结构
     */
    private static PriorityQueue<Tweet> maxHeap;


    public Twitter(){
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2)-> -o1.timestamp + o2.timestamp);
    }

    /**
     * create a new tweet
     * @param userId
     * @param tweetId
     */
    public void postTweet(int userId, int tweetId){
        timestamp++;
        // 如果发推的用户存在，就直接更新该userId的推文列表
        Tweet newHead = new Tweet(tweetId, timestamp);
        if(twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            newHead.next = oldHead;
        }
        twitter.put(userId, newHead);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed
     * @param userId
     * @return
     */
    public List<Integer> getNewsFeed(int userId){
        // 由于是全局使用的，使用之前需清空
        maxHeap.clear();;

        // 如果是自己发了推文也得算上
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }

        // 其他人的feed更新也加入优先队列
        Set<Integer> followingList = followings.get(userId);
        if(followingList != null && followingList.size() > 0){
            for( Integer followingId : followingList){
                Tweet tweet = twitter.get(followingId);
                if (tweet != null){
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while(!maxHeap.isEmpty()){
            Tweet head = maxHeap.poll();
            res.add(head.id);

            // 这里最好操作应该是replace，但是Java 没有提供
            if(head.next != null) maxHeap.offer(head.next);
            count++;
        }

        return res;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * @param followerId
     * @param followeeId
     */
    public void follow(int followerId, int followeeId){
        // 被关注人不能是自己
        if(followerId == followerId) return;

        // 获取自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if(followingList == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        }else{
            if (followingList.contains(followerId)){
                return;
            }
            followingList.add(followeeId);
        }
    }

    /**
     * Follower unfollow a followee.
     * If the operation is invalid, it should be a no-op.
     *
     * @param followerId
     * @param followeeId
     */
    public void unfollow(int followerId, int followeeId){
        if(followeeId == followerId) return;

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        // 这里删除之前无需作判断，因为查找是否存在后，就可以删除
        if (followingList != null){
            followingList.remove(followeeId);
        }

    }

}
