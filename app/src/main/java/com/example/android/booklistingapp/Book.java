package com.example.android.booklistingapp;

/**
 * Created by 1 on 03.05.2017.
 */

public class Book {
    private String mAuthor;
    private String mTitle;

    public Book(String Author, String Title) {
        this.mAuthor = Author;
        this.mTitle = Title;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmTitle() {
        return mTitle;
    }
}
