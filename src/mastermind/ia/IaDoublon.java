/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.ia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Florian
 */
public class IaDoublon implements IIa {
    
    private int BPpre = 0;
    private int MPpre = 0;
    private int BPtemp = 0;
    private int MPtemp = 0;
    private int ValeurChange = 0;
        private Random r = new Random();
    private int IndiceChange = 0;
        private int min = 1;
    private int max = 9;
    private ArrayList temp;
    private ArrayList Indice = new ArrayList();
    private ArrayList Valeur = new ArrayList();
    private boolean modif = false;
    private ArrayList memoire = new ArrayList();
    private ArrayList precedent = new ArrayList();
    private ArrayList Soluce = new ArrayList();
    
    
    public IaDoublon (int nbcase, int max){
        
                
        for(int i=0; i<nbcase; i++){
            memoire.add(new ArrayList());
            for(int j=1; j<max+1; j++){
                ((ArrayList)memoire.get(i)).add(j);                
            }
            
        }
    
}

    @Override
    public void MaJ(int BPActuel, int MPActuel, ArrayList SoluceActuel) {
        setBPtemp(BPActuel);
        setMPtemp(MPActuel);
        setSoluce(SoluceActuel);
    }

    @Override
    public ArrayList Case(int BP, int MP, ArrayList SoluceActuel) {

        MaJ(BP, MP, SoluceActuel);
        
        System.out.println("BP = " + BPtemp);
        System.out.println("MP = " + MPtemp);

        if (!modif) {
            if ((BPtemp + MPtemp) == 5 || MPtemp == 5) {
System.out.println("1");
                for (int i = 0; i < Soluce.size(); i++) {
                    Indice.add(i);
                }

                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }

                for (int i = 0; i < Soluce.size(); i++) {
                    int j = (Integer) Soluce.get(i);

                    temp.add(j);
                }

                for (int i = 0; i < Valeur.size(); i++) {
                    for (int j = 0; j < temp.size(); j++) {
                        if (Valeur.get(i) == temp.get(j)) {
                            Valeur.remove(j);
                        }
                    }
                }

                Treat(Valeur, Indice, 4, Soluce);

                precedent = Soluce;
                BPpre = BP;

                Soluce = GenCheck(Soluce, 1);

                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
                modif = true;
            }
            
            else if (MPtemp == 0 && BPtemp == 0) {
                System.out.println("2");
                Valeur = Soluce;
                
                for (int i = 0; i<5; i++)
                {
                    Indice.add(i);
                }
                
                Treat(Valeur, Indice, 4, Soluce);
                Soluce = GenCheck(Soluce, 2);
                                
                Indice.clear();
                Valeur.clear();

            }
            
            else if (BPtemp >= 1 || MPtemp >= 1){
                System.out.println("3");
                precedent = Soluce;
                BPpre = BP;
                ValeurChange = (Integer) Soluce.get(IndiceChange);
                Soluce = GenCheck(Soluce, 1);
                
                Indice.clear();
                Valeur.clear();
                
                modif = true;
            }

        } 
        
        else {
            
            if (BPtemp == BPpre && MPtemp == MPpre){
                System.out.println("4.1");
                Valeur.add(ValeurChange);
                Valeur.add(Soluce.get(IndiceChange));
                
                Indice.add(IndiceChange);
                
                Treat(Valeur, Indice, 3, Soluce);
                
                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
            }
            
            else if (BPtemp < BPpre && MPtemp == MPpre){
                System.out.println("4.2");
                Valeur.add(ValeurChange);
                Indice.add(IndiceChange); 
                
                Treat(Valeur, Indice, 5, Soluce);
                 
                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }
                
                Valeur.remove(ValeurChange);
                
                Treat(Valeur, Indice, 3, Soluce);
                
                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
            }
            
            else if (BPtemp > BPpre && MPtemp == MPpre){
                System.out.println("4.3");
                                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }
                
                Valeur.remove(ValeurChange);
                Indice.add(IndiceChange);
                
