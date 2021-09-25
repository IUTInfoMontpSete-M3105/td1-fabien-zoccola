package fr.umontpellier.cpoa.tp1.util.factories;

import fr.umontpellier.cpoa.tp1.users.Utilisateur;

public class UtilisateurFactory {

    public static Utilisateur factory(String prenom)
    {
        return new Utilisateur(prenom, "", "", "");
    }

}
