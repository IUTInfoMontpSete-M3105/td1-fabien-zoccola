package fr.umontpellier.cpoa.tp1.users;

import fr.umontpellier.cpoa.tp1.classes.Cours;
import fr.umontpellier.cpoa.tp1.homework.Devoir;
import fr.umontpellier.cpoa.tp1.homework.Rendu;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EtudiantFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnseignantTest {

    private static final List<Cours> EMPTY_COURS = new ArrayList<>();
    private static final List<Rendu> EMPTY_RENDUS = new ArrayList<>();
    private Enseignant e;

    @BeforeEach
    void setup() throws NoSuchFieldException, IllegalAccessException {
        Field f = Cours.class.getDeclaredField("COURS");
        f.setAccessible(true);
        ((ArrayList<Cours>)f.get(Cours.class)).clear();

        e = EnseignantFactory.factory("Test", 2);
    }

    @Test
    void getEnseignements()
    {
        assertEquals(EMPTY_COURS, e.getEnseignements());

        Cours c = new Cours("Mon Cours", EnseignantFactory.factory("Najib", 1));
        c.ajouterEnseignant(e);

        assertEquals(new ArrayList<Cours>(){{add(c);}}, e.getEnseignements());
    }

    @Test
    void getCharge()
    {
        assertEquals(EMPTY_COURS, e.getChargeDe());

        Cours c = new Cours("Mon cours 2", e);
        assertEquals(new ArrayList<Cours>(){{add(c);}}, e.getChargeDe());
    }

    @Test
    void attribuerRendu()
    {
        Rendu r = new Rendu(
                new Devoir("t", 20),
                EtudiantFactory.factory("", 1)
        );

        assertEquals(EMPTY_RENDUS, e.getRendusAttribues());

        e.attribuerRendu(r);

        assertEquals(new ArrayList<Rendu>(){{add(r);}}, e.getRendusAttribues());
    }

    @Test
    void noter()
    {
        Rendu r = new Rendu(
                new Devoir("t", 20),
                EtudiantFactory.factory("", 1)
        );
        r.ajouterDocument("d");
        r.assignerEns(e);

        e.noter(r, 16);

        assertEquals(16, r.getNote());
    }

}
