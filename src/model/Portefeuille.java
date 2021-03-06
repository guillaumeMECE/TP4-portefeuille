/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.FondExistant;
import controller.FondInexistant;
import controller.InstrumentInexistant;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author guillaume, helene
 */
public class Portefeuille {
    //attribut
    private HashMap<String, Fond> hmF;
    private HashMap<String, Instrument> hmI;

    //constructor
    public Portefeuille() {
        this.hmF = new HashMap<>();
        this.hmI = new HashMap<>();
    }

    public Portefeuille(HashMap<String, Fond> _hmF, HashMap<String, Instrument> _hmI) {
        this.hmF = new HashMap<>(_hmF);
        this.hmI = new HashMap<>(_hmI);
    }

    //getter et setter

    public void setHmF(HashMap<String, Fond> hmF) {
        this.hmF = hmF;
    }

    public void setHmI(HashMap<String, Instrument> hmI) {
        this.hmI = hmI;
    }

    public HashMap<String, Fond> getHmF() {
        return hmF;
    }

    public HashMap<String, Instrument> getHmI() {
        return hmI;
    }

    //others

    public double searchFonds(String key) throws FondInexistant {
        Fond o;
        double amount;
        o = hmF.get(key);
        if (o == null) {
            throw new FondInexistant();
        }
        amount = o.getAmount();
        return amount;
    }

    public ArrayList<Fond> searchInstrument(String key) throws InstrumentInexistant {
        Instrument o;
        ArrayList<Fond> arrayFond;
        o = hmI.get(key);
        if (o == null) {
            throw new InstrumentInexistant();
        }
        arrayFond = o.getValeurFonds();
        return arrayFond;
    }

    public void addFond(String key, double amount) throws FondExistant {
        //Exception if key exist
        if (hmF.containsKey(key)) {
            throw new FondExistant();
        }
        hmF.put(key, new Fond(amount));
    }

    public void addFondToInstrument(String key, Fond f) {
        try {
            searchInstrument(key);
            hmI.get(key).addFond(f);
        } catch (InstrumentInexistant instrumentInexistant) {
            System.out.println(instrumentInexistant.getMessage());
        }
    }

    public void delFond(String key) {
        try {
            searchFonds(key);
            hmF.remove(key);
        } catch (FondInexistant fondInexistant) {
            System.out.println(fondInexistant.getMessage());
        }
    }

    public void delInstrument(String key) {
        try {
            searchInstrument(key);
            hmI.get(key).getValeurFonds().clear(); //clear fond de l'instrument
            hmI.remove(key);
        } catch (InstrumentInexistant instrumentInexistant) {
            System.out.println(instrumentInexistant.getMessage());
        }
    }
}
