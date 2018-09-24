package com.josephpark.pokerpal;

enum Rank{
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
}
enum Suit{
    SPADES,
    CLUBS,
    DIAMONDS,
    HEARTS
}

public class Card {
    private Rank rank;
    private Suit suit;

    Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank(){return rank;}
    public Suit getSuit(){return suit;}

}
/*
    For a different class, but not sure/haven't created it yet:

    for(Suit s : Suit.values()) {
        for (Rank r : Rank.values()) {
            new Card(r,s);
        }
    }

 */
