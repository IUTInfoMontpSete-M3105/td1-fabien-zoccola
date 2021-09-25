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

    public List<Rendu> getRendusAttribues() {
        return rendusAttribues;
    }

    public List<Cours> getChargeDe() {
        return chargeDe;
    }

    public List<Cours> getEnseignements() {
        return enseigne;
    }

    public void assignerCours(Cours c)
    {
        enseigne.add(c);
    }

    public void ajouterChargeDe(Cours c)
    {
        chargeDe.add(c);
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
                "} from " + super.toString();
    }
}