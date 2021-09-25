package fr.umontpellier.cpoa.tp1.homework;

import fr.umontpellier.cpoa.tp1.users.Etudiant;

import java.util.*;

public class Devoir {

    private final List<Rendu> listRendus;
    private final String instructions;
    private final int noteMax;

    public Devoir(String instructions, int noteMax) {
        this.instructions = instructions;
        this.noteMax = noteMax;
        listRendus = new ArrayList<>();
    }

    public String telecharger() {
        return instructions;
    }

    public Rendu rendreDevoir(Etudiant e) {
        Rendu r = new Rendu(this, e);
        listRendus.add(r);
        return r;
    }

    public List<Rendu> getListRendus() {
        return listRendus;
    }

    public int getNoteMax() {
        return noteMax;
    }
}