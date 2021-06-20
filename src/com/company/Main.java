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
            dealerHand.setCardOne(dealerCard1.getCardValue());
            dealerHand.setCardTwo(dealerCard2.getCardValue());
            dealerHand.setHandTotal(dealerHand.getCardOne()+dealerHand.getCardTwo());

            Card playerCard1 = genNewCard();
            Card playerCard2 = genNewCard();
            Hand playerHand = new Hand();
            playerHand.setCardOne(playerCard1.getCardValue());
            playerHand.setCardTwo(playerCard2.getCardValue());
            playerHand.setHandTotal(playerHand.getCardOne()+playerHand.getCardTwo());

            System.out.println("First Player Card is " + playerHand.getCardOne());
            if (playerHand.getCardOne() == 1) {
                System.out.println("Do you want ace to equal 1 or 11?");
                Scanner input = new Scanner(System.in);
                int answer = input.nextInt();
                playerHand.setCardOne(answer);
                playerHand.setHandTotal(playerHand.getCardOne()+playerHand.getCardTwo());

            }
            System.out.println("Second Player Card is " + playerHand.getCardTwo());
            if (playerHand.getCardTwo() == 1) {
                System.out.println("Do you want ace to equal 1 or 11?");
                Scanner input = new Scanner(System.in);
                int answer = input.nextInt();
                playerHand.setCardTwo(answer);
                playerHand.setHandTotal(playerHand.getCardOne()+playerHand.getCardTwo());

            }
            playerHand.setHandTotal(playerHand.getCardOne()+playerHand.getCardTwo());
            System.out.println("Visible Dealer Card = " + dealerHand.getCardOne());
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
                    playerHand.setHandTotal(playerHand.getHandTotal() + playerCardNext.getCardValue());
                    System.out.println("Player Total = " + playerHand.getHandTotal());
                    if (playerHand.getHandTotal() > 21) {
                        System.out.println("BUST!");
                        break;} else{
                        System.out.println("Hit or Stick? ");
                        answer = input.nextLine();
                    }
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
                System.out.println("Bigger Looser Than Leon");
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
