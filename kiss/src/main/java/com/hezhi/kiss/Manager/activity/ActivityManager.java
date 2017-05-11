package com.hezhi.kiss.Manager.activity;


import com.hezhi.kiss.base.BaseActivity;

import java.util.LinkedList;

public class ActivityManager {
    /**
     * 视图栈
     */
    private static LinkedList<ActivityInfo> activities = new LinkedList<ActivityInfo>();

    public static LinkedList<ActivityInfo> getManagers() {
        return activities;
    }

    public static void setManagers(LinkedList<ActivityInfo> activities) {
        ActivityManager.activities = activities;
    }

    /**
     * 向视图栈中添加新的视图
     *
     * @param data 视图数据
     * @return 添加是否成功
     */
    public static boolean addNewActivity(ActivityInfo data) {
        if (data == null || data.getActivityId() == null
                || data.getActivityId().length() == 0) {
            return false;
        }
        activities.add(data);
        return true;
    }

    /**
     * 通过ID在视图栈中查找视图数据
     *
     * @param activityId 查找ID
     * @return 查找结果
     */
    private static ActivityInfo getDataByActivityId(String activityId) {
        if (activities != null) {
            for (int i = 0; i < activities.size(); i++) {
                ActivityInfo item = activities.get(i);
                if (activityId.equalsIgnoreCase(item.getActivityId())) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * 获取视图栈顶部视图数据
     *
     * @return 返回视图数据
     */
    public static ActivityInfo getTopInfo() {
        if (activities != null && activities.size() >= 1) {
            return activities.get(activities.size() - 1);
        }
        return null;
    }

    /**
     * 通过查找ID替换视图栈中指定视图的ID
     *
     * @param sourceId 原ID
     * @param destId   替换ID
     * @return 替换是否成功
     */
    public static boolean replaceActivityId(String sourceId, String destId) {
        if (activities != null) {
            for (int i = 0; i < activities.size(); i++) {
                ActivityInfo item = activities.get(i);
                if (sourceId.equalsIgnoreCase(item.getActivityId())) {
                    item.setActivityId(destId);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 通过视图对象替换视图栈中指定视图的ID
     *
     * @param baseActivity 待查找的视图对象
     * @param activityId   替换的ID
     * @return 更新ID是否成功
     */
    public static boolean updateActivityIdByBaseActivity(BaseActivity baseActivity, String activityId) {
        if (baseActivity == null || activityId == null || activityId.length() == 0) {
            return false;
        }
        for (int i = 0; i < activities.size(); i++) {
            ActivityInfo item = activities.get(i);
            if (item.getActivityContent() == baseActivity) {
                item.setActivityId(activityId);
                return true;
            }
        }
        return false;
    }

    /**
     * 视图栈出栈操作
     *
     * @param isrefresh 是否刷新
     */
    public static void popActivity(boolean isrefresh) {
        if (activities != null && activities.size() >= 1) {
            ActivityInfo item = activities.remove(activities.size() - 1);
            item.getActivityContent().finish();
            item = null;
            System.gc();
            if (isrefresh == true) {
                if (getTopInfo() != null && getTopInfo().getActivityContent() != null) {
                    getTopInfo().getActivityContent().refresh();
                }
            }
        }
    }

    /**
     * 出栈到指定ID的视图
     *
     * @param popActivityId 指定ID
     * @param isrefresh     是否刷新
     * @return 返回栈顶数据
     */
    public static ActivityInfo popToActivityById(String popActivityId, boolean isrefresh) {
        if (getDataByActivityId(popActivityId) != null) {
            LinkedList<ActivityInfo> delList = new LinkedList<ActivityInfo>();
            for (int i = activities.size() - 1; i >= 0; i--) {
                ActivityInfo item = activities.get(i);
                if (item.getActivityId().equals(popActivityId) == false) {
                    item.getActivityContent().finish();
                    delList.add(item);
                } else {
                    activities.removeAll(delList);
                    if (isrefresh == true) {
                        if (item != null && item.getActivityContent() != null) {
                            item.getActivityContent().refresh();
                        }
                    }
                    return item;
                }
            }
            activities.removeAll(delList);
        }
        return null;
    }

    public static void clearActivity() {
        LinkedList<ActivityInfo> delList = new LinkedList<ActivityInfo>();
        for (int i = activities.size() - 1; i >= 0; i--) {
            ActivityInfo item = activities.get(i);
            item.getActivityContent().finish();
            delList.add(item);
        }
        activities.removeAll(delList);
    }
}
