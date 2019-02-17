package com.cytech.api;

import java.io.Serializable;

/**
 * POJO for Books Data
 */
public class Books implements Serializable {
    public String title;
    public String author;
    public String publisher;


    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
}