                Treat(Valeur, Indice, 3, Soluce);
                
                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
            }
            
            
            else if (MPtemp < MPpre && BPtemp == BPpre){
                System.out.println("4.4");
                Valeur.add(ValeurChange);
                Indice.add(IndiceChange); 
                
                Treat(Valeur, Indice, 5, Soluce);
                 
                Valeur.clear();
                Valeur.add(Soluce.get(IndiceChange));
                
                Treat(Valeur, Indice, 1, Soluce);           
                
                
                
                IndiceChange++;
                
                
                
                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
            }
            
            else if (MPtemp > MPpre && BPtemp == BPpre){
                System.out.println("4.5");
                                IndiceChange++;
                
                
                
                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);
            }
            
            else if (MPtemp < MPpre && BPtemp > BPpre){
                System.out.println("4.6");
                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }

                Valeur.remove(ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);            
                
                
            }
            
            else if (MPtemp > MPpre && BPtemp < BPpre){
                System.out.println("4.7");
                Valeur.add(ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 5, Soluce);

                Valeur.clear();
                Indice.clear(); 

                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }

                Valeur.remove(ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
                ValeurChange = (Integer) Soluce.get(IndiceChange);            
                
            }
        }
return Soluce;
    }

    @Override
    public void Treat(ArrayList valeur, ArrayList indice, int cas, ArrayList SoluceActuel) {
        int sind = (Integer) indice.get(0);
        int sval = (Integer) valeur.get(0);

        switch (cas) {
            case 1:
                ((ArrayList) memoire.get(sind)).remove(sval);
                break;
            case 2:
                for (int i = 0; i < indice.size(); i++) {
                    int k = (Integer) indice.get(i);
                    ((ArrayList) memoire.get(k)).remove(sind);
                }
                break;
            case 3:
                for (int i = 0; i < valeur.size(); i++) {
                    int l = (Integer) valeur.get(i);
                    ((ArrayList) memoire.get(sind)).remove(l);
                }
                break;
            case 4:
                for (int i = 0; i < indice.size(); i++) {
                    for (int j = 0; j < valeur.size(); j++) {
                        int k = (Integer) indice.get(i);
                        int l = (Integer) valeur.get(j);
                        ((ArrayList) memoire.get(k)).remove(l);
                    }
                }
                break;
            case 5:
                ((ArrayList) memoire.get(sind)).add(sval);
                break;
        }
    }

    @Override
    public ArrayList GenCheck(ArrayList SolucePropose, int cas) {

        int NewVal;
        
        if(IndiceChange > 5){
            IndiceChange = 0;
        }
        switch (cas) {
            case 1:

                if (((ArrayList) memoire.get(IndiceChange)).size() == 1) {
                    IndiceChange++;
            if(IndiceChange > 5){
            IndiceChange = 0;
        }
                }

                NewVal = min + r.nextInt(max - min);

                if (((ArrayList) memoire.get(IndiceChange)).contains(NewVal) && NewVal != (Integer) Soluce.get(IndiceChange)) {

                    SolucePropose.set(IndiceChange, NewVal);

                    for (int i = IndiceChange - 1; i > 0; i--) {
                        int temporal = (Integer) SolucePropose.get(i);
                        if (temporal == NewVal) {
                            GenCheck(SolucePropose, 1);
                        }
                    }

                    for (int i = IndiceChange + 1; i < 5; i++) {
                        int tempest = (Integer) SolucePropose.get(i);
                        if (tempest == NewVal) {
                            GenCheck(SolucePropose, 1);
                        }
                    }
                    
                    test(Soluce);

                } else {
                    GenCheck(SolucePropose, 1);
                }
                break;

            case 2:
                for (int i = 0; i < 5; i++) {

                    NewVal = min + r.nextInt(max - min);

                    if (((ArrayList) memoire.get(i)).contains(NewVal)) {

                        SolucePropose.set(i, NewVal);

                        for (int j = i - 1; j > 0; j--) {
                            int temporal = (Integer) SolucePropose.get(j);
                            if (temporal == NewVal) {
                                GenCheck(SolucePropose, 2);
                            }
                        }

                        for (int j = i + 1; j < 5; j++) {
                            int tempest = (Integer) SolucePropose.get(j);
                            if (tempest == NewVal) {
                                GenCheck(SolucePropose, 2);
                            }
                        }

                    } else {
                        GenCheck(SolucePropose, 2);
                    }

                }
                break;

        }
        return SolucePropose;
    }
