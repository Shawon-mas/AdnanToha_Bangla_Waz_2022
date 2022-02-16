package com.azhariwaz2022.azharibanglawaz2022.model;

public class IslamLifeTitle {
    private String title;
    private String videoId;
    public IslamLifeTitle(){}
    public IslamLifeTitle(String title, String videoId) {
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
