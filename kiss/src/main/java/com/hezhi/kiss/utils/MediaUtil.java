package com.hezhi.kiss.utils;

import android.app.Activity;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;

import com.hezhi.kiss.Model.media.AudioBean;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yf11 on 2017/5/12.
 */

public class MediaUtil {

    public static ArrayList<AudioBean> getAllAudios(Activity activity) {
        ArrayList<AudioBean> audioList = new ArrayList<>();
        AudioBean audio = null;
        String[] str = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE};
        Cursor cursor = activity.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                str,null,null,null);
        if(cursor!=null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                audio = new AudioBean();
                audio.setId(cursor.getString(0));
                audio.setName(cursor.getString(1));
                audio.setPath(cursor.getString(2));
                audio.setSize(cursor.getString(3));
                System.out.println("====audio id   " + audio.getId());
                System.out.println("====audio name   " + audio.getName());
                System.out.println("====audio path   " + audio.getPath());
                System.out.println("====audio size   " + audio.getSize());
                audioList.add(audio);
            }
            cursor.close();
        }

        return audioList;
    }

    public static MediaPlayer mediaPlayer = new MediaPlayer();

    public static void play(String path) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare(); // must call prepare first
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start(); // then start
    }

    public static void stop(String path) {
        mediaPlayer.stop();

    }


}
