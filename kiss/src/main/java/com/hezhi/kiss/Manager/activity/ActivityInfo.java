package com.hezhi.kiss.Manager.activity;


import com.hezhi.kiss.base.BaseActivity;

public class ActivityInfo {
    private String activityId = "";
    private BaseActivity activityContent = null;

    public ActivityInfo(String activityId, BaseActivity activityContent) {
        this.activityId = activityId;
        this.activityContent = activityContent;
    }

    public String getActivityId() {
        return activityId;
    }

    public BaseActivity getActivityContent() {
        return activityContent;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public void setActivityContent(BaseActivity activityContent) {
        this.activityContent = activityContent;
    }
}
