package photos.brooklyn.practice.codingexercises.java.other;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AnimalCard {
    private int weight;

    @Override
    public String toString() {
        return String.format("(%s, %s)", weight, color);
    }

    public AnimalCard(final int weight, final Color color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AnimalCard that = (AnimalCard) o;
        return weight == that.weight && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }

    private Color color;

    /**
     * shuffles the animal cards
     *
     * @param cards
     */
    public static void shuffle(final List<AnimalCard> cards) {
        Collections.shuffle(cards);
    }

    /**
     * decides if this card is superior to the other card
     *
     * @param otherCard this must be a different card
     * @return
     */
    public boolean isSuperior(final AnimalCard otherCard) {
        if (this.weight < otherCard.weight) return true;
        if (otherCard.weight < this.weight) return false;
        // same weight
        if (this.color.compareTo(otherCard.color) < 0) return true;
        if (this.color.compareTo(otherCard.color) > 0) return false;
        throw new IllegalArgumentException(String.format("Not possible to compare same card, %s vs %s", this, otherCard));
    }
}
