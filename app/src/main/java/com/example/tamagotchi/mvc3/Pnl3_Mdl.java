package com.example.tamagotchi.mvc3;

import android.util.Log;

import java.util.Observable;

public class Pnl3_Mdl extends Observable {
    // todo trouver la solution pour avoir accès à cette classe dans le panel2
    private static String m_nameOfTamagotchi;
    private static String m_nameOfUser;

    public Pnl3_Mdl() {
        m_nameOfTamagotchi = "RAT";
        m_nameOfUser = "Trader";
    }

    public static String getM_nameOfTamagotchi() {
        return m_nameOfTamagotchi;
    }

    public void setM_nameOfTamagotchi(String m_nameOfTamagotchi) { this.m_nameOfTamagotchi = m_nameOfTamagotchi; }

    public static String getM_nameOfUser() {
        return m_nameOfUser;
    }
    // test
    public void setM_nameOfUser(String m_nameOfUser) { this.m_nameOfUser = m_nameOfUser; }

    public void update(){
        setChanged();
        notifyObservers();
    }
}
