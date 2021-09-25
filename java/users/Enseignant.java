package users;

import classes.Cours;
import homework.Devoir;
import homework.Rendu;

public class Enseignant extends Utilisateur {

    public Enseignant(String prenom, String nom, String adresse, String email, int numem, String harpege) {
        super(prenom, nom, adresse, email);
        this.numem = numem;
        this.harpege = harpege;
    }

    private final int numem;
    private final String harpege;


    public Devoir creerDevoir(Cours c) {
        // TODO implement here
        return null;
    }

    public void noter(Rendu r) {
        // TODO implement here
    }

}