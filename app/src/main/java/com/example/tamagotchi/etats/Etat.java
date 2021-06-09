package com.example.tamagotchi.etats;

import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public interface Etat {
    String getName();
    int getEtatImage();
    void etapeSuivante(Pnl2_Mdl tamagotchiManager);
}
