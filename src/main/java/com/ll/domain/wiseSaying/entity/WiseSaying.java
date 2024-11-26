package com.ll.domain.wiseSaying.entity;

public class WiseSaying {
    private int id;
    private String quotes;
    private String author;

    public WiseSaying(int id, String quotes, String author) {
        this.id = id;
        this.quotes = quotes;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getQuotes() {
        return quotes;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
