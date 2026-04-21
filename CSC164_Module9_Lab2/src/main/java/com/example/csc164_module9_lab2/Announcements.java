package com.example.csc164_module9_lab2;

public class Announcements {
    private String date;
    private String title;
    private String from;

    // Constructor
    public Announcements(String date, String title, String from) {
        this.date = date;
        this.title = title;
        this.from = from;
    }

    // Getters
    public String getDate() {
        return date;
    }
    public String getTitle() {
        return title;
    }
    public String getFrom() {
        return from;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setFrom(String from) {
        this.from = from;
    }
}
