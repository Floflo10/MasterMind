/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import mastermind.ia.IaSansDoublon;

/**
 *
 * @author CodeSquadron
 * @version 0.1
 */
public class JeuIADoublon implements Ijeu{

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

    public JeuIADoublon() {
        this.nbturn = 0;
        this.valeur = 0;
    }

    @Override
    public void Initialisation() {
        
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
        }

    }

    @Override
    public void Fin() {
        if (BP == 5) {
            System.out.println("Eureka!");
        } else {
            System.out.println("Fail, , j'ai échoué");
        }

    }

    @Override
    public ArrayList TraitementDoublons(ArrayList soluce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
