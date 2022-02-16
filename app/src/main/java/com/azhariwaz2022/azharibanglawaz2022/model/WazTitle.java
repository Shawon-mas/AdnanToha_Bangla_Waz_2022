package com.azhariwaz2022.azharibanglawaz2022.model;

public class WazTitle {
    private String title;
    private String videoId;
    public WazTitle()
    {

    }
    public WazTitle(String title, String videoId) {
        this.title = title;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
