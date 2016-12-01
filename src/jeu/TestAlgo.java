/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Florian
 * @version 0.4
 * 
 */

public class TestAlgo {
    int turn = 10;
    int nbcase = 5;
    
    ArrayList soluce = new ArrayList();
    ArrayList essaie = new ArrayList();
    int min = 1;
    int max = 9;
    Random r = new Random();
    int valeur = 0;
    int BP = 0;
    int MP = 0;
    int nbturn = 0;
    
    public ArrayList TraitementDoublons (ArrayList soluce)
    {
        
    /*Récupération de l'arrayList contenant les valeurs avec de possible doublons.    
        Une fois récupérée, l'arrayList est tranformé en collectionneur de type Set.
        Les doublons sont alors supprimé et la liste triée.
        */
    Set temp = new HashSet (soluce);
    ArrayList traite = new ArrayList(temp);
    temp = null;
    
 //   System.out.println("\n" + traite);
    
 //Si il y a eu une suppression de tableau, les valeurs manquantes sont à nouveau remplie.
    while (nbcase > traite.size())
    {
        valeur = min + r.nextInt(max - min);
        traite.add(valeur); 
    }
   
    
   
    /* for (int i = 0; i < nbcase; i++)
    {
            System.out.println("Indice = " + i + " valeur :" + traite.get(i));
    } */
    
    /* Nouvelle suppression des potentiels doublons, la méthode rendant soit l'ArrayList final
    soit une version sans doublons mais avec des valeurs manquantes
    */
    Set temperature = new HashSet (traite);
    ArrayList traite2 = new ArrayList(temperature);
    Collections.shuffle(traite2);
    return traite2;
    }
    
public void test () {    
    
    //Création tableau
    for (int i = 0; i < nbcase; i++)
    {
        valeur = 0;
        valeur = min + r.nextInt(max - min);
        soluce.add(valeur);
        

        
   //  System.out.println("Indice = " + i + " valeur :" + soluce.get(i));
    }
    
    /*Trie Tableau - Appel réccurcif de la méthode TraitementDoublons.
    Tant que l'Array n'est pas complet, on appel la méthode de supression.
    */
            soluce = TraitementDoublons(soluce);
 //   System.out.println("\n" + soluce);
        while (nbcase > soluce.size())
        {
            soluce = TraitementDoublons(soluce);
      //      System.out.println("\n" + soluce);
        }

    //Jeu -   
    while (nbturn != turn || BP != 5)
    {
        MP = 0;
        BP = 0;
        essaie.clear();
        int entreTemp = 0;
        
          Scanner sc = new Scanner(System.in); 
        System.out.println("Entrez nombre : "); 
        int entree = sc.nextInt();
         
        for (int i = (nbcase); i > 0; i--)
        {
        entreTemp = (int) Math.pow(10, i - 1);
        int temp1 = entree / entreTemp;
        int temp2 = entree % entreTemp;
        entree = temp2;
        
       // System.out.println(entreTemp);
       // System.out.println(entree);
        
        essaie.add(temp1);
        
        System.out.println(soluce);
       // System.out.println(essaie);
        }

             
    for (int i = 0; i<soluce.size(); i++)
    {
        if (soluce.get(i) == essaie.get(i))
        {
            BP++;
            //System.out.println("OK");
        }
        
        else {
            MP++;
            //System.out.println("PAS");
        }
    }
    System.out.println(BP + "BP/" + MP + "MP");
    nbturn++;
    
    }       
    //Fin
    
    if (BP == 5)
    {
        System.out.println("Eureka!");
    }
    
    else
    {
        System.out.println("Fail, la bonne réponce était" + soluce);
    }
}

}


 /*
        boolean doublon = false;
        int temp = 0;
        
    while (doublon == false) {
        doublon = false;
        for (int i = 0; i < nbcase; i++)
        {
            
             System.out.println("B1 " + soluce.get(i) + "==" + soluce.get(i));
            for (int j = 1; j < nbcase; j++) 
            {
             System.out.println("B2 " + soluce.get(i) + "==" + soluce.get(0+j));
           if (soluce.get(i) == soluce.get(i+j))
            {
               valeur = 0;
                valeur = min + r.nextInt(max - min);
                soluce.add(valeur);
               
            } 
             
             doublon = true;
            }
    }
           
        }
    */