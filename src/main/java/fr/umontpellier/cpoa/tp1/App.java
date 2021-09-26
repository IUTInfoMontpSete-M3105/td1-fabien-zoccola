package fr.umontpellier.cpoa.tp1;

import fr.umontpellier.cpoa.tp1.classes.Cours;
import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.users.Admin;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;

public class App {

    public static void main(String[] args) {

        Enseignant ens1 = new Enseignant("Najib", "Lazaar", "", "najib.lazaar@umontpellier.fr", 1, "truc");
        Enseignant ens2 = new Enseignant("Simon", "Robillard", "", "simon.robillard@umontpellier.fr", 2, "muche");

        Etudiant e1 = new Etudiant("Fabien", "Zoccola", "", "fabien.zoccola@etu.umontpellier.fr", 123);
        Etudiant e2 = new Etudiant("Paul", "Hoareau", "", "paul.hoareau@etu.umontpellier.fr", 456);

        Admin admin = new Admin("Alain", "Terrieur", "", "admin@admin.fr");

        // créer le cours
        Cours c = admin.creerCours("CPOA", ens1);

        // ajouter enseignant et élèves
        c.ajouterEnseignant(ens2);
        c.inscrire(e1);
        c.inscrire(e2);

        // créer et ajouter les devoirs
        Devoir d1 = new Devoir("Faire le TP", 20);
        Devoir d2 = new Devoir("Faire le TP", 20);
        c.ajouterDevoir(d1);
        c.ajouterDevoir(d2);

        // créer les rendus des élèves
        Rendu r11 = d1.rendreDevoir(e1);
        Rendu r21 = d2.rendreDevoir(e1);
        Rendu r12 = d1.rendreDevoir(e2);
        Rendu r22 = d2.rendreDevoir(e2);

        // ajouter les documents (un est laissé vide)
        r11.ajouterDocument("truc");
        r21.ajouterDocument("bidule");
        r12.ajouterDocument("muche");

        // on assigne les enseignants
        r11.assignerEns(ens1);
        r21.assignerEns(ens2);
        r12.assignerEns(ens1);
        r22.assignerEns(ens2);

        r11.saisirNote(15);
        r21.saisirNote(11);
        r12.saisirNote(18);
        r22.saisirNote(16); // ne devrait pas fonctionner vu que le rendu est vide, la note est 0

        c.delivrerCertificats();

        System.out.println(e1);
        System.out.println(e2);

    }

}
