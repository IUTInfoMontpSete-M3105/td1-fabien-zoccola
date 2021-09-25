package fr.umontpellier.cpoa.tp1.users;

public class Etudiant extends Utilisateur {

    public Etudiant(String prenom, String nom, String adresse, String email, int numEtudiant) {
        super(prenom, nom, adresse, email);
        this.numEtudiant = numEtudiant;
    }

    private final int numEtudiant;

    @Override
    public String toString() {
        return "Etudiant{" +
                "numEtudiant=" + numEtudiant +
                "} from " + super.toString();
    }
}