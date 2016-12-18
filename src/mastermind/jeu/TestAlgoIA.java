/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.jeu;

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

public class TestAlgoIA {
   int tabtab[][]= {{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9},{1,2,3,4,5,6,7,8,9}};
 //   int tab[][][] = {{23, 23},{332},{32}};
    int turn = 10;
    int nbcase = 5;
    
    ArrayList soluce = new ArrayList();
    ArrayList essaie = new ArrayList();
    ArrayList BDD = new ArrayList();
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

    }

            soluce = TraitementDoublons(soluce);
        while (nbcase > soluce.size())
        {
            soluce = TraitementDoublons(soluce);
        }

        
        for (int i = 0; i < nbcase; i++) {
            valeur = 0;
            valeur = min + r.nextInt(max - min);
            essaie.add(valeur);
        }
        
                essaie = TraitementDoublons(essaie);
        while (nbcase > essaie.size()) {
            essaie = TraitementDoublons(essaie);
        }
        
        
    //Jeu - 
    

    
        while (nbturn != turn || BP != 5) {

            MP = 0;
            BP = 0;
            essaie.clear();

            System.out.println(essaie);

            Scanner sc = new Scanner(System.in);
            System.out.println("Nombre de Bon Placement: ");
            BP = sc.nextInt();
            System.out.println("Nombre de Mauvais Placement: ");
            MP = sc.nextInt();
            
            TraitementIA(essaie, BP, MP);

 nbturn++;
        }

       

    }
    //Fin

    private void TraitementIA(ArrayList essaie, int BP, int MP) {
        
        
        
    }
    

}
