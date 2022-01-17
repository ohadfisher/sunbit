package com.sunbit.service;

import com.sunbit.model.TwitterUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {

    public static Map<Integer, TwitterUser> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        users = new HashMap();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        createUserIfNotExist(userId);
        users.get(userId).postTweet(tweetId);
    }


    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        createUserIfNotExist(userId);
        return users.get(userId).getNewsFeed();
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        users.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        createUserIfNotExist(followerId);
        createUserIfNotExist(followeeId);
        users.get(followerId).unfollow(followeeId);
    }


    private void createUserIfNotExist(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new TwitterUser(userId));
        }
    }


}
