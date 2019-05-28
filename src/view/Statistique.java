package view;

import controller.InstrumentInexistant;
import model.Fond;
import model.Instrument;
import model.Portefeuille;

import java.util.HashMap;
import java.util.Map;

public class Statistique {

    public Statistique() {

    }

    public void displayInstrument(Portefeuille pf) {
        double tot = 0;
        for (Map.Entry<String, Instrument> i : pf.getHmI().entrySet()) {
            System.out.print(i.getKey());
            System.out.print(" contient ");
            try {
                System.out.print(pf.searchInstrument(i.getKey()).size() + " fond.s : ");
                for (Fond f : pf.searchInstrument(i.getKey())) {
                    // ATTENTION PROBLEME ca ne m'affiche qu'un seul fond
                    System.out.print(f.getAmount());
                    System.out.print(" / ");
                    tot += f.getAmount();
                }
                System.out.println("Total : " + tot);
            } catch (InstrumentInexistant instrumentInexistant) {
                System.out.println(instrumentInexistant.getMessage());
            }
        }
    }

    public void displayPourcentage() {

    }
}
