package com.example.tamagotchi.mvc3;

import java.util.Observable;

public class Pnl3_Mdl extends Observable {
    // todo trouver la solution pour avoir accès à cette classe dans le panel2
    private String m_nameOfTamagotchi;
    private String m_nameOfUser;

    public Pnl3_Mdl() {
        m_nameOfTamagotchi = "RAT";
        m_nameOfUser = "Trader";
    }

    public String getM_nameOfTamagotchi() {
        return m_nameOfTamagotchi;
    }

    public void setM_nameOfTamagotchi(String m_nameOfTamagotchi) {
        this.m_nameOfTamagotchi = m_nameOfTamagotchi;
    }

    public String getM_nameOfUser() {
        return m_nameOfUser;
    }

    public void setM_nameOfUser(String m_nameOfUser) {
        this.m_nameOfUser = m_nameOfUser;
    }

    public void update(){
        setChanged();
        notifyObservers();
    }
}
