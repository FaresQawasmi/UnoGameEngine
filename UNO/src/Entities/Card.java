package Entities;

import java.util.Objects;

// Card class representing Uno cards
public class Card {
    private String color;
    private final String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public boolean isActionCard() {
        return value.equals("Reverse") || value.equals("Skip") || value.equals("Draw Two");
    }

    public boolean isWildCard() {
        return value.equals("Wild") || value.equals("Wild Draw Four");
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card otherCard = (Card) obj;
        return Objects.equals(value, otherCard.value) && color.equals(otherCard.color);
    }
}