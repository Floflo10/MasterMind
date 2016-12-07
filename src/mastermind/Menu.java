package mastermind;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Fabrique.IJeu;
import java.util.Scanner;
/**
 *
 * @author baptiste
 */


public class Menu {

    private int a_choix_jeux;
    private final Scanner sc = new Scanner(System.in);
    private Usine aUsine = null;
    private IJeu Jeu;
    public Menu() {
    }

    public void choix_jeux() throws Exception {//metode qui ne fait que choisir le jeux que nous allons utilisé
        System.out.println("A quelle  jeux voulez vous jouez");
        System.out.println("tapez l'option que vous voulez");
        System.out.println("1- pour le jeux des JeuJoueur");
        System.out.println("2- pour le jeux des JeuJoueurDoublon");
        System.out.println("3- pour le jeux du JeuIA");
        System.out.println("4- pour le jeux du JeuIADoublon");
        System.out.println("5- pour quitez");
        this.a_choix_jeux = sc.nextInt();

        switch (a_choix_jeux) {//swutch pour pouvoir ajouté une infinité de jeux
            case 1:
                if(aUsine == null)
                {
                aUsine = new Usine("JeuJoueur");
                 Jeu = aUsine.construireJeu();
                Jeu.Afficher();
                break;
                }
            case 2:            
                if(aUsine == null){
                aUsine = new Usine("JeuJoueurDoublon");
                Jeu = aUsine.construireJeu();
                Jeu.Afficher();
            break;
                }
            case 3:           
                if(aUsine == null){
                aUsine = new Usine("JeuIA");
                 Jeu = aUsine.construireJeu();
                Jeu.Afficher();
                break;
                }
             case 4:            
                if(aUsine == null){
                 aUsine = new Usine("JeuIADoublon");
                 Jeu = aUsine.construireJeu();
                Jeu.Afficher();
                break;
                }
            default:
                System.out.println("merci au revoir et a bientôt");
                System.exit(0);
                break;
                
        }
    }

}
