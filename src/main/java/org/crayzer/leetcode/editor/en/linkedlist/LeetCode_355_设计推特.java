package org.crayzer.leetcode.editor.en.linkedlist;

import java.util.*;

public class LeetCode_355_设计推特 {

    class Tweet {
        private int id;
        private int timeStamp;
        private Tweet next;

        public Tweet(int id, int timeStamp) {
            this.id = id;
            this.timeStamp = timeStamp;
        }
    }
    /**用户 id 和推文（单链表）的对应关系*/
    private Map<Integer, Tweet> twitter;
    /**用户 id 和他关注的用户列表的对应关系*/
    private Map<Integer, HashSet<Integer>> followees;
    /**全局使用的时间戳字段，用户每发布一条推文之前 + 1*/
    private int timeStamp;

    /** Initialize your data structure here. */
    public LeetCode_355_设计推特() {
        this.twitter = new HashMap<>();
        this.followees = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet temp = new Tweet(tweetId, timeStamp++);
        Tweet head = twitter.get(userId);
        temp.next = head;
        head = temp;
        twitter.put(userId, head);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
     * be posted by users who the user followed or by the user herself. Tweets must be ordered from
     * most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Tweet> tweets = new ArrayList<>();

        if (twitter.containsKey(userId)) tweets.add(twitter.get(userId));
        HashSet<Integer> followeeIds = followees.get(userId);

        if (followeeIds != null) {
            for (Integer followeeId : followeeIds) {
                if (twitter.containsKey(followeeId)) {
                    tweets.add(twitter.get(followeeId));
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < tweets.size(); j++) {
                Tweet temp = tweets.get(j);
                if (temp == null) continue;
                if (temp.timeStamp > max) {
                    max = temp.timeStamp;
                    maxIndex = j;
                }
            }
            if (maxIndex >= 0) {
                res.add(tweets.get(maxIndex).id);
                tweets.set(maxIndex, tweets.get(maxIndex).next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op.
     *  @param followerId 发起关注者 id
     *  @param followeeId 被关注者 id
     * */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        HashSet<Integer> followeeIds = followees.get(followerId);
        if (followeeIds == null) {
            followeeIds = new HashSet<>();
            followees.put(followerId, followeeIds);
        }
        followeeIds.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeIds=followees.get(followerId);
        if(followeeIds==null) return;
        followeeIds.remove(followeeId);
    }

    public static void main(String[] args) {
        LeetCode_355_设计推特 twitter = new LeetCode_355_设计推特();
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

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
