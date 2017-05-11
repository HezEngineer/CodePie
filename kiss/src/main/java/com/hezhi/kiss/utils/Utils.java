package com.hezhi.kiss.utils;

import java.io.File;
import java.io.IOException;

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
}
