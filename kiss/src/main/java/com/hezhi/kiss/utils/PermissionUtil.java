package com.hezhi.kiss.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

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
            System.out.println("=====1111111111");
            return true;

        } else {
            if(!ActivityCompat.shouldShowRequestPermissionRationale(context,permission)){
                //弹个解释框
                System.out.println("=====222222222222");
                Toast.makeText(context, "请到设置中打开对应权限", Toast.LENGTH_LONG).show();
            }

        }
        System.out.println("=====333333333333");

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


}
