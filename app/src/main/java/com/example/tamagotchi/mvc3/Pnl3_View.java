package com.example.tamagotchi.mvc3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

import java.util.Observable;
import java.util.Observer;

public class Pnl3_View extends LinearLayout implements Observer {

    public Pnl3_Mdl refMdl;
    public Pnl3_Ctrl refCtrl;
    public EditText editTextTamaName;

    public EditText editTextPlayerName;
    public Button btnGoToHome;
    public Button btnGoToGame;
    public Button btnInit;

    public Pnl3_View(Context context) {
        super(context);
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl_config, this);

        btnInit = (Button)findViewById(R.id.init);
        btnGoToGame = (Button)findViewById(R.id.buttonGoGameConfig);
        btnGoToHome = (Button)findViewById(R.id.buttonGoHomeConfig);

        editTextTamaName = (EditText)findViewById(R.id.nameTamagotchi);
        editTextPlayerName = (EditText)findViewById(R.id.namePlayer);
    }

    public void setRefCtrl(Pnl3_Ctrl c) {
        refCtrl= c;
        btnInit.setOnClickListener(refCtrl);
        btnGoToHome.setOnClickListener(refCtrl);
        btnGoToGame.setOnClickListener(refCtrl);

        // todo appelé le refresh pour voir direct le changement sur le jeu
        editTextTamaName.addTextChangedListener(c.textWatcherNameTama);
        editTextPlayerName.addTextChangedListener(c.textWatcherNamePlayer);
    }

    @Override
    public void update(Observable o, Object arg) {
        editTextTamaName.setText(refCtrl.refPanelManager.getConfig().getM_nameOfTamagotchi());
        editTextPlayerName.setText(refCtrl.refPanelManager.getConfig().getM_nameOfUser());
    }
}
