package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.*;

public class Devoir {

    private final Map<Etudiant, Rendu> rendus;
    private final String instructions;
    private final int noteMax;

    public Devoir(String instructions, int noteMax) {
        this.instructions = instructions;
        this.noteMax = noteMax;
        rendus = new HashMap<>();
    }

    public String telecharger() {
        return instructions;
    }

    public Rendu rendreDevoir(Etudiant e) {
        if (rendus.containsKey(e)) return null;

        Rendu r = new Rendu(this, e);
        rendus.put(e, r);
        return r;
    }

    public Collection<Rendu> getListRendus() {
        return rendus.values();
    }

    public int getNoteMax() {
        return noteMax;
    }
}