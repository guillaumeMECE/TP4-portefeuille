package controller;

import model.Fond;
import model.Instrument;
import model.Portefeuille;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPortefeuille {
    private static Portefeuille pf;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        pf = new Portefeuille();
        // write your code here
        System.out.print("Clé de l'instrument : ");
        String key = sc.nextLine();
        System.out.println(key);
        System.out.print("Montant de fonds de l'instrument : ");
        double montant = sc.nextDouble();
        System.out.println(montant);
        try {
            ArrayList<Fond> aF = new ArrayList<>();
            aF = pf.searchInstrument(key);
        } catch (InstrumentInexistant e) {
            //instrumentInexistant.printStackTrace();
            System.out.println(e.getMessage());

            Fond f2 = new Fond(montant);
            ArrayList<Fond> alF = new ArrayList<>();
            alF.add(f2);
            Instrument i = new Instrument(alF);
            pf.getHmI().put(key, i);
            pf.addFondToInstrument(key, f2);
            System.out.println("Instrument est ajouté");
            try {
                for (Fond f : pf.searchInstrument(key)) {
                    System.out.println(f.getAmount());
                }
            } catch (InstrumentInexistant e2) {
                System.out.println(e2.getMessage());
            }
        }
        
        
        
        //ajout d'un fond à un instrument
        System.out.print("ajout d'un fond à un instrument ");
        System.out.print("Clé de l'instrument : ");
        String key2;
        sc.nextLine();
        key2 = sc.nextLine();
        System.out.print("Montant de fonds de l'instrument : ");
        double montant2 = sc.nextDouble();
        Fond f3 = new Fond(montant2);
        
        ///si je donne une mauvaise clef ca me laisse faire ATTENTION PROBLEME
        pf.addFondToInstrument(key2, f3);
        try {
            for (Fond f : pf.searchInstrument(key2)) {
                // ATTENTION PROBLEME ca ne m'affiche qu'un seul fond
                System.out.println(f.getAmount());
            }
        } catch (InstrumentInexistant e3) {
            System.out.println(e3.getMessage());
        }
        
        
        
    }
}
