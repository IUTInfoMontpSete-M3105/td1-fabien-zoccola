package fr.umontpellier.cpoa.tp1.users;

import fr.umontpellier.cpoa.tp1.classes.Cours;
import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Utilisateur {

    public Enseignant(String prenom, String nom, String adresse, String email, int numem, String harpege) {
        super(prenom, nom, adresse, email);

        this.numem = numem;
        this.harpege = harpege;

        chargeDe = new ArrayList<>();
        enseigne = new ArrayList<>();
        rendusAttribues = new ArrayList<>();
    }

    private final int numem;
    private final String harpege;
    private final List<Cours> chargeDe;
    private final List<Cours> enseigne;
    private final List<Rendu> rendusAttribues;


    public Devoir creerDevoir(Cours c) {
        // TODO implement here
        return null;
    }

    public List<Rendu> getRendusAttribues() {
        return rendusAttribues;
    }

    public void noter(Rendu r, int n) {
        r.saisirNote(n);
    }

    public void attribuerRendu(Rendu r)
    {
        rendusAttribues.add(r);
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