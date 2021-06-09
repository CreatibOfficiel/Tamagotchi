package com.example.tamagotchi.etats;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class EtatSleepRough implements Etat {

    private int etatImage = R.drawable.mort;

    @Override
    public void etapeSuivante(Pnl2_Mdl tamagotchiManager) {

    }

    public int getEtatImage() { return etatImage; }
}
