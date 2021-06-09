package com.example.tamagotchi.etats;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class EtatHeureuxStonks implements Etat{

    private int etatImage = R.drawable.happystonks;

    @Override
    public void etapeSuivante(Pnl2_Mdl tamagotchiManager) {
        if(tamagotchiManager.getM_cash() <= 50){
            tamagotchiManager.changeEtat(2);
        }
        if(tamagotchiManager.getM_energy() <= 50){
            tamagotchiManager.changeEtat(3);
        }
    }

    public int getEtatImage() { return etatImage; }
}
