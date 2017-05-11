package com.hezhi.kiss.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by yf11 on 2017/5/11.
 */

public class PermissionUtil {

    public static class Constant{
        public static final int CAMERA_CODE = 0X01;
    }


    /**
     * 是否有权限
     * @param context
     * @param permission
     * @return
     */
    public static boolean hasPermission(Activity context,String permission) {
        if(ActivityCompat.checkSelfPermission(context,permission) == PackageManager.PERMISSION_GRANTED ){
            return true;

        }
        return false;
    }

    /**
     * 申请权限
     * @param activity
     * @param permissions
     * @param requestCode
     */
    public static void requestPermisson(Activity activity,int requestCode,String... permissions){
        ActivityCompat.requestPermissions(activity,permissions,requestCode);
    }

    /**
     * Check that all given permissions have been granted by verifying that each entry in the
     * given array is of the value {@link PackageManager#PERMISSION_GRANTED}.
     *
     * @see Activity#onRequestPermissionsResult(int, String[], int[])
     */
    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if(grantResults.length < 1){
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


}
