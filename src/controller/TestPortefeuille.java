package controller;

import model.Fond;
import model.Instrument;
import model.Portefeuille;
import view.Statistique;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPortefeuille {
    private static Portefeuille pf = new Portefeuille();
    private static Statistique stat = new Statistique();
    // private static Scanner sc = new Scanner(System.in);

    public static void createInstrument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCREATION D'UN INSTRUMENT");
        System.out.print("Clé de l'instrument : ");
        String key = sc.nextLine();
        System.out.print("Montant de fonds de l'instrument : ");
        double montant = sc.nextDouble();
        ArrayList<Fond> aF = new ArrayList<>();
        try {
            aF = pf.searchInstrument(key);
            System.out.println("Instrument existant\n");
        } catch (InstrumentInexistant instrumentInexistant) {
            System.out.println(instrumentInexistant.getMessage());
            Fond f = new Fond(montant);
            ArrayList<Fond> alF = new ArrayList<>();
            alF.add(f);
            Instrument i = new Instrument(alF);
            pf.getHmI().put(key, i);
            System.out.println("Instrument ajouté\n");
        }
    }

    public static void createFondinInstrument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAJOUT D'UN FOND A UN INSTRUMENT");
        System.out.print("Clé de l'instrument : ");
        String key = sc.nextLine();
        System.out.print("Montant du fond : ");
        double montant = sc.nextDouble();
        Fond f = new Fond(montant);
        pf.addFondToInstrument(key, f);
        System.out.println("Fond ajoute à l'Instrument\n");
    }

    public static void createFond() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCREATION D'UN FOND");
        System.out.print("Clé du fond : ");
        String key = sc.nextLine();
        System.out.print("Montant du fond : ");
        double montant = sc.nextDouble();
        try {
            pf.addFond(key, montant);
            System.out.println("Fond cree\n");
        } catch (FondExistant e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delFond() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSUPPRESSION D'UN FOND");
        System.out.print("Clé du fond : ");
        String key = sc.nextLine();
        pf.delFond(key);
        System.out.println("Fond supprimé\n");
    }

    public static void delInstrument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSUPPRESSION D'UN INSTRUMENT");
        System.out.print("Donnez sa clé : ");
        String key = sc.nextLine();
        pf.delInstrument(key);
        System.out.println("Instrument supprimé\n");
    }

    public static void percent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCHOIX DU FOND POUR POURCENTAGE");
        stat.displayFond(pf);
        System.out.print("Clé du fond : ");
        String key = sc.nextLine();
        try {
            stat.displayPourcentage(pf, key);
        } catch (FondInexistant fondInexistant) {
            fondInexistant.printStackTrace();
        } catch (InstrumentInexistant instrumentInexistant) {
            instrumentInexistant.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            createInstrument();
        }
        stat.displayInstrument(pf);
        for (int i = 0; i < 3; i++) {
            createFondinInstrument();
        }
        stat.displayInstrument(pf);
        for (int i = 0; i < 2; i++) {
            createFond();
        }
        stat.displayFond(pf);
        delFond();
        stat.displayFond(pf);
        delInstrument();
        stat.displayInstrument(pf);
        percent();
    }
}
