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
    
    public void MaJ(int BPActuel, int MPActuel, ArrayList SoluceActuel);
    public ArrayList Case(int BP, int MP, ArrayList SoluceActuel);
    public void Treat(ArrayList valeur,ArrayList indice, int cas, ArrayList SoluceActuel);
    public ArrayList GenCheck(ArrayList SolucePropose, int cas);
    
}
