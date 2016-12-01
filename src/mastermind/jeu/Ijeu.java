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
    
    public abstract void Initialisation();
    public abstract ArrayList TraitementDoublons(ArrayList soluce);
    public abstract void Party();
    public abstract void Fin();
    
}
