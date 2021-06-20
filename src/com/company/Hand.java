package com.company;

import java.util.ArrayList;

public class Hand {

    ///////////Attribute
    protected ArrayList<Integer> cardsInHand = new ArrayList<>();
    protected Integer handTotal;
    ///////////Constructors


    //////////Methods


    public ArrayList<Integer> getPlayerHand() {
        return cardsInHand;
    }

    public int getHandTotal() {
        return handTotal;
    }

    public void setPlayerHand(ArrayList<Integer> playerHand) {
        this.cardsInHand = playerHand;
    }

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

    private void handTotal(ArrayList<Double> wallAreas) {
        Integer sum = 0;
        for (Integer d : this.cardsInHand) {
            sum += d;
        }
        this.handTotal = sum;
    }
}
