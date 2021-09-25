package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cours {

    public Cours(String nom, Enseignant chargeDeCours) {
        this.nom = nom;
        this.chargeDeCours = chargeDeCours;
        enseignants = new ArrayList<>();
        devoirs = new ArrayList<>();
        participations = new HashMap<>();
    }

    private final String nom;
    private Enseignant chargeDeCours;
    private final List<Enseignant> enseignants;
    private final List<Devoir> devoirs;
    private final Map<Etudiant, Participation> participations;


    public void changerChargeDeCours(Enseignant e)
    {
        chargeDeCours = e;
    }

    public void ajouterEnseignant(Enseignant e) {
        enseignants.add(e);
    }

    public void delivrerCertificats() {
        int totalNotes = genererCertificats();
        for (Participation p : participations.values())
        {
            p.updateStatusUsingAverage(totalNotes);
            if (p.shouldRecieveCertificat()) p.setCertificat("Cours de CPOA réussi");
        }
    }

    private int genererCertificats() {
        for (Participation p : participations.values()) p.commencerCalcul();

        int totalNotes = 0;
        for (Devoir d : devoirs)
        {
            totalNotes += d.getNoteMax();
            for (Rendu r : d.getListRendus())
            {
                participations.get(r.getEtudiant()).ajouterPoints(r.getNote());
            }
        }

        for (Participation p : participations.values()) p.finirCalcul();

        return totalNotes;
    }

    public void ajouterDevoir(Devoir d)
    {
        devoirs.add(d);
    }

    public List<Devoir> getDevoirs() {
        return devoirs;
    }

    public void inscrire(Etudiant e)
    {
        participations.put(e, new Participation(e, this));
    }

    public Map<Etudiant, Participation> getParticipations() {
        return participations;
    }

    public Enseignant getChargeDeCours() {
        return chargeDeCours;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
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