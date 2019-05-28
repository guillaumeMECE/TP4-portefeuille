package controller;

import model.Fond;
import model.Instrument;
import model.Portefeuille;
import view.Statistique;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPortefeuille {
    private static Portefeuille pf;
    private static Statistique stat = new Statistique();
    private static Scanner sc = new Scanner(System.in);

    public static void createInstrument(){
        System.out.println("CREATION D'UN INSTRUMENT");
        System.out.print("Clé de l'instrument : ");
        String key = sc.nextLine();
        System.out.print("Montant de fonds de l'instrument : ");
        double montant = sc.nextDouble();
        ArrayList<Fond> aF = new ArrayList<>();
        try {
            aF = pf.searchInstrument(key);
        } catch (InstrumentInexistant instrumentInexistant) {
            System.out.println(instrumentInexistant.getMessage());
            Fond f = new Fond(montant);
            ArrayList<Fond> alF = new ArrayList<>();
            alF.add(f);
            Instrument i = new Instrument(alF);
            pf.getHmI().put(key, i);
            System.out.println("Instrument est ajouté");
        }
    }
    public static void createFondinInstrument(){
        System.out.println("AJOUT D'UN FOND A UN INSTRUMENT");
        System.out.print("Clé de l'instrument : ");
        //sc.nextLine();
        String key = sc.nextLine();
        System.out.print("Montant du fond : ");
        double montant = sc.nextDouble();
        Fond f = new Fond(montant);
        pf.addFondToInstrument(key, f);
        System.out.println("Fond ajoute à l'Instrument");
    }

    public static void createFond(){
        System.out.println("CREATION D'UN FOND");
        System.out.print("Clé du fond : ");
        String key = sc.nextLine();
        System.out.print("Montant de fonds de l'instrument : ");
        double montant = sc.nextDouble();
        try {
            pf.addFond(key, montant);
        } catch (FondExistant e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        pf = new Portefeuille();

        createInstrument();
        stat.displayInstrument(pf);
        createFondinInstrument();
        stat.displayInstrument(pf);
        /*System.out.print("CREATION D'UN INSTRUMENT");
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
            System.out.println(e.getMessage());

            Fond f2 = new Fond(montant);
            ArrayList<Fond> alF = new ArrayList<>();
            alF.add(f2);
            Instrument i = new Instrument(alF);
            pf.getHmI().put(key, i);
            System.out.println("Instrument est ajouté");*/
           /* try {
                for (Fond f : pf.searchInstrument(key)) {
                    System.out.println(f.getAmount());
                }
            } catch (InstrumentInexistant e2) {
                System.out.println(e2.getMessage());
            }
        }*/


        //ajout d'un fond à un instrument
       /* System.out.print("ajout d'un fond à un instrument ");
        System.out.print("Clé de l'instrument : ");
        String key2;
        sc.nextLine();
        key2 = sc.nextLine();
        System.out.print("Montant de fonds de l'instrument : ");
        double montant2 = sc.nextDouble();
        Fond f3 = new Fond(montant2);


        ///si je donne une mauvaise clef ca me laisse faire ATTENTION PROBLEME

        pf.addFondToInstrument(key2, f3);*/


        /*try {
            for (Fond f : pf.searchInstrument(key2)) {
                // ATTENTION PROBLEME ca ne m'affiche qu'un seul fond
                System.out.println(f.getAmount());
            }
        } catch (InstrumentInexistant instrumentInexistant) {
            instrumentInexistant.printStackTrace();
        }*/

        ///supprimer un fond depuis le portefeuille
        System.out.println("suppression d'un fond du portefeuille");
        stat.displayFond(pf);

        for (int i = 0; i < 2; i++) {
            createFond();
            /*System.out.print("creation d'un fond . Donnez sa clé :");
            String key3;
            sc.nextLine();
            key3 = sc.nextLine();
            System.out.print("Montant de fonds de l'instrument : ");
            double montant3 = sc.nextDouble();
            try {
                pf.addFond(key3, montant3);
            } catch (FondExistant ex) {
                System.out.println(ex.getMessage());
            }*/
        }

        stat.displayFond(pf);

        System.out.print("suppression d'un fond . Donnez sa clé :");
        String key4;
        sc.nextLine();
        key4 = sc.nextLine();
        pf.delFond(key4);
        stat.displayFond(pf);

        ///supprimer un instrument depuis le portefeuille
        System.out.println("suppression d'un instrument");
        System.out.print("Donnez sa clé :");
        String key5;
        //sc.nextLine();
        key5 = sc.nextLine();
        pf.delInstrument(key5);

        stat.displayInstrument(pf);
        try {
            pf.addFond("tst", 10);
            stat.displayPourcentage(pf, "tst");
        } catch (FondExistant fondExistant) {
            fondExistant.printStackTrace();
        } catch (FondInexistant fondInexistant) {
            fondInexistant.printStackTrace();
        } catch (InstrumentInexistant instrumentInexistant) {
            instrumentInexistant.printStackTrace();
        }
    }
}
