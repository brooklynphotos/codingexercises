package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalCardTest {

    @Test
    public void testEquals_forSame() {
        final AnimalCard c1 = new AnimalCard(1, Color.BLUE);
        final AnimalCard c2 = new AnimalCard(1, Color.BLUE);
        assertEquals(c1, c2);
    }

    @Test
    public void testEquals_forNotSame() {
        final AnimalCard c1 = new AnimalCard(1, Color.BLUE);
        final AnimalCard c2 = new AnimalCard(1, Color.RED);
        assertNotEquals(c1, c2);
    }

    @Test
    public void shuffle() {
        final List<AnimalCard> cards = Arrays.asList(
                new AnimalCard(1, Color.RED),
                new AnimalCard(2, Color.BLUE),
                new AnimalCard(1, Color.BLUE)
        );
        final List<AnimalCard> copy = new ArrayList<>(cards);
        AnimalCard.shuffle(cards);
        assertEquals(cards.size(), copy.size());
    }

    @Test
    public void isSuperior_True_GivenOneLighterThanOther() {
        final AnimalCard c1 = new AnimalCard(1, Color.RED);
        final AnimalCard c2 = new AnimalCard(2, Color.RED);
        assertTrue(c1.isSuperior(c2));
    }
}