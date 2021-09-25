package users;

import classes.Cours;
import homework.Devoir;
import homework.Rendu;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Utilisateur {

    public Enseignant(String prenom, String nom, String adresse, String email, int numem, String harpege) {
        super(prenom, nom, adresse, email);
        this.numem = numem;
        this.harpege = harpege;
        chargeDe = new ArrayList<>();
        enseigne = new ArrayList<>();
    }

    private final int numem;
    private final String harpege;
    private final List<Cours> chargeDe;
    private final List<Cours> enseigne;


    public Devoir creerDevoir(Cours c) {
        // TODO implement here
        return null;
    }

    public void noter(Rendu r) {
        // TODO implement here
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "numem=" + numem +
                ", harpege='" + harpege + '\'' +
                ", chargeDe=" + chargeDe +
                ", enseigne=" + enseigne +
                "} from " + super.toString();
    }
}