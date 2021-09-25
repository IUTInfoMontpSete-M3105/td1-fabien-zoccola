package fr.umontpellier.cpoa.tp1.users;

import fr.umontpellier.cpoa.tp1.classes.Cours;

public class Admin extends Utilisateur {

    public Admin(String prenom, String nom, String adresse, String email) {
        super(prenom, nom, adresse, email);
    }

    public Cours creerCours(String nom, Enseignant chargeDeCours) {
        return new Cours(nom, chargeDeCours);
    }

    public boolean supprimerCours(Cours c) {
        return Cours.supprimerCours(c);
    }
}