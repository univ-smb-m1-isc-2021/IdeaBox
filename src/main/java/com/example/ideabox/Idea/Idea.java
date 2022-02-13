package com.example.ideabox.Idea;

public class Idea {

    private long id;
    private String content;
    private String userAgent; // android, Iphone, computer, ...


    // Constructor ---
    public Idea(){}

    public Idea(String content, String userAgent) {
        this.content = content;
        this.userAgent = userAgent;
    }

    public Idea(long id, String content, String userAgent) {
        this.id = id;
        this.content = content;
        this.userAgent = userAgent;
    }

    // Getters Setters ---
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    // Build in ---
    @Override
    public String toString() {
        return "Idea{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
