package com.example.tamagotchi.controllers;

import static com.example.tamagotchi.utils.Utils.getNames;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.RequiresApi;

import com.example.tamagotchi.PanelManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.modeles.Pnl3_Mdl;
import com.example.tamagotchi.tools.CryptoList;
import com.example.tamagotchi.utils.Utils;

import java.util.List;

public class Pnl3_Ctrl implements View.OnClickListener, AdapterView.OnItemClickListener {

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
        }
    }

    public TextWatcher textWatcherNameTama = new TextWatcher() {

        public void afterTextChanged(Editable s) {
            refPanelManager.getConfig().setM_nameOfTamagotchi(String.valueOf(s));
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    };

    public TextWatcher textWatcherNamePlayer = new TextWatcher() {

        public void afterTextChanged(Editable s) {
            refPanelManager.getConfig().setM_nameOfUser(String.valueOf(s));
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    };

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] list = Utils.getNames(CryptoList.class);

        boolean isSelected = false;
        for(String crypto : Pnl3_Mdl.getM_cryptoList()){
            if(list[position] == crypto){
                isSelected = true;
                refPanelManager.getConfig().removeCryptoOfList(crypto);
                break;
            }
        }

        if(!isSelected){
            refPanelManager.getConfig().addCryptoIntoList(list[position]);
        }

        System.out.println(position + " numéro de la crypto " + list[position]);
    }
}
