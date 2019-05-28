/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeArray.sort;

/**
 * @author helen
 */
public class Instrument {
    //attribut
    private ArrayList<Fond> valeursFonds;

    //constructor
    public Instrument() {
        valeursFonds = new ArrayList<>();
    }

    public Instrument(ArrayList<Fond> newFonds) {
        valeursFonds = newFonds;
    }

    //getter et setter

    public void addFond(Fond f) {
        valeursFonds.add(f);
    }

    public ArrayList<Fond> getValeurFonds() {
        return valeursFonds;
    }

    public void setValeurFonds(ArrayList<Fond> newArrayListFonds) {
        valeursFonds = newArrayListFonds;
    }

    //tri 
    public void tri() {
        //on créer notre tableau et notre comparateur
        Fond[] tab = valeursFonds.toArray(new Fond[valeursFonds.size()]);
        ComparableImplemente comparator = new ComparableImplemente();

        //on trie notre tableau avec notre comparateur
        sort(tab, comparator);

        //on créer une arrayList tempon
        ArrayList<Fond> sortedValeursFond = new ArrayList<>();
        sortedValeursFond.addAll(Arrays.asList(tab));

        //on remets les valeurs de l'arrayList tempon dans l'arraylist de la classe.
        valeursFonds = sortedValeursFond;

    }
}

