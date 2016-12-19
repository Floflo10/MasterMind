/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.ia;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Florian
 */
public class IaSansDoublon implements IIa {

    private int BPpre = 0;
    private int MPpre = 0;
    private int BPtemp = 0;
    private int Bloup = 0;
    private int MPtemp = 0;
    private int ValeurChange = 0;
    private Random r = new Random();
    private int IndiceChange = 0;
    private int min = 1;
    private int max = 9;
    private int NewVal;
    private int IndiceSwitch = 0;
    private int Switch = 0;
    private ArrayList GenCheckMem = new ArrayList();
    private ArrayList temp = new ArrayList();
    private ArrayList Indice = new ArrayList();
    private ArrayList Valeur = new ArrayList();
    private int modif = 0;
    private ArrayList memoire = new ArrayList();
    private ArrayList precedent = new ArrayList();
    private ArrayList Soluce = new ArrayList();

    public IaSansDoublon(int nbcase, int max) {

        for (int i = 0; i < nbcase; i++) {
            memoire.add(new ArrayList());
            for (int j = 1; j < max + 1; j++) {
                ((ArrayList) memoire.get(i)).add(j);
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

        for (int i = 1; i <= 9; i++) {
            GenCheckMem.add(i);
        }

        if (modif == 0) {
            if ((BPtemp + MPtemp) == 5 || MPtemp == 5) {
                for (int i = 0; i < Soluce.size(); i++) {
                    Indice.add(i);
                }

                for (int i = 1; i <= 9; i++) {
                    Valeur.add(i);
                }
                for (int i = 0; i < Soluce.size(); i++) {
                    int j = (Integer) Soluce.get(i);

                    temp.add(j);
                }

                if (Valeur.containsAll(temp)) {
                    Valeur.removeAll(temp);
                }

                Treat(Valeur, Indice, 4, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 3);

                Indice.clear();
                Valeur.clear();
                modif = 2;
            } else if (MPtemp == 0 && BPtemp == 0) {
                Valeur = Soluce;

                for (int i = 0; i < 5; i++) {
                    Indice.add(i);
                }

                Treat(Valeur, Indice, 4, Soluce);
                Soluce = GenCheck(Soluce, 2);

                Indice.clear();
                Valeur.clear();

            } else if (BPtemp >= 1 || MPtemp >= 1) {
                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;
                ValeurChange = (Integer) Soluce.get(IndiceChange);
                Soluce = GenCheck(Soluce, 1);

                Indice.clear();
                Valeur.clear();

                modif = 1;
            }

        } else if (modif == 1) {

            if (BPtemp == BPpre && MPtemp == MPpre) {
                Valeur.add(ValeurChange);
                Valeur.add(Soluce.get(IndiceChange));

                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if (BPtemp < BPpre && MPtemp == MPpre) {
                Indice.add(IndiceChange);

                for (int i = 1; i <= 9; i++) {
                    Valeur.add(i);
                }

                Valeur.remove((Integer) ValeurChange);
                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if (BPtemp > BPpre && MPtemp == MPpre) {
                for (int i = 1; i <= 9; i++) {
                    Valeur.add(i);
                }

                ValeurChange = (Integer) Soluce.get(IndiceChange);
                Valeur.remove((Integer) ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if (MPtemp < MPpre && BPtemp == BPpre) {
                Valeur.add(ValeurChange);
                Indice.add(IndiceChange);

                Valeur.clear();
                Valeur.add(Soluce.get(IndiceChange));

                Treat(Valeur, Indice, 1, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if (MPtemp > MPpre && BPtemp == BPpre) {

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();
            } else if (MPtemp < MPpre && BPtemp > BPpre) {
                for (int i = 1; i <= 9; i++) {
                    Valeur.add(i);
                }

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Valeur.remove((Integer) ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if (MPtemp > MPpre && BPtemp < BPpre) {
                Valeur.add(ValeurChange);
                Indice.add(IndiceChange);

                Valeur.clear();
                Indice.clear();

                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }

                Valeur.remove((Integer) ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 1);
                Indice.clear();
                Valeur.clear();

            } else if ((BPtemp + MPtemp) == 5 || MPtemp == 5) {
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
                            Valeur.remove((Integer) j);
                        }
                    }
                }

                Treat(Valeur, Indice, 4, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 3);

                Indice.clear();
                Valeur.clear();

                modif = 2;
            }
        } else if (modif == 2) {

            if (MPtemp < MPpre && BPtemp > BPpre) {
                for (int i = 1; i <= 9; i++) {
                    Valeur.add(i);
                }

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Valeur.remove((Integer) ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                Indice.clear();
                Valeur.clear();

                for (int i = 0; i < Soluce.size(); i++) {
                    Indice.add(i);
                }

                Valeur.add(ValeurChange);

                Treat(Valeur, Indice, 2, Soluce);

                Indice.clear();
                Valeur.clear();

                Valeur.add(ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 5, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 3);
                Indice.clear();
                Valeur.clear();

            } else if (MPtemp > MPpre && BPtemp < BPpre) {

                for (int i = 1; i < 9; i++) {
                    Valeur.add(i);
                }

                Valeur.remove((Integer) ValeurChange);
                Indice.add(IndiceChange);

                Treat(Valeur, Indice, 3, Soluce);

                precedent = Soluce;
                BPpre = BP;
                MPpre = MP;

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Soluce = GenCheck(Soluce, 3);
                Indice.clear();
                Valeur.clear();

            }

        }
        return Soluce;
    }

    @Override
    public void Treat(ArrayList valeur, ArrayList indice, int cas, ArrayList SoluceActuel) {

        switch (cas) {
            case 1:
                ((ArrayList) memoire.get((Integer) indice.get(0))).remove((Integer) valeur.get(0));
                break;
            case 2:
                for (int i = 0; i < indice.size(); i++) {
                    ((ArrayList) memoire.get((Integer) indice.get(i))).remove((Integer) valeur.get(0));
                }
                break;
            case 3:
                for (int i = 0; i < valeur.size(); i++) {
                    ((ArrayList) memoire.get((Integer) indice.get(0))).remove((Integer) valeur.get(i));
                }
                break;
            case 4:
                for (int i = 0; i < indice.size(); i++) {
                    for (int j = 0; j < valeur.size(); j++) {
                        ((ArrayList) memoire.get((Integer) indice.get(i))).remove((Integer) valeur.get(j));

                    }
                }
                break;
            case 5:
                ((ArrayList) memoire.get((Integer) indice.get(0))).add((Integer) valeur.get(0));
                break;
        }
    }

    @Override
    public ArrayList GenCheck(ArrayList SolucePropose, int cas) {

        if (GenCheckMem.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                GenCheckMem.add(i);
            }
        }

        if (IndiceChange >= 4) {
            IndiceChange = 0;
            ValeurChange = (Integer) Soluce.get(IndiceChange);
        }

        switch (cas) {
            case 1:
                IndiceChange++;

                if (((ArrayList) memoire.get(IndiceChange)).size() == 1) {
                    IndiceChange++;
                    if (IndiceChange >= 4) {
                        IndiceChange = 0;
                    }
                    ValeurChange = (Integer) Soluce.get(IndiceChange);
                    if (IndiceChange > 4) {
                        IndiceChange = 0;
                        ValeurChange = (Integer) Soluce.get(IndiceChange);
                    }
                }

                Bloup = min + r.nextInt(GenCheckMem.size() - min);
                NewVal = (Integer) GenCheckMem.get(Bloup);

                if (GenCheckMem.isEmpty()) {
                    for (int i = 1; i <= 9; i++) {
                        GenCheckMem.add(i);
                    }
                }

                if (((ArrayList) memoire.get(IndiceChange)).contains(NewVal) && NewVal != (Integer) Soluce.get(IndiceChange)) {
                    for (int i = IndiceChange - 1; i > 0; i--) {
                        int temporal = (Integer) SolucePropose.get(i);
                        if (temporal == NewVal) {
                            GenCheckMem.remove((Integer) NewVal);
                            GenCheck(SolucePropose, 1);
                        }
                    }

                    for (int i = IndiceChange + 1; i < 5; i++) {
                        int tempest = (Integer) SolucePropose.get(i);
                        if (tempest == NewVal) {
                            GenCheckMem.remove((Integer) NewVal);
                            GenCheck(SolucePropose, 1);
                        }
                    }
                    SolucePropose.set(IndiceChange, NewVal);

                    test(Soluce, 1);

                } else {
                    GenCheckMem.remove((Integer) NewVal);
                    GenCheck(SolucePropose, 1);
                }

                break;

            case 2:
                for (int i = 0; i < 5; i++) {

                    Bloup = min + r.nextInt(GenCheckMem.size() - min);
                    NewVal = (Integer) GenCheckMem.get(Bloup);

                    if (((ArrayList) memoire.get(i)).contains(NewVal) && NewVal != (Integer) Soluce.get(IndiceChange)) {

                        SolucePropose.set(i, NewVal);

                        for (int j = i - 1; j > 0; j--) {
                            int temporal = (Integer) SolucePropose.get(j);
                            if (temporal == NewVal) {
                                GenCheckMem.remove((Integer) NewVal);
                                GenCheck(SolucePropose, 2);
                            }
                        }

                        for (int j = i + 1; j < 5; j++) {
                            int tempest = (Integer) SolucePropose.get(j);
                            if (tempest == NewVal) {
                                GenCheckMem.remove((Integer) NewVal);
                                GenCheck(SolucePropose, 2);
                            }
                        }

                    } else {
                        GenCheckMem.remove((Integer) NewVal);
                        GenCheck(SolucePropose, 2);
                    }

                }
                break;

            case 3:

                IndiceChange++;

                if (((ArrayList) memoire.get(IndiceChange)).size() == 1) {
                    IndiceChange++;
                    if (IndiceChange > 4) {
                        IndiceChange = 0;
                    }
                }

                ValeurChange = (Integer) Soluce.get(IndiceChange);

                Bloup = min + r.nextInt(GenCheckMem.size() - min);
                NewVal = (Integer) GenCheckMem.get(Bloup);

                if (((ArrayList) memoire.get(IndiceChange)).contains(NewVal) && NewVal != (Integer) Soluce.get(IndiceChange)) {
                    for (int i = IndiceChange - 1; i > 0; i--) {
                        if (Soluce.get(i).equals(NewVal)) {
                            IndiceSwitch = i;
                        }
                    }

                    for (int i = IndiceChange + 1; i < 5; i++) {
                        if (Soluce.get(i).equals(NewVal)) {
                            IndiceSwitch = i;
                        }
                    }

                    Switch = (Integer) Soluce.get(IndiceSwitch);

                    SolucePropose.set(IndiceSwitch, ValeurChange);
                    SolucePropose.set(IndiceChange, Switch);

                    test(Soluce, 2);

                } else {
                    GenCheckMem.remove((Integer) NewVal);
                    GenCheck(SolucePropose, 3);
                }

                break;

        }

        GenCheckMem.clear();

        return SolucePropose;
    }

    /**
     * Méthode de vérification des doublons
     * @param test Tableau à tester
     * @param cas Numero du cas
     */
    public void test(ArrayList test, int cas) {

        Set temp = new TreeSet(test);

        switch (cas) {
            case 1:

                if (temp.size() < 5) {
                    GenCheck(Soluce, 1);
                }
                break;

            case 2:
                if (temp.size() < 5) {
                    GenCheck(Soluce, 3);
                }
                break;

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

    /**
     * @return the Bloup
     */
    public int getBloup() {
        return Bloup;
    }

    /**
     * @param Bloup the Bloup to set
     */
    public void setBloup(int Bloup) {
        this.Bloup = Bloup;
    }

    /**
     * @return the NewVal
     */
    public int getNewVal() {
        return NewVal;
    }

    /**
     * @param NewVal the NewVal to set
     */
    public void setNewVal(int NewVal) {
        this.NewVal = NewVal;
    }

    /**
     * @return the IndiceSwitch
     */
    public int getIndiceSwitch() {
        return IndiceSwitch;
    }

    /**
     * @param IndiceSwitch the IndiceSwitch to set
     */
    public void setIndiceSwitch(int IndiceSwitch) {
        this.IndiceSwitch = IndiceSwitch;
    }

    /**
     * @return the Switch
     */
    public int getSwitch() {
        return Switch;
    }

    /**
     * @param Switch the Switch to set
     */
    public void setSwitch(int Switch) {
        this.Switch = Switch;
    }

    /**
     * @return the GenCheckMem
     */
    public ArrayList getGenCheckMem() {
        return GenCheckMem;
    }

    /**
     * @param GenCheckMem the GenCheckMem to set
     */
    public void setGenCheckMem(ArrayList GenCheckMem) {
        this.GenCheckMem = GenCheckMem;
    }

    /**
     * @return the modif
     */
    public int getModif() {
        return modif;
    }

    /**
     * @param modif the modif to set
     */
    public void setModif(int modif) {
        this.modif = modif;
    }

}
