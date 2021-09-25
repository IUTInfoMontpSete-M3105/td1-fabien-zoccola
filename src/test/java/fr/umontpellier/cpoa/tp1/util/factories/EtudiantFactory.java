package fr.umontpellier.cpoa.tp1.util.factories;

import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.users.Utilisateur;

public class EtudiantFactory {

    public static Etudiant factory(String prenom, int numEtudiant) {
        return new Etudiant(prenom, "", "", "", numEtudiant);
    }

}
