package com.bobby.peng.learning.java.leetcode;

import java.util.*;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class Twitter {

    //todo test and do better

    private static final int TIMELINE_LENGTH = 10;

    class TweetTimelineInfo {

        class TweetInfo {
            int tweetId;
            long timeStamp;

            public TweetInfo(int tweetId, long timeStamp) {
                this.tweetId = tweetId;
                this.timeStamp = timeStamp;
            }
        }

        class TweetNode {
            TweetInfo tweetInfo;

            TweetNode next;

            public TweetNode(int tweetId, TweetNode next) {
                tweetInfo = new TweetInfo(tweetId, System.currentTimeMillis());
                this.next = next;
            }

            public TweetNode(TweetInfo tweetInfo, TweetNode next) {
                this.tweetInfo = tweetInfo;
                this.next = next;
            }

            public TweetNode cloneNodeWithoutNext() {
                return new TweetNode(new TweetInfo(tweetInfo.tweetId, tweetInfo.timeStamp), null);
            }
        }

        private int userId;

        private boolean resultFlag;

        private List<Integer> result;

        private TweetNode head;

        private int currentSize;

        public TweetTimelineInfo(int userId) {
            this.userId = userId;
            resultFlag = false;
            result = new ArrayList<>();
        }

        public void addNewTweet(int tweetId) {
            if (currentSize < TIMELINE_LENGTH) {
                currentSize++;
            }

            TweetNode tweetNode = new TweetNode(tweetId, head);
            head = tweetNode;
            resultFlag = false;
        }

        private List<Integer> getResult() {
            if (resultFlag == true) {
                return result;
            } else {
                result.clear();
                TweetNode temp = head;
                for (int i = 0; i < TIMELINE_LENGTH; i++) {
                    if (temp == null) break;
                    result.add(temp.tweetInfo.tweetId);
                    if (i == TIMELINE_LENGTH - 1) {
                        temp.next = null;
                        break;
                    }
                    temp = temp.next;
                }
            }
            return result;
        }

        public void followedUser(int followeeId) {
            TweetTimelineInfo tweetTimelineInfo = userMap.get(followeeId);

            TweetNode tweetNode1 = tweetTimelineInfo.head;
            TweetNode tweetNode2 = head;
            head = mergeTwoLinkedList(tweetNode1, tweetNode2);

            resultFlag = false;
        }

        public void reset() {
            UserInfo userInfo = followerMap.get(userId);
            Iterator<Integer> iterator = userInfo.userSet.iterator();
            TweetNode last = null;
            while (iterator.hasNext()) {
                last = mergeTwoLinkedList(last, userMap.get(iterator.next()).head);
            }

            resultFlag = false;
        }

        private TweetNode mergeTwoLinkedList(TweetNode tweetNode1, TweetNode tweetNode2) {
            TweetNode head = null;
            TweetNode lastNode = null;
            for (int i = 0; i < TIMELINE_LENGTH; i++) {
                TweetNode temp;
                if (tweetNode1 == null && tweetNode2 == null) {
                    break;
                } else if (tweetNode1 == null) {
                    temp = tweetNode2.cloneNodeWithoutNext();
                    tweetNode2 = tweetNode2.next;
                } else if (tweetNode2 == null) {
                    temp = tweetNode1.cloneNodeWithoutNext();
                    tweetNode1 = tweetNode1.next;
                } else if (tweetNode1.tweetInfo.timeStamp > tweetNode2.tweetInfo.timeStamp) {
                    temp = tweetNode1.cloneNodeWithoutNext();
                    tweetNode1 = tweetNode1.next;
                } else {
                    temp = tweetNode2.cloneNodeWithoutNext();
                    tweetNode2 = tweetNode2.next;
                }
                if (i == 0) {
                    head = temp;
                } else {
                    lastNode.next = temp;
                }
                lastNode = temp;
            }
            return head;
        }
    }

    class UserInfo {
        public UserInfo(Set<Integer> userSet) {
            this.userSet = userSet;
        }

        Set<Integer> userSet;
    }

    //to save the sweet which user posts
    private Map<Integer, TweetTimelineInfo> userMap;

    //to save the sweet which user posts and followed
    private Map<Integer, TweetTimelineInfo> timeLineMap;

    //user who followed someone
    private Map<Integer, UserInfo> followerMap;

    //user who has some followers
    private Map<Integer, UserInfo> followeeMap;


    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
        timeLineMap = new HashMap<>();
        followerMap = new HashMap<>();
        followeeMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        userMap.get(userId).addNewTweet(tweetId);

        UserInfo followers = followeeMap.get(userId);

        for (Integer followerId : followers.userSet) {
            timeLineMap.get(followerId).addNewTweet(tweetId);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        return timeLineMap.get(userId).getResult();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        UserInfo followees = followerMap.get(followerId);
        if (followees == null) {
            followees = new UserInfo(new HashSet<>());
        }
        if (followees.userSet.contains(followeeId)) {
            return;
        }
        followees.userSet.add(followeeId);

        UserInfo followers = followeeMap.get(followeeId);
        if (followers == null) {
            followers = new UserInfo(new HashSet<>());
        }
        followers.userSet.add(followerId);

        TweetTimelineInfo tweetTimelineInfo = timeLineMap.get(followerId);
        if (tweetTimelineInfo == null) {
            tweetTimelineInfo = new TweetTimelineInfo(followerId);
        }
        tweetTimelineInfo.followedUser(followeeId);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        UserInfo followees = followerMap.get(followerId);
        followees.userSet.remove(followeeId);

        UserInfo followers = followeeMap.get(followeeId);
        followers.userSet.remove(followerId);

        TweetTimelineInfo tweetTimelineInfo = timeLineMap.get(followerId);
        if (tweetTimelineInfo != null) {
            tweetTimelineInfo.reset();
        }
    }

}
