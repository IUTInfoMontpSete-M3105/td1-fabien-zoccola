package fr.umontpellier.cpoa.tp1.users;

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

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}