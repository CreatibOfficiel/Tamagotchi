package com.example.tamagotchi.views;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.tamagotchi.R;
import com.example.tamagotchi.controllers.Pnl3_Ctrl;
import com.example.tamagotchi.modeles.Pnl3_Mdl;
import com.example.tamagotchi.tools.CryptoList;
import com.example.tamagotchi.utils.Utils;

import java.io.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public ListView listCrypto;
    public ArrayAdapter<String> adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Pnl3_View(Context context) {
        super(context);
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl_config, this);

        btnInit = (Button)findViewById(R.id.init);
        btnGoToGame = (Button)findViewById(R.id.buttonGoGameConfig);
        btnGoToHome = (Button)findViewById(R.id.buttonGoHomeConfig);

        editTextTamaName = (EditText)findViewById(R.id.nameTamagotchi);
        editTextPlayerName = (EditText)findViewById(R.id.namePlayer);

        listCrypto = findViewById(R.id.cryptoList);
        adapter = new ArrayAdapter<String>(context, R.layout.simple_list_item_multiple_choice, Utils.getNames(CryptoList.class));
        listCrypto.setAdapter(adapter);
    }

    public void setRefCtrl(Pnl3_Ctrl c) {
        refCtrl= c;
        btnInit.setOnClickListener(refCtrl);
        btnGoToHome.setOnClickListener(refCtrl);
        btnGoToGame.setOnClickListener(refCtrl);

        editTextTamaName.addTextChangedListener(c.textWatcherNameTama);
        editTextPlayerName.addTextChangedListener(c.textWatcherNamePlayer);

        listCrypto.setOnItemClickListener(refCtrl);
    }

    @Override
    public void update(Observable o, Object arg) {
        editTextTamaName.setText(refCtrl.refPanelManager.getConfig().getM_nameOfTamagotchi());
        editTextPlayerName.setText(refCtrl.refPanelManager.getConfig().getM_nameOfUser());
        adapter.notifyDataSetChanged();
    }
}
