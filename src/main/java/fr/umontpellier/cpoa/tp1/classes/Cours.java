package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class Cours {

    public Cours(String nom, Enseignant chargeDeCours) {
        this.nom = nom;
        this.chargeDeCours = chargeDeCours;
        enseignants = new ArrayList<>();
        devoirs = new ArrayList<>();
        participations = new ArrayList<>();
    }

    private final String nom;
    private Enseignant chargeDeCours;
    private final List<Enseignant> enseignants;
    private final List<Devoir> devoirs;
    private final List<Participation> participations;


    public void changerChargeDeCours(Enseignant e)
    {
        chargeDeCours = e;
    }

    public void ajouterEnseignant(Enseignant e) {
        enseignants.add(e);
    }

    public void delivrerCertificat(Etudiant e) {
        // TODO implement here
    }

    private void genererCertificat(Etudiant e) {
        // TODO implement here
    }

    public void ajouterDevoir(Devoir d)
    {
        devoirs.add(d);
    }

    public void inscrire(Etudiant e)
    {
        participations.add(new Participation(e, this));
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "nom='" + nom + '\'' +
                ", chargeDeCours=" + chargeDeCours +
                ", enseignants=" + enseignants +
                ", devoirs=" + devoirs +
                ", participations=" + participations +
                '}';
    }
}