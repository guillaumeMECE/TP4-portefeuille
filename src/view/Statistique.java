package view;

import controller.FondInexistant;
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
        System.out.println("DISPLAY INSTRUMENTS");
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
                tot = 0;
            } catch (InstrumentInexistant instrumentInexistant) {
                System.out.println(instrumentInexistant.getMessage());
            }
        }
    }

    public void displayPourcentage(Portefeuille pf, String keyFond) throws FondInexistant, InstrumentInexistant {
        System.out.println("DISPLAY POURCENTAGE");
        double amountToFind = pf.searchFonds(keyFond);
        int totFondInInstrument = 0;
        int nbEqual = 0;
        for (Map.Entry<String, Instrument> i : pf.getHmI().entrySet()) {
            totFondInInstrument = pf.searchInstrument(i.getKey()).size();
            for (Fond f : pf.searchInstrument(i.getKey())) {
                if (amountToFind == f.getAmount()) {
                    nbEqual += 1;
                }
            }
            System.out.println("Le pourcentage de l'Instrument \"" + i.getKey() + "\" ayant pour fond " + amountToFind + " : " + nbEqual * 100 / totFondInInstrument + "%");
            nbEqual = 0; //on reinit le nb de fond egal pour le prochain instrument
        }
    }

    public void displayFond(Portefeuille pf) {
        System.out.println("DISPLAY Fond");
        for (Map.Entry<String, Fond> i : pf.getHmF().entrySet()) {
            System.out.print(i.getKey());
            System.out.print(" à un montant de ");
            System.out.println(i.getValue().getAmount());
        }
    }
}
