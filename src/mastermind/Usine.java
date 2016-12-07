package mastermind;

import Fabrique.IJeu;
import Fabrique.Jeu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baptiste
 */
class Usine {
    
    String typeJeu =null;
    Usine(String atype) {
        typeJeu = atype;
     }

    IJeu construireJeu() throws Exception {
     return new Jeu(typeJeu);
    }
    
}