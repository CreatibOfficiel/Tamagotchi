package com.example.tamagotchi.controllers;

import android.provider.Settings;
import android.view.View;

import com.example.tamagotchi.PanelManager;
import com.example.tamagotchi.R;

public class Pnl1_Ctrl implements View.OnClickListener{

    public PanelManager refPanelManager;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonGoConfigHome){
            refPanelManager.setPanel(3);
        }
        else if(v.getId() == R.id.buttonGoGameHome){
            refPanelManager.setPanel(2);
        }
    }
}
