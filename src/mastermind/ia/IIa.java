/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.ia;

import java.util.ArrayList;

/**
 *
 * @author Florian
 */
public interface IIa {
    
    /**
     * Méthode de mise à jour des paramétre du jeu
     * @param BPActuel Nombre de BP pour la manche
     * @param MPActuel Nombre de MP pour la manche
     * @param SoluceActuel Tableau contenant la solution proposé lors de la manche
     */
    public void MaJ(int BPActuel, int MPActuel, ArrayList SoluceActuel);
    
    /**
     * Méthode de gestion des différents cas rencontré par l'IA
     * @param BP Nombre de BP de la manche
     * @param MP Nombre de MP de la manche
     * @param SoluceActuel Tableau contenant la solution proposé lors de la manche
     * @return Retourne le tableau proposé à la manche suivante
     */
    public ArrayList Case(int BP, int MP, ArrayList SoluceActuel);
    
    /**
     * Méthode traitant la mémoire de l'IA selon les différents cas
     * @param valeur Tableau contenant les valeurs à traiter
     * @param indice Tableau contenant les indics à traiter
     * @param cas Numeros du cas à traiter
     * @param SoluceActuel Tableau de la solution à traiter
     */
    public void Treat(ArrayList valeur,ArrayList indice, int cas, ArrayList SoluceActuel);
    
    /**
     * Méthode de génération et de vérification de la conformité de la solution
     * @param SolucePropose Solution à traiter
     * @param cas Numero du cas à traiter
     * @return
     */
    public ArrayList GenCheck(ArrayList SolucePropose, int cas);
    
}
