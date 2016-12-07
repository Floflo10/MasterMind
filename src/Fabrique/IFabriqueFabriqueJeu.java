package Fabrique;

public interface IFabriqueFabriqueJeu {


    public static IFabriqueJeu Create(String Jeu) throws Exception {
        if (Jeu.equals("JeuJoueur")) return new FabriqueJeuJoueur();
        if (Jeu.equals("JeuJoueurDoublon")) return new FabriqueJeuJoueurDoublon();
        if (Jeu.equals("JeuIA")) return new FabriqueJeuIA();
        if (Jeu.equals("JeuIADoublon")) return new FabriqueJeuIADoublon();
        throw new Exception("Erreur Create IFabriqueJeu");

}
}
