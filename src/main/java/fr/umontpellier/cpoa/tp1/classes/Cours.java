package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class Cours {

    public Cours(String nom) {
        this.nom = nom;
        enseignants = new ArrayList<>();
        devoirs = new ArrayList<>();
    }

    private final String nom;
    private Enseignant chargeDeCours;
    private final List<Enseignant> enseignants;
    private final List<Devoir> devoirs;


    public void informerEns(Enseignant e) {
        // TODO implement here
    }

    public void consulterRendu(Rendu r) {
        // TODO implement here
    }

    public void delivrerCertificat(Etudiant e) {
        // TODO implement here
    }

    private void genererCertificat(Etudiant e) {
        // TODO implement here
    }

}