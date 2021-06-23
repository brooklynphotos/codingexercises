package photos.brooklyn.practice.codingexercises.java.other;

import java.util.*;

public class AnimalDeck {

    private static List<AnimalCard> DECK = new ArrayList<>(new HashSet<>(Arrays.asList(
            new AnimalCard(1, Color.RED),
            new AnimalCard(2, Color.RED),
            new AnimalCard(3, Color.RED),
            new AnimalCard(1, Color.YELLOW),
            new AnimalCard(2, Color.YELLOW),
            new AnimalCard(1, Color.BLUE),
            new AnimalCard(2, Color.BLUE),
            new AnimalCard(1, Color.GREEN),
            new AnimalCard(2, Color.GREEN),
            new AnimalCard(3, Color.GREEN)
            )));
    private final List<AnimalCard> cards;

    public AnimalDeck(final int deckSize) {
        // let's not touch the original DECK
        this.cards = new ArrayList<>(DECK.subList(0, deckSize));
    }

    public List<AnimalCard> shuffle() {
        AnimalCard.shuffle(cards);
        return cards;
    }
}
