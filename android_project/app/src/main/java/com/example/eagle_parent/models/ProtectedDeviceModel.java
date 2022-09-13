package com.example.eagle_parent.models;

public class ProtectedDeviceModel {
    private String title;
    private String ScreenTime;
    private String blockAlerts;
    private String reviewedAlerts;
    private String activitiesCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScreenTime() {
        return ScreenTime;
    }

    public void setScreenTime(String screenTime) {
        ScreenTime = screenTime;
    }

    public String getBlockAlerts() {
        return blockAlerts;
    }

    public void setBlockAlerts(String blockAlerts) {
        this.blockAlerts = blockAlerts;
    }

    public String getReviewedAlerts() {
        return reviewedAlerts;
    }

    public void setReviewedAlerts(String reviewedAlerts) {
        this.reviewedAlerts = reviewedAlerts;
    }

    public String getActivitiesCount() {
        return activitiesCount;
    }

    public void setActivitiesCount(String activitiesCount) {
        this.activitiesCount = activitiesCount;
    }
}
