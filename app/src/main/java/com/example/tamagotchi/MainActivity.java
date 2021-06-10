package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        PanelManager manager = PanelManager.getInstance(this);
        manager.setPanel(1);
    }
}
//Thib le plus grand bg
// Tu l'es aussi <3