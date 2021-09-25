package users;

public class Etudiant extends Utilisateur {

    public Etudiant(String prenom, String nom, String adresse, String email, int numEtudiant) {
        super(prenom, nom, adresse, email);
        this.numEtudiant = numEtudiant;
    }

    private final int numEtudiant;

}