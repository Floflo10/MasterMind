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

    
    public ArrayList test2 (ArrayList soluce)
    {
    Set temp = new HashSet (soluce);
    ArrayList traite = new ArrayList(temp);
    temp = null;
    
    System.out.println("\n" + traite);
    
    while (nbcase > traite.size())
    {
        valeur = min + r.nextInt(max - min);
        traite.add(valeur); 
    }
   
    
   
    for (int i = 0; i < nbcase; i++)
    {
            System.out.println("dsfqIndice = " + i + " valeur :" + traite.get(i));
    }
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
        

        
     System.out.println("Indice = " + i + " valeur :" + soluce.get(i));
    }
    
    //Trie Tableau
            soluce = test2(soluce);
    System.out.println("\n" + soluce);
        while (nbcase > soluce.size())
        {
            System.out.println("sdqf");
            soluce = test2(soluce);
            System.out.println("\n" + soluce);
        }

    //Jeu
        int entreTemp = 0;
        
          Scanner sc = new Scanner(System.in); 
        System.out.println("Prenez 1 : "); 
        int entree = sc.nextInt();
         
        for (int i = (nbcase); i > 0; i--)
        {
        entreTemp = (int) Math.pow(10, i - 1);
        int temp1 = entree / entreTemp;
        int temp2 = entree % entreTemp;
        entree = temp2;
        
        System.out.println(entreTemp);
        System.out.println(entree);
        
        essaie.add(temp1);
        
        System.out.println(essaie);
        }
       /* for (int i = 0; i<soluce.size(); i++)
        {
            essaie.add(i) = x.charAt(i);
                    } */

        
        
    for (int i = 0; i<soluce.size(); i++)
    {
        if (soluce.get(i) == essaie.get(i))
        {
            System.out.println("OK");
        }
        
        else {System.out.println("PAS");}
    }
            
    //Fin
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