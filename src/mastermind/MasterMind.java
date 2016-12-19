/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import mastermind.ia.IaSansDoublon;
import mastermind.jeu.FabriqueJeu.TypeJeu;
import mastermind.jeu.Ijeu;
import mastermind.jeu.JeuIA;
import mastermind.jeu.JeuJoueur;
import mastermind.jeu.UsineJeu;

/**
 *
 * @author CodeSquadron
 * @version 0.1
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
 
        UsineJeu test = new UsineJeu();
        Ijeu test2 = test.faireJeu(TypeJeu.JeuJoueur);
        
test2.Party();
test2.Fin();
 
    }
    
}
