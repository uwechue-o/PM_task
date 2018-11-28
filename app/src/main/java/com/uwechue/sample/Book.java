package com.uwechue.sample;

public class Book {
    private String title, author;
    private String imageURL;


    public Book(String title, String author, String imageurl) {
        this.title = title;
        this.author = author;
        this.imageURL = imageurl;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getImageURL() {
        return imageURL;
    }
}