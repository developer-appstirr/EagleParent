package com.example.eagle_parent.models;

public class AlertModel {
    private String appName;
    private int appLogo;
    private String date;
    private String severityLevel;
    private int offenderImg;
    private String offenderName;
    private String offenderDescription;
    private String offenderLink;
    private boolean wifiOn;
    private boolean blockApp;
    private String threatCategory;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(int appLogo) {
        this.appLogo = appLogo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public int getOffenderImg() {
        return offenderImg;
    }

    public void setOffenderImg(int offenderImg) {
        this.offenderImg = offenderImg;
    }

    public String getOffenderName() {
        return offenderName;
    }

    public void setOffenderName(String offenderName) {
        this.offenderName = offenderName;
    }

    public String getOffenderDescription() {
        return offenderDescription;
    }

    public void setOffenderDescription(String offenderDescription) {
        this.offenderDescription = offenderDescription;
    }

    public String getOffenderLink() {
        return offenderLink;
    }

    public void setOffenderLink(String offenderLink) {
        this.offenderLink = offenderLink;
    }

    public boolean isWifiOn() {
        return wifiOn;
    }

    public void setWifiOn(boolean wifiOn) {
        this.wifiOn = wifiOn;
    }

    public boolean isBlockApp() {
        return blockApp;
    }

    public void setBlockApp(boolean blockApp) {
        this.blockApp = blockApp;
    }

    public String getThreatCategory() {
        return threatCategory;
    }

    public void setThreatCategory(String threatCategory) {
        this.threatCategory = threatCategory;
    }
}
