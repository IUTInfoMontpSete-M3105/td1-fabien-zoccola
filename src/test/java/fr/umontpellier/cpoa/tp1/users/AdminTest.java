package fr.umontpellier.cpoa.tp1.users;

import fr.umontpellier.cpoa.tp1.classes.Cours;
import fr.umontpellier.cpoa.tp1.util.factories.AdminFactory;
import fr.umontpellier.cpoa.tp1.util.factories.EnseignantFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminTest {

    private static Enseignant ens;
    private Cours c1;
    private static Admin a;

    @BeforeAll
    static void before()
    {
        ens = EnseignantFactory.factory("Test", 2);
        a = AdminFactory.factory("Admin");
    }

    @BeforeEach
    void setup() throws NoSuchFieldException, IllegalAccessException {
        Field f = Cours.class.getDeclaredField("COURS");
        f.setAccessible(true);
        ((ArrayList<Cours>)f.get(Cours.class)).clear();

        c1 = new Cours("Test", ens);
    }

    @Test
    void creerCours()
    {
        Cours c2 = a.creerCours("Test2", ens);
        assertEquals(new ArrayList<Cours>(){{add(c1);add(c2);}}, Cours.getListeCours());
    }

    @Test
    void supprimerCours()
    {
        assertTrue(a.supprimerCours(c1));
        assertEquals(new ArrayList<Cours>(), Cours.getListeCours());
    }

}
