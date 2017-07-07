package com.hezhi.kiss.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by yf11 on 2017/5/4.
 */

public class Utils {

    /**
     *  检查文件存在
     * @param localFilePath
     * @return
     */
    public static File checkLocalFilePath(String localFilePath) {

        File file = new File(localFilePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 将输入流转换为字符串
     * @param ins
     * @return
     */
    public static String insToString(InputStream ins) {
        InputStreamReader isr ;
        BufferedReader br ;
        StringBuffer sb ;
        String s ;
        isr = new InputStreamReader(ins);
        br = new BufferedReader(isr);
        sb = new StringBuffer();
        try {
            while((s=br.readLine()) != null){
                sb.append(s);
            }
            System.out.println("sb ==== [" + sb.toString() + "]");

            if (br != null) {
                br.close();
                isr.close();
                ins.close();
            }
        } catch (IOException e) {

        }
        return sb.toString();
    }


    /**
     * 将输入流转换为字符串
     * @param ins
     * @return
     */
    public static String insToString2(InputStream ins) {

        byte[] b = new byte[2048];
        StringBuffer sb = new StringBuffer();
        String s;
        try {
            while (ins.read(b) != -1) {
                s= new String(b);
                sb.append(s);
            }
            if (ins != null) {
                ins.close();
            }
        } catch (IOException e) {

        }
        return sb.toString();
    }


    /**
     *
     * 根据资源名称返回资源ID;
     * @param name
     * @param context
     * @return 0;没找到资源
     */
    public static int getResIdByName(String name, Context context) {
        if("".equalsIgnoreCase(name)) {
            return 0;
        }
        return context.getResources().getIdentifier(name,"drawable",context.getPackageName());
    }
}
