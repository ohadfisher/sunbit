package com.sunbit;

import com.sunbit.service.Twitter;

public class Application {

    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(1, 10);//10
        twitter.postTweet(1, 11);//9
        twitter.postTweet(1, 12);//8
        twitter.postTweet(1, 13);//7
        twitter.postTweet(1, 14);//6
        twitter.postTweet(1, 15);//5
        twitter.postTweet(1, 16);//4
        twitter.postTweet(1, 17);//3
        twitter.postTweet(1, 18);//2
        twitter.postTweet(1, 19);//1

// User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));

// User 1 follows user 2.
        twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));

// User 1 unfollows user 2.
        twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));

    }
}
