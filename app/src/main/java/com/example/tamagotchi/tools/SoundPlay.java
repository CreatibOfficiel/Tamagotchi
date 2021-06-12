package com.example.tamagotchi.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;

public class SoundPlay implements Observer {

    private final MediaPlayer mpWin;
    private final MediaPlayer mpFail;
    private final MediaPlayer mpBackground;

    public SoundPlay(Context context) {
        this.mpBackground = MediaPlayer.create(context, R.raw.background);
        mpBackground.setLooping(true);
        mpBackground.start();
        this.mpWin = MediaPlayer.create(context, R.raw.win);
        this.mpFail = MediaPlayer.create(context, R.raw.fail);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg != null){
            if(arg.equals("fail")){
                mpFail.start();
            }else if(arg.equals("win")){
                mpWin.start();
            }
        }
    }
}
