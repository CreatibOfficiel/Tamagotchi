package com.example.tamagotchi.mvc2;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;
import com.example.tamagotchi.etats.Etat;

import java.util.Observable;
import java.util.Observer;

public class Pnl2_View extends LinearLayout implements Observer {

    public Pnl2_Mdl refMdl;
    public Pnl2_Ctrl refCtrl;
    public Button btnGoToHome;
    public Button btnGoToConfig;
    public Button btnWork;
    public Button btnInvest;
    public Button btnSleep;
    public TextView textAction;
    public TextView argent;
    public TextView energy;
    public ImageView imageGame;

    public Pnl2_View(Context context) {
        super(context);

        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layount_pnl_tamagotchi, this);

        btnGoToConfig = (Button)findViewById(R.id.buttonGoConfigGame);
        btnGoToHome = (Button)findViewById(R.id.buttonGoHomeGame);
        btnWork = (Button)findViewById(R.id.buttonWork);
        btnInvest = (Button)findViewById(R.id.buttonInvest);
        btnSleep = (Button)findViewById(R.id.buttonSleep);
        textAction = (TextView)findViewById(R.id.messageAction);
        imageGame = (ImageView)findViewById(R.id.imageGame);
        argent = (TextView)findViewById(R.id.argent);
        energy = (TextView)findViewById(R.id.energy);
    }

    public void setRefCtrl(Pnl2_Ctrl c) {
        refCtrl= c;
        btnGoToConfig.setOnClickListener(refCtrl);
        btnGoToHome.setOnClickListener(refCtrl);
        btnWork.setOnClickListener(refCtrl);
        btnInvest.setOnClickListener(refCtrl);
        btnSleep.setOnClickListener(refCtrl);
    }

    @Override
    public void update(Observable o, Object arg) {
        textAction.setText(refCtrl.refPanelManager.getTamagotchi().getM_phrase());
        imageGame.setImageDrawable(getResources().getDrawable(refMdl.getM_etat().getEtatImage()));
        argent.setText("Argent : " + refMdl.getM_cash());
        energy.setText("Energie : " + refMdl.getM_energy());
    }
}
