package com.josephpark.pokerpal;

import org.junit.Test;

import java.util.ArrayList;

import static com.josephpark.pokerpal.HandRanking.*;
import static org.junit.Assert.*;

public class HandRankingTest {

    @Test
    public void TestFalseFlush() {
        Card cardA = new Card(Rank.ACE, Suit.SPADES);
        Card cardB = new Card(Rank.JACK, Suit.CLUBS);
        Card cardC = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardE = new Card(Rank.TEN, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardB);
        testHand.add(cardD);
        testHand.add(cardA);
        testHand.add(cardE);
        testHand.add(cardC);

        assertEquals(false, isFlush(testHand));
    }

    @Test
    public void TestTrueFlush() {
        Card cardA = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardB = new Card(Rank.JACK, Suit.DIAMONDS);
        Card cardC = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardE = new Card(Rank.TWO, Suit.DIAMONDS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardB);
        testHand.add(cardD);
        testHand.add(cardA);
        testHand.add(cardE);
        testHand.add(cardC);

        assertEquals(true, isFlush(testHand));
    }

    @Test
    public void TestFalseStraight() {
        Card cardA = new Card(Rank.ACE, Suit.SPADES);
        Card cardB = new Card(Rank.JACK, Suit.CLUBS);
        Card cardC = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardE = new Card(Rank.TEN, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardB);
        testHand.add(cardD);
        testHand.add(cardA);
        testHand.add(cardE);
        testHand.add(cardC);

        assertEquals(false, isStraight(testHand));
    }
    @Test
    public void TestTrueStraight() {
        Card cardA = new Card(Rank.QUEEN, Suit.SPADES);
        Card cardB = new Card(Rank.JACK, Suit.CLUBS);
        Card cardC = new Card(Rank.NINE, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardE = new Card(Rank.EIGHT, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardB);
        testHand.add(cardD);
        testHand.add(cardA);
        testHand.add(cardE);
        testHand.add(cardC);

        assertEquals(true, isStraight(testHand));
    }

    @Test
    public void TestLowAceStraight() {
        Card cardA = new Card(Rank.ACE, Suit.SPADES);
        Card cardB = new Card(Rank.THREE, Suit.CLUBS);
        Card cardC = new Card(Rank.FOUR, Suit.DIAMONDS);
        Card cardD = new Card(Rank.FIVE, Suit.DIAMONDS);
        Card cardE = new Card(Rank.TWO, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardB);
        testHand.add(cardD);
        testHand.add(cardA);
        testHand.add(cardE);
        testHand.add(cardC);

        assertEquals(true, isStraight(testHand));
    }

    @Test
    public void TestHighAceStraight() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.JACK, Suit.CLUBS);
        Card cardC = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardE = new Card(Rank.KING, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(true, isStraight(testHand));
    }

    @Test
    public void TestFalse4set() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.JACK, Suit.CLUBS);
        Card cardC = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardE = new Card(Rank.KING, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(false, is4set(testHand));
    }

    @Test
    public void TestTrue4set() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.TEN, Suit.CLUBS);
        Card cardC = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardE = new Card(Rank.TEN, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(true, is4set(testHand));
    }

    @Test
    public void TestFalseFullHouse() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.QUEEN, Suit.CLUBS);
        Card cardC = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.ACE, Suit.DIAMONDS);
        Card cardE = new Card(Rank.FIVE, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(false, isFullHouse(testHand));
    }

    @Test
    public void TestTrueFullHouse() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.FIVE, Suit.CLUBS);
        Card cardC = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.HEARTS);
        Card cardE = new Card(Rank.FIVE, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(true, isFullHouse(testHand));
    }

    @Test
    public void TestTrue3set() {
        Card cardA = new Card(Rank.TEN, Suit.SPADES);
        Card cardB = new Card(Rank.FIVE, Suit.CLUBS);
        Card cardC = new Card(Rank.TEN, Suit.DIAMONDS);
        Card cardD = new Card(Rank.TEN, Suit.HEARTS);
        Card cardE = new Card(Rank.FOUR, Suit.HEARTS);

        ArrayList<Card> testHand = new ArrayList<>();
        testHand.add(cardA);
        testHand.add(cardB);
        testHand.add(cardC);
        testHand.add(cardD);
        testHand.add(cardE);

        assertEquals(true, is3set(testHand));
    }

    @Test
    public void TestTrue2pair() {
    }
}