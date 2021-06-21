package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalDeckTest {

    @Test
    public void shuffle() {
        assertEquals(3, new AnimalDeck(3).shuffle().size());
    }
}