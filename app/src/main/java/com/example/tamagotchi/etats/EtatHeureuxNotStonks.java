package com.example.tamagotchi.etats;

import com.example.tamagotchi.R;
import com.example.tamagotchi.modeles.Pnl2_Mdl;

public class EtatHeureuxNotStonks implements Etat {

    private int etatImage = R.drawable.happynstonks;

    @Override
    public void etapeSuivante(Pnl2_Mdl tamagotchiManager) {
        if(tamagotchiManager.getM_cash() > 50){
            tamagotchiManager.changeEtat(1);
        }
        if(tamagotchiManager.getM_cash() <= 0){
            tamagotchiManager.changeEtat(5);
        }
        if(tamagotchiManager.getM_energy() <= 50){
            tamagotchiManager.changeEtat(4);
        }
    }

    public int getEtatImage() { return etatImage; }

    @Override
    public String getName() {
        return "EtatHeureuxNotStonks";
    }
}
