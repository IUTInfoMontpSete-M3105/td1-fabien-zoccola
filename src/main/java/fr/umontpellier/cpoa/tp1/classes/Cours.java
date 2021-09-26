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

    private static final List<Cours> COURS = new ArrayList<>();

    public static List<Cours> getListeCours() {
        return COURS;
    }

    public static boolean supprimerCours(Cours c)
    {
        return COURS.remove(c);
    }

    public Cours(String nom, Enseignant chargeDeCours) {
        this.nom = nom;
        this.chargeDeCours = chargeDeCours;

        chargeDeCours.ajouterChargeDe(this);

        enseignants = new ArrayList<>();
        devoirs = new ArrayList<>();
        participations = new HashMap<>();

        COURS.add(this);
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
        if (chargeDeCours.equals(e)) return;

        enseignants.add(e);
        e.assignerCours(this);
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
        Participation p = new Participation(e, this);
        participations.put(e, p);
        e.participer(p);
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

    public String getNom() {
        return nom;
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