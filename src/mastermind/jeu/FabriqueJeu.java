/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

/**
 *
 * @author Florian
 * @version 0.1
 * 
 */
public class FabriqueJeu {

    // La création d'un jeu en fonction de son type est encapsulée dans la fabrique.
    public Ijeu creerJeu(TypeJeu type)
    {
        Ijeu jeu = null;;
        switch(type)
        {
            case JeuJoueur:jeu = new JeuJoueur();break;
            case JeuIA:jeu = new JeuIA();break;
        }
        return jeu;
    }


// Enumération des types de jeu.
public enum TypeJeu 
{
    JeuJoueur,
    JeuDoublon,
    JeuIA,
    JeuIADoublon
}

}