public void test(ArrayList test){
    
            Set temp = new HashSet(Soluce);
        ArrayList traite = new ArrayList(temp);
        
    if(traite.size() < 5)
    {
        GenCheck(Soluce, 1);
    }
}
    /**
     * @return the BPpre
     */
    public int getBPpre() {
        return BPpre;
    }

    /**
     * @param BPpre the BPpre to set
     */
    public void setBPpre(int BPpre) {
        this.BPpre = BPpre;
    }

    /**
     * @return the MPpre
     */
    public int getMPpre() {
        return MPpre;
    }

    /**
     * @param MPpre the MPpre to set
     */
    public void setMPpre(int MPpre) {
        this.MPpre = MPpre;
    }

    /**
     * @return the BPtemp
     */
    public int getBPtemp() {
        return BPtemp;
    }

    /**
     * @param BPtemp the BPtemp to set
     */
    public void setBPtemp(int BPtemp) {
        this.BPtemp = BPtemp;
    }

    /**
     * @return the MPtemp
     */
    public int getMPtemp() {
        return MPtemp;
    }

    /**
     * @param MPtemp the MPtemp to set
     */
    public void setMPtemp(int MPtemp) {
        this.MPtemp = MPtemp;
    }

    /**
     * @return the ValeurChange
     */
    public int getValeurChange() {
        return ValeurChange;
    }

    /**
     * @param ValeurChange the ValeurChange to set
     */
    public void setValeurChange(int ValeurChange) {
        this.ValeurChange = ValeurChange;
    }

    /**
     * @return the r
     */
    public Random getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(Random r) {
        this.r = r;
    }

    /**
     * @return the IndiceChange
     */
    public int getIndiceChange() {
        return IndiceChange;
    }

    /**
     * @param IndiceChange the IndiceChange to set
     */
    public void setIndiceChange(int IndiceChange) {
        this.IndiceChange = IndiceChange;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the temp
     */
    public ArrayList getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(ArrayList temp) {
        this.temp = temp;
    }

    /**
     * @return the Indice
     */
    public ArrayList getIndice() {
        return Indice;
    }

    /**
     * @param Indice the Indice to set
     */
    public void setIndice(ArrayList Indice) {
        this.Indice = Indice;
    }

    /**
     * @return the Valeur
     */
    public ArrayList getValeur() {
        return Valeur;
    }

    /**
     * @param Valeur the Valeur to set
     */
    public void setValeur(ArrayList Valeur) {
        this.Valeur = Valeur;
    }

    /**
     * @return the modif
     */
    public boolean isModif() {
        return modif;
    }

    /**
     * @param modif the modif to set
     */
    public void setModif(boolean modif) {
        this.modif = modif;
    }

    /**
     * @return the memoire
     */
    public ArrayList getMemoire() {
        return memoire;
    }

    /**
     * @param memoire the memoire to set
     */
    public void setMemoire(ArrayList memoire) {
        this.memoire = memoire;
    }

    /**
     * @return the precedent
     */
    public ArrayList getPrecedent() {
        return precedent;
    }

    /**
     * @param precedent the precedent to set
     */
    public void setPrecedent(ArrayList precedent) {
        this.precedent = precedent;
    }

    /**
     * @return the Soluce
     */
    public ArrayList getSoluce() {
        return Soluce;
    }

    /**
     * @param Soluce the Soluce to set
     */
    public void setSoluce(ArrayList Soluce) {
        this.Soluce = Soluce;
    }

    
    
    
    
    
    
    
    
    
    
    
  

    
}
