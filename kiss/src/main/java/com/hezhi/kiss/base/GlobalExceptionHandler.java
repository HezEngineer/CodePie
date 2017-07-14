package com.hezhi.kiss.base;


/**
 * Created by yf11 on 2016/11/8.
 */
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private App application;

    public GlobalExceptionHandler(App application) {
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.application = application;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                ex.printStackTrace();
            }

            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        } else {
            ex.printStackTrace();
            new Thread() {
                @Override
                public void run() {

                }
            }.start();
            return true;
        }
    }
}
