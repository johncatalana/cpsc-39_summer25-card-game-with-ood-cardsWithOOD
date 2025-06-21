public class Card {
    private String suit;
    private String rank;
    private int value;
    private String picture;

    // Parameterized constructor
    public Card(String suit, String rank, int value, String picture) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.picture = picture;
    }

    // Copy constructor
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
        this.value = other.value;
        this.picture = other.picture;
    }

    // Accessors (getters)
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public String getPicture() {
        return picture;
    }

    // Mutators (setters)
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    // toString method
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}