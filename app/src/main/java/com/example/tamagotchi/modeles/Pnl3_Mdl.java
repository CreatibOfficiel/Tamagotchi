package com.example.tamagotchi.modeles;

import android.os.Build;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import com.example.tamagotchi.R;
import com.example.tamagotchi.tools.CryptoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Pnl3_Mdl extends Observable {

    private static String m_nameOfTamagotchi;
    private static String m_nameOfUser;
    private static List<String> m_cryptoList;

    public Pnl3_Mdl() {
        m_nameOfTamagotchi = "RAT";
        m_nameOfUser = "Trader";
        m_cryptoList = new ArrayList();
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

    public static List<String> getM_cryptoList() { return m_cryptoList; }

    public void addCryptoIntoList(String name) { m_cryptoList.add(name); }

    public void removeCryptoOfList(String name) { m_cryptoList.remove(m_cryptoList.indexOf(name)); }

    public void update(){
        setChanged();
        notifyObservers();
    }
}
