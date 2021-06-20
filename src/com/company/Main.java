package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static Card genNewCard() {
        Random rand1 = new Random();
        int upperbound2 = 9;
        int cardValue = rand1.nextInt(upperbound2);
        Card nextCard = new Card();
        nextCard.setCardValue(cardValue + 1);
//        System.out.println("TEST" + nextCard.getCardValue());
        return nextCard;
    }


    public static void main(String[] args) {

        int playAgain = 1;
        do {
            Card dealerCard1 = genNewCard();
            Card dealerCard2 = genNewCard();
            Hand dealerHand = new Hand();
            dealerHand.cardsInHand.add(dealerCard1.getCardValue());
            dealerHand.cardsInHand.add(dealerCard2.getCardValue());
            dealerHand.setHandTotal(dealerHand.cardsInHand.get(0)+dealerHand.cardsInHand.get(1));

            Card playerCard1 = genNewCard();
            Card playerCard2 = genNewCard();
            Hand playerHand = new Hand();
            playerHand.cardsInHand.add(playerCard1.getCardValue());
            playerHand.cardsInHand.add(playerCard2.getCardValue());
            playerHand.setHandTotal(playerHand.cardsInHand.get(0)+playerHand.cardsInHand.get(1));

            System.out.println("Player Card Number 1 is " + playerHand.cardsInHand.get(0));
            System.out.println("Player Card Number 2 is " + playerHand.cardsInHand.get(1));

            if (playerHand.cardsInHand.get(0) == 1) {
                System.out.println("Do You Want Card 1 Ace To Equal 1 or 11?");
                Scanner input = new Scanner(System.in);
                int answer = input.nextInt();
                playerHand.cardsInHand.set(0,answer);
                playerHand.setHandTotal(playerHand.cardsInHand.get(0)+playerHand.cardsInHand.get(1));

            }
            if (playerHand.cardsInHand.get(1) == 1) {
                System.out.println("Do You Want Card 2 Ace To Equal 1 or 11?");
                Scanner input = new Scanner(System.in);
                int answer = input.nextInt();
                playerHand.cardsInHand.set(1,answer);
                playerHand.setHandTotal(playerHand.cardsInHand.get(0)+playerHand.cardsInHand.get(1));

            }
            playerHand.setHandTotal(playerHand.cardsInHand.get(0)+playerHand.cardsInHand.get(1));
            System.out.println("Visible Dealer Card = " + dealerHand.cardsInHand.get(0));
//        System.out.println("DealerTotal(FOR TEST) = " + dealerTotal);

            System.out.println("Player Total = " + playerHand.getHandTotal());
            if (playerHand.getHandTotal() == 21) {
                System.out.println("BLACK JACK");
            } else {
                Scanner input = new Scanner(System.in);
                System.out.println("Hit or Stick? ");
                String answer = input.nextLine();
                while (playerHand.getHandTotal() < 22 && answer.equalsIgnoreCase("HIT"))  {
                    Card playerCardNext = genNewCard();
                    playerHand.cardsInHand.add(playerCardNext.getCardValue());
                    System.out.println("Card Number " + playerHand.cardsInHand.size() + " is "+playerCardNext.getCardValue());
                    Integer sum = 0;
                    for (Integer d : playerHand.cardsInHand) {
                        sum += d;
                    }
                    playerHand.handTotal = sum;
                    System.out.println("Player Total = " + playerHand.getHandTotal());
                    if (playerHand.getHandTotal() > 21) {
                        System.out.println("BUST!");
                        break;} else{
                        System.out.println("Hit or Stick? ");
                        answer = input.nextLine();
                    }
                    if (playerHand.cardsInHand.size() == 5) {
                        System.out.println("5 Cards In Hand");
                        break;}
                }
            }

            int dealerBust = 0;
            int playerBust = 0;
            if (playerHand.getHandTotal() > 22){
                System.out.println("Player Bust!");
                playerBust = 1;
            }

            System.out.println("Dealer Total = " + dealerHand.getHandTotal());
            while (playerBust != 1 && dealerHand.getHandTotal() < 18) {
                Card newDealerCard = genNewCard();
                dealerHand.setHandTotal(dealerHand.getHandTotal() + newDealerCard.getCardValue()) ;
                System.out.println("Dealer Hits");
                System.out.println("Dealer Total = " + dealerHand.getHandTotal());
                if (dealerHand.getHandTotal() > 22) {
                    System.out.println("Dealer Bust");
                    dealerBust = 1;
                }
            }

            if (playerBust != 1 && dealerHand.getHandTotal() > 21) {
                System.out.println("WINNER");
            }

            if (playerBust != 1 && playerHand.getHandTotal() > dealerHand.getHandTotal()) {
                System.out.println("WINNER");
            }
            if (dealerBust != 1 && playerHand.getHandTotal() < dealerHand.getHandTotal()) {
                System.out.println("You're a Bigger Looser Than Leon");
            }
            if (playerHand.getHandTotal() == dealerHand.getHandTotal()) {
                System.out.println("Draw");
            }

            System.out.println("Do you want to play again?");
            Scanner input = new Scanner(System.in);
            String playAgainAnswer = input.nextLine();
            if (playAgainAnswer.equalsIgnoreCase("NO")) {
                playAgain = 0;
            }
        }
        while (playAgain == 1);
    }
}
