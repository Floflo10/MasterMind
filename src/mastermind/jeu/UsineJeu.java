/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

import mastermind.jeu.FabriqueJeu.TypeJeu;

/**
 *
 * @author Florian
 */
public class UsineJeu {

    private FabriqueJeu FabriqueJeu;// Attribut contenant la fabrique simple.
     
    // Le constructeur permet de sélectionner la fabrique à utiliser.
    public UsineJeu()
    {
        this.FabriqueJeu = new FabriqueJeu();
    }
     
    // Méthode qui permet de construire l'ensemble des unités.
    public Ijeu faireJeu(TypeJeu type)
    {
        Ijeu Jeu = this.FabriqueJeu.creerJeu(type);
        Jeu.Initialisation();
        return Jeu;
    }
}

    
