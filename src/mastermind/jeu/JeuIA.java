/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import mastermind.ia.IaSansDoublon;

/**
 *
 * @author CodeSquadron
 * @version 0.1
 *
 */
public class JeuIA extends Observable implements Ijeu {

    int turn = 10;
    int nbcase = 5;

    private ArrayList essaie = new ArrayList();
    private final int min = 1;
    private final int max = 9;
    private Random r = new Random();
    private int valeur;
    private int BP = 0;
    private int MP = 0;
    private int nbturn;
    private boolean fin = true;

    public JeuIA() {
        this.nbturn = 0;
        this.valeur = 0;
    }

    @Override
    public void Initialisation() {
        
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

        IaSansDoublon Jarvis = new IaSansDoublon(nbcase, max);

        for (int i = 0; i < nbcase; i++) {
            valeur = 0;
            valeur = min + r.nextInt(max - min);
            essaie.add(valeur);

        }

        essaie = TraitementDoublons(essaie);
        while (nbcase > essaie.size()) {
            essaie = TraitementDoublons(essaie);
        }

        while (BP != 5 && nbturn != turn) {
            System.out.println(essaie);
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez BP : ");
            BP = sc.nextInt();
            System.out.println("Entrez MP : ");
            MP = sc.nextInt();

            essaie = Jarvis.Case(BP, MP, essaie);

            nbturn++;
            setChanged();
            notifyObservers();

        }

    }

    @Override
    public void Fin() {
        if (BP == 5) {
            System.out.println("Eureka!");
        } else {
            System.out.println("Fail, j'ai échoué");
        }

    }



    /**
     * @return the essaie
     */
    public ArrayList getEssaie() {
        return essaie;
    }


}
