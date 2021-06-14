package com.example.tamagotchi.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;
import com.example.tamagotchi.controllers.Pnl1_Ctrl;

import java.util.Observable;
import java.util.Observer;

public class Pnl1_View extends LinearLayout implements Observer {

    public Pnl1_Ctrl refCtrl;
    public Button btnGoToGame;
    public Button btnGoToConfig;

    public Pnl1_View(Context context) {
        super(context);

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.activity_main, this);

        btnGoToConfig = (Button)findViewById(R.id.buttonGoConfigHome);
        btnGoToGame = (Button)findViewById(R.id.buttonGoGameHome);
    }

    public void setRefCtrl(Pnl1_Ctrl c){
        refCtrl = c;
        btnGoToConfig.setOnClickListener(refCtrl);
        btnGoToGame.setOnClickListener(refCtrl);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
