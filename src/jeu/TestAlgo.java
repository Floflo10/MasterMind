/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.Random;

/**
 *
 * @author Florian
 */
public class TestAlgo {
    int turn = 10;
    int nbcase = 5;
    
    int soluce[] = new int[nbcase];
    int essaie[] = new int[nbcase];
    int min = 1;
    int max = 9;
    Random r = new Random();
    int valeur = 0;

public void test () {    
    
    //Création tableau
    for (int i = 0; i < nbcase; i++)
    {
        valeur = 0;
        valeur = min + r.nextInt(max - min);
        soluce[i] = valeur;
        
     System.out.println("Indice = " + i + " valeur :" + soluce[i]);
    }
    
    //Trie Tableau

        boolean doublon = false;
        //int temp = 0;
        
    do {
        doublon = false;
        for (int i = 0; i < nbcase; i++)
        {
            for (int j = 1; j < nbcase; j++) 
            {
             
           if (soluce[i] == soluce[i+j])
            {
               valeur = 0;
                valeur = min + r.nextInt(max - min);
                soluce[i] = valeur;
               
            } 
             doublon = true;
            }
    }
           
        } while ( doublon);
    
    for (int i = 0; i < soluce.length; i++)
    {
            System.out.println("Indice = " + i + " valeur :" + soluce[i]);
    }
    //Jeu
         
            
    //Fin
}

}
