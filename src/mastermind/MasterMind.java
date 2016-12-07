/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import Fabrique.IJeu;
import mastermind.jeu.JeuJoueur;
import mastermind.jeu.TestAlgo;

/**
 *
 * @author CodeSquadron
 * @version 0.1
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
/* JeuJoueur test = new JeuJoueur();
test.Initialisation();
test.Party();
test.Fin();
*/
      Usine aUsine = new Usine("JeuJoueur");
      IJeu jeu = aUsine.construireJeu();
      jeu.Afficher();

       Menu menu = new Menu();
        menu.choix_jeux();
        
  
    }
    } 
