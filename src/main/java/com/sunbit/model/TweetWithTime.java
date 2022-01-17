package com.sunbit.model;

import java.time.LocalTime;

public class TweetWithTime implements Comparable<TweetWithTime> {
    private final LocalTime time;
    private final int tweet;

    public TweetWithTime(int tweet) {
        this.time = LocalTime.now();
        this.tweet = tweet;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public LocalTime gAetTime() {
        return time;
    }

    public int getTweet() {
        return tweet;
    }

    //The compereTo is multiple by (-1), so the sort is opposite (= newest to older)
    //so the newest will be at the begin of the list

    @Override
    public int compareTo(TweetWithTime tweetWithTime) {
        return -1 * (this.time.compareTo(tweetWithTime.gAetTime()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TweetWithTime that = (TweetWithTime) o;

        if (tweet != that.tweet) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public String toString() {
        return "TweetWithTime{" +
                "time=" + time +
                ", tweet=" + tweet +
                '}';
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + tweet;
        return result;
    }
}
