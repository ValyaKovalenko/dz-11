package lesson21;

import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class ManWomanTest {

    @Test
    public void testGetFirstName() {
        Man brad = new Man("Brad", "Pitt", 55);
        Woman andjelina = new Woman("Andjelina", "Joli", 50);

        Assert.assertEquals(brad.getFirstName(), "Brad", "Name is not valid");
        Assert.assertEquals(andjelina.getFirstName(), "Andjelina", "Name is not valid");
    }
    @Test
    public void testGetAge() {
        Man brad = new Man("Brad", "Pitt", 45);
        Woman andjelina = new Woman("Andjelina", "Joli", 40);

        Assert.assertEquals(brad.getAge(), 45, "Man's age is not valid");
        Assert.assertEquals(andjelina.getAge(), 40, "Woman's age is not valid");
    }

    @Test
    public void testHasPartner() {
        Man brad = new Man("Brad", "Pitt", 35);
        Woman andjelina = new Woman("Andjelina", "Joli", 30);

        Assert.assertEquals(brad.getAge(), 35);
        Assert.assertEquals(andjelina.getAge(), 30);

        brad.registerPartnership(andjelina);

        // Перевірка, чи повертається правильний сімейний статус після одруження

        Assert.assertEquals(andjelina.hasPartner(), true, "Woman's state is not valid");
        Assert.assertEquals(brad.hasPartner(), true, "Man's state is not valid");

        brad.deregisterPartnership(true);

        // Перевірка, чи повертається правильний сімейний статус після розлучення

        Assert.assertEquals(andjelina.hasPartner(), false, "Woman's state is not valid");
        Assert.assertEquals(brad.hasPartner(), false, "Man's state is not valid");
    }

    @Test
    public void testRegisterPartnership() {
        Man brad = new Man("Brad", "Pitt", 35);
        Woman andjelina = new Woman("Andjelina", "Joli", 30);

        brad.registerPartnership(andjelina);

        // Перевірка, що повертається правильне прізвище після одруження

        Assert.assertEquals(andjelina.getLastName(), brad.getLastName());
        Assert.assertEquals(brad.getLastName(), "Pitt");
    }

    @Test
    public void testDeregisterPartnership() {
        Man brad = new Man("Brad", "Pitt", 35);
        Woman andjelina = new Woman("Andjelina", "Joli", 30);

        brad.registerPartnership(andjelina);
        brad.deregisterPartnership(true);

        // Перевірка, що повертається правильне прізвище після розлучення

        Assert.assertEquals(andjelina.getLastName(), "Joli");
        Assert.assertEquals(brad.getLastName(), "Pitt");
    }
    @Test
    public void testIsRetired() {
        Man retiredMan = new Man("Retired", "Man", 65);
        Woman retiredWoman = new Woman("Retired", "Woman", 60);
        Man youngMan = new Man("Young", "Man", 64);
        Woman youngWoman = new Woman("Young", "Woman", 59);

        // Перевірка, що повертається правильне значення для пенсіонера та молодшої особи

        Assert.assertEquals(retiredMan.isRetired(), true);
        Assert.assertEquals(retiredWoman.isRetired(), true);
        Assert.assertNotEquals(youngMan.isRetired(), true);
        Assert.assertNotEquals(youngWoman.isRetired(), true);
    }
}