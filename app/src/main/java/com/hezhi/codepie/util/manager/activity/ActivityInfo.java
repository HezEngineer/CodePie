package com.hezhi.codepie.util.manager.activity;
import com.hezhi.kiss.base.BaseActivity;

public class ActivityInfo {
    private String activityId = "";
    private BaseActivity activityContent = null;

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
