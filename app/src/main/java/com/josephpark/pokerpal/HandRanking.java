package com.josephpark.pokerpal;

import java.util.ArrayList;
import java.util.Collections;

// based off http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/pokerCheck.html
/*
    Poker Hand Rankings:
        Royal Flush
        Straight Flush
        Four of a Kind
        Full House
        Flush
        Straight
        Three of a Kind
        Two Pair
        Pair
        High Card
 */
public class HandRanking {

    public static boolean isRoyalFlush(ArrayList<Card> hand){
        hand = sortByRank(hand);
        return hand.get(0).getRank() == Rank.TEN && isStraightFlush(hand);
    }

    public static boolean isStraightFlush(ArrayList<Card> hand){
        return isStraight(hand) && isFlush(hand);
    }

    /*  Sort cards by suit
        Lowest suit should equal highest suit
     */
    public static boolean isFlush(ArrayList<Card> hand){
        hand = sortBySuit(hand);
        return hand.get(0).getSuit() == hand.get(4).getSuit();
    }

    /*
        Sort cards by rank
        if Ace found, straight can either be [A,2,3,4,5] or [10,J,Q,K,A]
     */
    public static boolean isStraight(ArrayList<Card> hand){
        hand = sortByRank(hand);

        // Edge case: straight containing an Ace
        if(hand.get(4).getRank() == Rank.ACE){
            // Straight is either [A,2,3,4,5](Sorted as [2,3,4,5,A]) or [10,J,Q,K,A]
            return (hand.get(0).getRank() == Rank.TWO && hand.get(1).getRank() == Rank.THREE &&
                    hand.get(2).getRank() == Rank.FOUR && hand.get(3).getRank() == Rank.FIVE) ||
                   (hand.get(0).getRank() == Rank.TEN && hand.get(1).getRank() == Rank.JACK &&
                    hand.get(2).getRank() == Rank.QUEEN && hand.get(3).getRank() == Rank.KING);
        }

        for(int i = 0; i < hand.size()-1; i++){
            // (next card value) - (curr card value) should equal 1 in a straight
            if((hand.get(i+1).getRank().ordinal() - hand.get(i).getRank().ordinal()) != 1)
                return false;
        }
        return true;
    }

    /*
        Sort cards by rank
        Two possible '4 of a Kind':
            1. First card doesn't match, last 4 are same rank. - [3,Q,Q,Q,Q]
            2. First 4 cards are same rank, last card doesn't match. - [8,8,8,8,J]
     */
    public static boolean is4set(ArrayList<Card> hand){
        hand = sortByRank(hand);
        return (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(1).getRank() == hand.get(2).getRank() &&
                hand.get(2).getRank() == hand.get(3).getRank()) ||
                (hand.get(1).getRank() == hand.get(2).getRank() && hand.get(2).getRank() == hand.get(3).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank());
    }

    /*
        Sort cards by rank
        Two possible 'Full House' cases:
            1. First 2 cards matching lower rank, last 3 are matching higher rank. - [4,4,J,J,J]
            2. First 3 cards matching lower rank, last 2 are matching higher rank. - [5,5,5,8,8]
     */
    public static boolean isFullHouse(ArrayList<Card> hand){
        hand = sortByRank(hand);
        boolean case1 = hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(3).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank();
        boolean case2 = hand.get(0).getRank() == hand.get(1).getRank() && hand.get(1).getRank() == hand.get(2).getRank() &&
                hand.get(3).getRank() == hand.get(4).getRank();
        return case1 || case2;
    }

    /*
        Sort cards by rank
        Three possible '3 of a Kind' cases:
            1. First 3 cards are same rank, last 2 cards don't match first 3. - [4,4,4,6,K]
            2. First card unmatched, middle 3 cards are same rank, last card unmatched. - [4,8,8,8,10]
            3. First 2 cards don't match, last 3 cards are same rank. - [2,5,10,10,10]
     */
    public static boolean is3set(ArrayList<Card> hand){
        hand = sortByRank(hand);
        boolean case1 = hand.get(0).getRank() == hand.get(1).getRank() && hand.get(1).getRank() == hand.get(2).getRank();
        boolean case2 = hand.get(1).getRank() == hand.get(2).getRank() && hand.get(2).getRank() == hand.get(3).getRank();
        boolean case3 = hand.get(2).getRank() == hand.get(3).getRank() && hand.get(3).getRank() == hand.get(4).getRank();
        return case1 || case2 || case3;
    }

    /*
        Sort by rank
        Three possible 'Two pair' cases:
            1. Cards 0&1 are pair, cards 2&3 are another pair, last card doesn't match either. - [5,5,J,J,A]
            2. Cards 0&1 are pair, cards 3&4 pair, middle card(2) doesn't match. - [9,9,J,K,K]
            3. Cards 1&2 are pair, cards 3&4 pair, first card(0) doesn't match - [6,7,7,10,10]
     */
    public static boolean is2pair(ArrayList<Card> hand){
        hand = sortByRank(hand);
        boolean case1 = hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(3).getRank();
        boolean case2 = hand.get(0).getRank() == hand.get(1).getRank() && hand.get(3).getRank() == hand.get(4).getRank();
        boolean case3 = hand.get(1).getRank() == hand.get(2).getRank() && hand.get(3).getRank() == hand.get(4).getRank();
        return case1 || case2 || case3;
    }

    /*
        Sort by rank
        For each card, except for last:
            Checks if card has same rank as next card
                If so, it is a pair.
     */
    public static boolean is1pair(ArrayList<Card> hand){
        hand = sortByRank(hand);
        for(int i = 0; i < hand.size()-1; i++){
            if(hand.get(i).getRank() == hand.get(i+1).getRank())
                return true;
        }
        return false;
    }

    // Sorts a hand from lowest value to highest value (2 - A)
    private static ArrayList<Card> sortByRank(ArrayList<Card> hand){
        boolean sorted;
        do {
            sorted = true;
            for(int i = 0; i < hand.size()-1; i++){
                // checks if right card has higher rank than left card
                if(hand.get(i+1).getRank().ordinal() < hand.get(i).getRank().ordinal()){
                    Card temp = hand.get(i);
                    hand.set(i, hand.get(i+1));
                    hand.set(i+1, temp);
                    sorted = false;
                }
            }
        } while(!sorted);
        return hand;
    }

    // Sorts a hand by suit. Spades -> Clubs -> Diamonds -> Hearts
    private static ArrayList<Card> sortBySuit(ArrayList<Card> hand){
        // bubble sort
        boolean sorted;
        do {
            sorted = true;
            for(int i = 0; i < hand.size()-1; i++){
                // if right element < left element
                if(hand.get(i+1).getSuit().ordinal() < hand.get(i).getSuit().ordinal()){
                    Card temp = hand.get(i);
                    hand.set(i, hand.get(i+1));
                    hand.set(i+1, temp);
                    sorted = false;
                }
            }
        } while(!sorted);
        return hand;
    }
}
