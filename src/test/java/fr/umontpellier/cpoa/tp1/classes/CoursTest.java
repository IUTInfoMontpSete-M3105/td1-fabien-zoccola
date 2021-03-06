package fr.umontpellier.cpoa.tp1.classes;

import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.users.Enseignant;
import fr.umontpellier.cpoa.tp1.users.Etudiant;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CoursTest {

    private Cours c;

    @BeforeEach
    void setup() throws NoSuchFieldException, IllegalAccessException
    {
        Field f = Cours.class.getDeclaredField("COURS");
        f.setAccessible(true);
        ((ArrayList<Cours>)f.get(Cours.class)).clear();

        Enseignant chargeDeCours = EnseignantFactory.factory("Najib", 1);
        c = new Cours("test", chargeDeCours);
    }

    @Test
    void inscrireEtudiant()
    {
        Etudiant e1 = EtudiantFactory.factory("Fabien", 123);
        Etudiant e2 = EtudiantFactory.factory("Paul", 456);

        c.inscrire(e1);
        c.inscrire(e2);

        Map<Etudiant, Participation> expected = new HashMap<>() {{
            put(e1, new Participation(e1, c)); put(e2, new Participation(e2, c));
        }};
        Map<Etudiant, Participation> actual = c.getParticipations();

        assertTrue(actual.entrySet().containsAll(expected.entrySet())
                && expected.entrySet().containsAll(expected.entrySet()));
    }

    @Test
    void ajouterDevoir()
    {
        Devoir d = new Devoir("Faire le TP1", 20);
        c.ajouterDevoir(d);

        List<Devoir> expected = new ArrayList<>() {{
            add(d);
        }};
        List<Devoir> actual = c.getDevoirs();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void changerChargeDeCours()
    {
        Enseignant e = EnseignantFactory.factory("Test", 2);
        c.changerChargeDeCours(e);
        assertEquals(e, c.getChargeDeCours());
    }

    @Test
    void ajouterEnseignant()
    {
        Enseignant e = EnseignantFactory.factory("Test", 2);
        c.ajouterEnseignant(e);
        assertEquals(new ArrayList<Enseignant>(){{add(e);}}, c.getEnseignants());
    }

    @Test
    void coursInListCours()
    {
        assertEquals(new ArrayList<Cours>(){{add(c);}}, Cours.getListeCours());
    }

    @Test
    void supprimerCours()
    {
        Cours.supprimerCours(c);
        assertEquals(new ArrayList<Cours>(), Cours.getListeCours());
    }

}
