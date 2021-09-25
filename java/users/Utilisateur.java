package users;

import java.util.*;

public class Utilisateur {

    public Utilisateur(String prenom, String nom, String adresse, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }

    private final String prenom;
    private final String nom;
    private final String adresse;
    private final String email;

}