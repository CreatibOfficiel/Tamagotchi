package com.example.tamagotchi.mvc2;

import android.media.MediaPlayer;
import android.os.Debug;
import android.util.Log;
import android.view.View;

import com.example.tamagotchi.PanelManager;
import com.example.tamagotchi.R;

public class Pnl2_Ctrl implements View.OnClickListener {

    public PanelManager refPanelManager;
    public Pnl2_Mdl refMdl;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonGoHomeGame){
            refPanelManager.setPanel(1);
        }
        else if(v.getId() == R.id.buttonGoConfigGame){
            refPanelManager.setPanel(3);
        }
        else if(v.getId() == R.id.buttonWork){
            // travail
            refPanelManager.getTamagotchi().work();
        }
        else if(v.getId() == R.id.buttonInvest){
            // invest
            refPanelManager.getTamagotchi().invest();
        }
        else if(v.getId() == R.id.buttonSleep){
            // sleep
            refPanelManager.getTamagotchi().sleep();
        }
    }
}
