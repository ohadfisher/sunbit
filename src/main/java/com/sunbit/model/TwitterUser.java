package com.sunbit.model;

import java.util.*;

import static com.sunbit.service.Twitter.users;

public class TwitterUser {
    private int userId;
    private Set<TweetWithTime> tweetsWithTime = new HashSet<>();
    private Set<Integer> iFollowThem = new HashSet();

    public TwitterUser(int userId) {
        this.userId = userId;
    }

    public Set<TweetWithTime> getTweetsWithTime() {
        return tweetsWithTime;
    }

    synchronized public void postTweet(int tweetId) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tweetsWithTime.add(new TweetWithTime(tweetId));
    }

    public void follow(int followeeId) {
        iFollowThem.add(followeeId);
    }

    public void unfollow(int followeeId) {
        if (iFollowThem.contains(followeeId)) {
            iFollowThem.remove(followeeId);
        }
    }

    public List<Integer> getNewsFeed() {
        List<Integer> result = new ArrayList<>();
        LinkedList<TweetWithTime> allTweetWithTime = new LinkedList<>();
        allTweetWithTime.addAll(tweetsWithTime);
        for (int followeeId : iFollowThem) {
            allTweetWithTime.addAll(users.get(followeeId).getTweetsWithTime());
        }
        allTweetWithTime.sort(TweetWithTime::compareTo);//The compereTo is sort opposite newest to older

        for (TweetWithTime tweetWithTime : allTweetWithTime) {
            result.add(tweetWithTime.getTweet());
            if (result.size() >= 10) {
                break;
            }
        }
        return result;

    }


}
