package fr.umontpellier.cpoa.tp1.users;

import fr.umontpellier.cpoa.tp1.classes.Participation;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Utilisateur {

    public Etudiant(String prenom, String nom, String adresse, String email, int numEtudiant) {
        super(prenom, nom, adresse, email);
        this.numEtudiant = numEtudiant;
        participations = new ArrayList<>();
    }

    private final int numEtudiant;
    private final List<Participation> participations;

    public void participer(Participation p)
    {
        participations.add(p);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numEtudiant=" + numEtudiant +
                ", participations=" + participations +
                '}';
    }
}