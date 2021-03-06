package edu.byu.cs.tweeter.model.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Tweet implements  Comparable<Tweet>, Serializable {

    private User author;
    private String content;
    private long date;

    private Tweet() {}

    public Tweet(User author, String content) {
        this.author = author;
        this.content = content;
        this.date = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public Tweet(User author, String content, long date) {
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public User getAuthor() { return author; }

    public String getContent() { return content; }

    public long getDate() {
        return date;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return content.equals(tweet.content) && author.equals(tweet.author) && date == tweet.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, content, date);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "author='" + author.toString() +
                "', content='" + content +
                "', date=" + date + "'}";
    }

    @Override
    public int compareTo(Tweet tweet) {
        Timestamp date1 = new Timestamp(this.getDate());
        Timestamp date2 = new Timestamp(tweet.getDate());
        return date1.compareTo(date2);
    }
}
