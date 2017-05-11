package com.hezhi.kiss.http.okhttp.response;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.hezhi.kiss.http.okhttp.Exception.HttpException;
import com.hezhi.kiss.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by yf11 on 2017/5/3.
 */

public class FileCallback implements Callback {

    private static final int PROGRESS_MESSAGE = 0x01;


    //错误信息
    public final String ERROR_EMPTY = "";

    //错误码
    public final String NET_ERROR = "-1";
    public final String IO_ERROR = "-2";


    private DisposeProgressListener listener;
    private Handler deleveryHandler ;
    private String filePath;
    private int progress;

    public FileCallback() {

    }

    public FileCallback(DisposeDataHandle handle) {
        listener = handle.progressListener;
        filePath = handle.filePath;
        deleveryHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case PROGRESS_MESSAGE:
                        listener.onProgress((int) msg.obj);
                        break;
                }
            }
        };
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        deleveryHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFail(new HttpException(NET_ERROR,e));
            }
        });

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final File file = handleResponse(response);
        deleveryHandler.post(new Runnable() {
            @Override
            public void run() {
                if(file!=null) {
                    listener.onSuccess(file);
                } else {
                    listener.onFail(new HttpException(IO_ERROR,file));
                }
            }
        });
    }

    private File handleResponse(Response response) {
        if(response == null) {
            return null;
        }
        File file =null;
        InputStream in = null;
        FileOutputStream out = null;
        byte[] buffer = new byte[2048];
        int length ;
        int currentLength = 0;
        long sumLen;
        try {
            file = Utils.checkLocalFilePath(filePath);
            out = new FileOutputStream(file);
            in = response.body().byteStream();
            sumLen = response.body().contentLength();
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer,0,length);
                currentLength += length;
                progress = (int)(currentLength / sumLen * 100);
                deleveryHandler.obtainMessage(PROGRESS_MESSAGE,progress).sendToTarget();
            }
            out.flush();
        }catch (Exception e) {
            file = null;
        } finally {
            try {
                if(out != null) {
                    out.close();
                }
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  file;
    }
}
