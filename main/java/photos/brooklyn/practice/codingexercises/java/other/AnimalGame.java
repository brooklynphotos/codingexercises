package photos.brooklyn.practice.codingexercises.java.other;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AnimalGame {
    private List<AnimalCard> player1;
    private List<AnimalCard> player2;

    private static final short DECK_SIZE = 10;

    public AnimalGame() {
        final List<AnimalCard> deck = new AnimalDeck(DECK_SIZE).shuffle();
        player1 = new ArrayList<>(deck.subList(0, DECK_SIZE / 2));
        player2 = new ArrayList<>(deck.subList(DECK_SIZE / 2, DECK_SIZE));
    }

    public void run() {
        while (player1.size() > 0 && player2.size() > 0) {
            playRound(player1, player2);
        }
    }

    static void playRound(final List<AnimalCard> player1, final List<AnimalCard> player2) {
        final AnimalCard p1card = player1.get(0);
        final AnimalCard p2card = player2.get(0);
        if (p1card.isSuperior(p2card)) {
            player1.add(p2card);
            AnimalCard.shuffle(player1);
            player2.remove(0);
        } else if (p2card.isSuperior(p1card)) {
            player2.add(p1card);
            AnimalCard.shuffle(player2);
            player1.remove(0);
        }
        printState(player1, player2);
    }

    static void printState(final List<AnimalCard> player1, final List<AnimalCard> player2) {
        System.out.printf("Player 1: %s%n", StringUtils.join(player1, ","));
        System.out.printf("Player 2: %s%n", StringUtils.join(player2, ","));
    }

    public static void main(String[] args) {
        new AnimalGame().run();
    }
}
