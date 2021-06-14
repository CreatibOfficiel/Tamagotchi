package com.example.tamagotchi.etats;

import com.example.tamagotchi.modeles.Pnl2_Mdl;

public interface Etat {
    String getName();
    int getEtatImage();
    void etapeSuivante(Pnl2_Mdl tamagotchiManager);
}
