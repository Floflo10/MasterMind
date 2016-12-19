/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import mastermind.jeu.FabriqueJeu;
import mastermind.jeu.FabriqueJeu.TypeJeu;
import mastermind.jeu.Ijeu;

/**
 *
 * @author Florian
 */
public class UsineJeu {

    private FabriqueJeu FabriqueJeu;// Attribut contenant la fabrique simple.
    private static UsineJeu Instance;
    
    // Le constructeur permet de sélectionner la fabrique à utiliser.
    private UsineJeu()
    {
        this.FabriqueJeu = new FabriqueJeu();
    }
     
    public static UsineJeu NewInstance()
    {
                if(Instance==null)
                {
                        Instance = new UsineJeu();
                }
                return Instance;
    }
    
    // Méthode qui permet de construire l'ensemble des unités.
    public Ijeu faireJeu(TypeJeu type)
    {
        Ijeu Jeu = this.FabriqueJeu.creerJeu(type);
        Jeu.Initialisation();
        Jeu.Party();
        Jeu.Fin();
        return Jeu;
    }
}

    
