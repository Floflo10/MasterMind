/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import mastermind.ia.IaDoublon;
import mastermind.jeu.JeuIADoublon;
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
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*      int nbcase = 5;
        int max = 9;
                
        ArrayList mem = new ArrayList();
        
        
        for(int i=0; i<nbcase; i++){
            mem.add(new ArrayList());
            for(int j=1; j<max+1; j++){
                ((ArrayList)mem.get(i)).add(j);                
            }
            
        }
        
        System.out.println(mem);
 */ /*       JeuJoueur test = new JeuJoueur();

test.Initialisation();
test.Party();
test.Fin(); */
 
 
 
 JeuIADoublon test = new JeuIADoublon();

test.Initialisation();
test.Party();
test.Fin();


    }
    
}
