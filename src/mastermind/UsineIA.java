/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import mastermind.ia.FabriqueIa;
import mastermind.ia.IIa;

/**
 *
 * @author Florian
 */
public class UsineIA {
        private FabriqueIa FabriqueIa;// Attribut contenant la fabrique simple.
    private static UsineIA Instance;
    
    // Le constructeur permet de sélectionner la fabrique à utiliser.
    private UsineIA()
    {
        this.FabriqueIa = new FabriqueIa();
    }
     
    public static UsineIA NewInstance()
    {
                if(Instance==null)
                {
                        Instance = new UsineIA();
                }
                return Instance;
    }
    
    // Méthode qui permet de construire l'ensemble des unités.
    public IIa faireIA(FabriqueIa.TypeJeu type)
    {
        IIa IA = this.FabriqueIa.creerIA(type);
        return IA;
    }
}
