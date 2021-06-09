package com.example.tamagotchi.mvc3;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.tamagotchi.PanelManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class Pnl3_Ctrl implements View.OnClickListener {

    public PanelManager refPanelManager;
    public Pnl3_Mdl refMdl;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonGoHomeConfig){
            refPanelManager.setPanel(1);
        }
        else if(v.getId() == R.id.buttonGoGameConfig){
            refPanelManager.setPanel(2);
        }
        else if(v.getId() == R.id.init){
            // init
            refPanelManager.getConfig().setM_nameOfUser("Trader");
            refPanelManager.getConfig().setM_nameOfTamagotchi("RAT");
            refPanelManager.getConfig().update();
            // todo reset les champs de text avec le texte de base
        }
    }

    public TextWatcher textWatcherNameTama = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            refPanelManager.getConfig().setM_nameOfTamagotchi(String.valueOf(s));
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    };

    public TextWatcher textWatcherNamePlayer = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            refPanelManager.getConfig().setM_nameOfUser(String.valueOf(s));
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    };
}
