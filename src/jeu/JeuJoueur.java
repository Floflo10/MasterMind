/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author CodeSquadron
 * @version 0.5
 */
public class JeuJoueur implements Ijeu {

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

    public JeuJoueur() {
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

        /*Trie Tableau - Appel réccurcif de la méthode TraitementDoublons.
    Tant que l'Array n'est pas complet, on appel la méthode de supression.
         */
        soluce = TraitementDoublons(soluce);
        while (nbcase > soluce.size()) {
            soluce = TraitementDoublons(soluce);
        }

    }

    @Override
    public ArrayList TraitementDoublons(ArrayList soluce) {

        /*Récupération de l'arrayList contenant les valeurs avec de possible doublons.    
        Une fois récupérée, l'arrayList est tranformé en collectionneur de type Set.
        Les doublons sont alors supprimé et la liste triée.
         */
        Set temp = new HashSet(soluce);
        ArrayList traite = new ArrayList(temp);
        temp = null;

        //Si il y a eu une suppression de tableau, les valeurs manquantes sont à nouveau remplie.
        while (nbcase > traite.size()) {
            valeur = min + r.nextInt(max - min);
            traite.add(valeur);
        }

        /* Nouvelle suppression des potentiels doublons, la méthode rendant soit l'ArrayList final
    soit une version sans doublons mais avec des valeurs manquantes
         */
        Set temperature = new HashSet(traite);
        ArrayList traite2 = new ArrayList(temperature);
        Collections.shuffle(traite2);
        return traite2;
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
                    MP++;
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

}
