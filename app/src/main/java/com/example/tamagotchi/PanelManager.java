package com.example.tamagotchi;

import android.app.Activity;
import android.content.Context;

import com.example.tamagotchi.mvc1.Pnl1_Ctrl;
import com.example.tamagotchi.mvc1.Pnl1_View;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;
import com.example.tamagotchi.mvc2.Pnl2_View;
import com.example.tamagotchi.mvc3.Pnl3_Ctrl;
import com.example.tamagotchi.mvc3.Pnl3_Mdl;
import com.example.tamagotchi.mvc3.Pnl3_View;
import com.example.tamagotchi.tools.SoundPlay;

public class PanelManager {

    private static PanelManager instance = null;

    public static int pnl;

    private Pnl1_View view1;
    private Pnl2_View view2;
    private Pnl3_View view3;
    private Pnl1_Ctrl ctrl1;
    private Pnl2_Ctrl ctrl2;
    private Pnl3_Ctrl ctrl3;
    private Pnl2_Mdl mdl2;
    private Pnl3_Mdl mdl3;

    private SoundPlay soundPlay;

    public Activity refAct;

    private PanelManager(Context context){
        pnl= -1;

        ctrl1= new Pnl1_Ctrl();
        view1= new Pnl1_View(context);

        mdl2= new Pnl2_Mdl();
        ctrl2= new Pnl2_Ctrl();
        view2= new Pnl2_View(context);

        mdl3= new Pnl3_Mdl();
        ctrl3= new Pnl3_Ctrl();
        view3= new Pnl3_View(context);

        soundPlay= new SoundPlay(context);

        view1.setRefCtrl(ctrl1);
        ctrl1.refPanelManager = this;

        view2.refMdl = mdl2;
        ctrl2.refMdl = mdl2;
        view2.setRefCtrl(ctrl2);
        ctrl2.refPanelManager = this;

        view3.refMdl = mdl3;
        ctrl3.refMdl = mdl3;
        view3.setRefCtrl(ctrl3);
        ctrl3.refPanelManager = this;

        mdl2.addObserver(view2);
        mdl2.addObserver(soundPlay);
        mdl3.addObserver(view3);

        refAct = (Activity)context;
    }

    public static PanelManager getInstance(Context context){
        if(instance == null){
            instance = new PanelManager(context);
        }
        return instance;
    }

    public void setPanel(int p){
        if(p == 1 && pnl != 1){
            refAct.setContentView(view1);
            pnl = 1;
        }

        if(p == 2 && pnl != 2){
            refAct.setContentView(view2);
            pnl = 2;
        }

        if(p == 3 && pnl != 3){
            refAct.setContentView(view3);
            pnl = 3;
        }
    }

    public Pnl2_Mdl getTamagotchi(){
        return mdl2;
    }
    public Pnl3_Mdl getConfig() { return mdl3; }
    public static int getPnl() { return pnl; }
}
