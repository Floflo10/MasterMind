/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author CodeSquadron
 * @version 0.1
 */
public class JeuJoueurDoublon implements Ijeu {
        int turn = 10;
    int nbcase = 5;

    private ArrayList soluce = new ArrayList();
    private ArrayList essaie = new ArrayList();
    private final int min = 1;
    private final int max = 9;
    private Random r = new Random();
    private int valeur;
    private int BP = 0;
    private int MP = 0;
    private int nbturn;
    private boolean fin = true;

    public JeuJoueurDoublon() {
        this.nbturn = 0;
        this.valeur = 0;
    }

    @Override
    public void Initialisation() {

        //Création tableau
        for (int i = 0; i < nbcase; i++) {
            valeur = 0;
            valeur = min + r.nextInt(max - min);
            soluce.add(valeur);

        }
    }


    @Override
    public void Party() {

        while (BP != 5 && nbturn != turn) {
            MP = 0;
            BP = 0;
            essaie.clear();
            int entreTemp = 0;

            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez nombre : ");
            int entree = sc.nextInt();

            for (int i = (nbcase); i > 0; i--) {
                entreTemp = (int) Math.pow(10, i - 1);
                int temp1 = entree / entreTemp;
                int temp2 = entree % entreTemp;
                entree = temp2;

                essaie.add(temp1);

            }

            for (int i = 0; i < soluce.size(); i++) {

                if (soluce.get(i) == essaie.get(i)) {
                    BP++;
                } else if (soluce.get(i) != essaie.get(i)) {

                    for (int j = 0; j < soluce.size(); j++) {

                        if (soluce.get(i) != essaie.get(i) && soluce.get(i) == essaie.get(j)) {
                            MP++;
                        }

                    }

                }
            }
            System.out.println(BP + "BP/" + MP + "MP");
            nbturn++;

        }

    }

    @Override
    public void Fin() {
        if (BP == 5) {
            System.out.println("Eureka!");
        } else {
            System.out.println("Fail, la bonne réponce était " + soluce);
        }

    }

    @Override
    public ArrayList TraitementDoublons(ArrayList soluce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
