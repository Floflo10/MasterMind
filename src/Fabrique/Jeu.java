package Fabrique;

public class Jeu implements IJeu {


     String typeJeu = null;
    public Jeu(String atypeJeu) throws Exception {
        typeJeu = atypeJeu;
        IFabriqueJeu fv = IFabriqueFabriqueJeu.Create(typeJeu);
       
    }

    @Override
    public void Afficher() {
        System.out.println("je suis une "+ typeJeu);

     }
    
}


