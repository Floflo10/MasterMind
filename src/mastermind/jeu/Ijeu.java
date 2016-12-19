/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

import java.util.ArrayList;

/**
 *
 * @author CodeSquadron
 * @version 0.4
 */

public interface Ijeu {
    
    /**
     * Méthode Initialisant un Jeu
     */
    public abstract void Initialisation();

    /**
     * Méthode traitant les doublons
     * @param soluce Tablaau contenant la solution avec de possible doublon
     * @return Tableau contenant la solution sans doublon
     */
    public abstract ArrayList TraitementDoublons(ArrayList soluce);

    /**
     * Méthode de création d'une partie
     */
    public abstract void Party();
    
    /**
     * Méthode de gestion de fin de partie
     */
    public abstract void Fin();
    
}
