package com.example.tamagotchi.modeles;

import android.os.Handler;

import com.example.tamagotchi.PanelManager;
import com.example.tamagotchi.etats.Etat;
import com.example.tamagotchi.etats.EtatFatigueNotStonks;
import com.example.tamagotchi.etats.EtatFatigueStonks;
import com.example.tamagotchi.etats.EtatHeureuxNotStonks;
import com.example.tamagotchi.etats.EtatHeureuxStonks;
import com.example.tamagotchi.etats.EtatSleepRough;
import com.example.tamagotchi.tools.CryptoList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Pnl2_Mdl extends Observable {

    private int m_cash;
    private int m_energy;
    private Etat m_etat;
    private String m_phrase;
    private Handler m_Handler = new Handler();

    public Pnl2_Mdl(){
        m_cash = 100;
        m_energy = 100;
        m_etat = new EtatHeureuxStonks();

        setChanged();
        notifyObservers();

        m_Handler.postDelayed(mToastRunnable, 500);
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            passTime();
            m_Handler.postDelayed(this, 500);
        }
    };

    void nouvelEtat()
    {
        m_etat.etapeSuivante(this);
        setChanged();
        notifyObservers();
    }

    void nouvelEtat(String arg)
    {
        m_etat.etapeSuivante(this);
        setChanged();
        notifyObservers(arg);
    }

    public void changeEtat(int etatNumber){
        if(m_etat != null){
            m_etat = null;
        }

        switch (etatNumber){
            case 1: // heureux & stonks
                m_etat = new EtatHeureuxStonks();
                break;
            case 2: // heureux mais notstonks
                m_etat = new EtatHeureuxNotStonks();
                break;
            case 3: // pas heureux mais stonks
                m_etat = new EtatFatigueStonks();
                break;
            case 4: // pas heureux & notstonks
                m_etat = new EtatFatigueNotStonks();
                break;
            case 5: // mort
                m_etat = new EtatSleepRough();
                break;
        }
    }

    public void work(){
        if(!m_etat.getName().equals("EtatSleepRough")){
            m_cash += 2;
            m_energy -= 2;
            if(m_energy < 0){
                m_energy = 0;
            }
            if(m_cash > 100){
                m_cash = 100;
            }
            m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " a travaillé sous vos ordres M." + Pnl3_Mdl.getM_nameOfUser() + ", iel a donc perdu de l'énergie";
            nouvelEtat();
        }else{
            m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " est mort.e... Vous avez tout perdu M." + Pnl3_Mdl.getM_nameOfUser();
            setChanged();
            notifyObservers();
        }
    }

    public void sleep(){
        if(!m_etat.getName().equals("EtatSleepRough")){
            m_energy += 5;
            if(m_energy > 100){
                m_energy = 100;
            }
            m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " s'est endormi.e pour récupérer, M." + Pnl3_Mdl.getM_nameOfUser();
            nouvelEtat();
        }else{
            m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " est mort.e... Vous avez tout perdu M." + Pnl3_Mdl.getM_nameOfUser();
            setChanged();
            notifyObservers();
        }
    }

    public void giveCrypto(int value){
        if(!m_etat.getName().equals("EtatSleepRough")){
            m_cash += value;
            m_energy -= 5;
            if(m_energy < 0){
                m_energy = 0;
            }
            if(m_cash > 100){
                m_cash = 100;
            }else if(m_cash < 0){
                m_cash = 0;
            }
        }
    }

    public void invest(){
        if(!m_etat.getName().equals("EtatSleepRough")){
            if(Pnl3_Mdl.getM_cryptoList().size() != 0){
                final List<String> list = Pnl3_Mdl.getM_cryptoList();

                Random random = new Random(); // creating Random object

                int value = random.nextInt(15);
                String randomCrypto = list.get(random.nextInt(list.size()));

                if(random.nextBoolean()) { // displaying a random boolean
                    // down
                    value *= -1;
                }

                giveCrypto(value);

                if(value < 0){
                    m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " a acheté la crypto-monnaie " + randomCrypto + ", c'était un mauvais coup, vous avez perdu de l'argent M." + Pnl3_Mdl.getM_nameOfUser() + ". De plus, " + Pnl3_Mdl.getM_nameOfTamagotchi() + " s'est fatigué.e.";
                    nouvelEtat("fail");
                } else {
                    m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " a acheté la crypto-monnaie " + randomCrypto + ", c'était un bon coup, vous avez gagné de l'argent M." + Pnl3_Mdl.getM_nameOfUser() + ". Mais " + Pnl3_Mdl.getM_nameOfTamagotchi() + " s'est fatigué.e.";
                    nouvelEtat("win");
                }
            }else{
                m_phrase = "M." + Pnl3_Mdl.getM_nameOfUser() + " vous devez choisir au moins une crypto dans la liste de la config";
            }
        }else{
            m_phrase = Pnl3_Mdl.getM_nameOfTamagotchi() + " est mort.e... Vous avez tout perdu M." + Pnl3_Mdl.getM_nameOfUser();
            setChanged();
            notifyObservers();
        }
    }

    public void playAgain(){
        if(m_etat.getName().equals("EtatSleepRough")){
            m_cash = 100;
            m_energy = 100;
            m_etat = new EtatHeureuxStonks();

            setChanged();
            notifyObservers();
        }
    }

    public void passTime(){
        if(PanelManager.getPnl() == 2) {
            if (m_energy > 0)
                m_energy--;
            if (m_cash > 0)
                m_cash--;
        }
        nouvelEtat();
    }

    public int getM_cash() { return m_cash; }

    public int getM_energy() { return m_energy; }

    public Etat getM_etat() { return m_etat; }

    public String getM_phrase() { return m_phrase; }

}
