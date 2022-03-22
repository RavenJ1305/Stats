import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {
    //Prints the probabilities of each of the below methods
    public void result(double runs){
        System.out.println("The probability of a pair in a hand of five cards is: " + pairTester(runs) + "%");
        System.out.println("The probability of a three of a kind in a hand of five cards is: " + threeOfKind(runs) + "%");
        System.out.println("The probability of a two pairs in a hand of five cards is: " + twoPair(runs) + "%");
        System.out.println("The probability of a straight in a hand of five cards is: " + straightTester(runs) + "%");
        System.out.println("The probability of a fullhouse in a hand of five cards is: " + fullHouseTester(runs) + "%");
        System.out.println("The probability of a flush in a hand of five cards is: " + flushTester(runs) + "%");
        System.out.println("The probability of a four of a kind in a hand of five cards is: " + fourOfKind(runs) + "%");
    }

    //Returns the probability of having a pair in a hand of 5 cards
    public double pairTester(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                for(int k = j + 1; k < hand.size(); k++){
                    if(hand.get(j).getNum() == hand.get(k).getNum()){
                        counter++;
                        break;
                    }
                }
            }
        }
        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having a three of a kind in a hand of 5 cards
    public double threeOfKind(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                for(int k = j + 1; k < hand.size(); k++){
                    if(hand.get(j).getNum() == hand.get(k).getNum()){
                        for(int l = k + 1; l < hand.size(); l++){
                            if(hand.get(k).getNum() == hand.get(l).getNum()){
                                counter++;
                                break;
                            }
                        }
                    }
                }
            }

        }

        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having two pair in a hand of 5 cards
    public double twoPair(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                int tempCounter = 0;
                for(int k = j + 1; k < hand.size(); k++){
                    if(hand.get(j).getNum() == hand.get(k).getNum()){
                        tempCounter++;
                    }
                }
                if(tempCounter == 2){
                    counter++;
                }
            }
            
            
        }
        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having a straight in a hand of 5 cards
    public double straightTester(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();
            ArrayList<Integer> sorted = new ArrayList<Integer>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                sorted.add(hand.get(j).getNum()); 
            }

            Collections.sort(sorted);
            int temp = sorted.get(0);

            if(sorted.get(1) == temp+1 && sorted.get(2) == temp+2 && sorted.get(3) == temp+3 && sorted.get(4) == temp+4){
                counter++;
            }
        }

        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having a full house in a hand of 5 cards
    public double fullHouseTester(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();
            ArrayList<Integer> sorted = new ArrayList<Integer>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                sorted.add(hand.get(j).getNum()); 
            }

            Collections.sort(sorted);

            if((sorted.get(0) == sorted.get(1) && sorted.get(0) == sorted.get(2) && sorted.get(3) == sorted.get(4)) || (sorted.get(0) == sorted.get(1) && sorted.get(2) == sorted.get(3) && sorted.get(2) == sorted.get(4))){
                counter++;
            }
        }

        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having a flush in a hand of 5 cards
    public double flushTester(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            if(hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(0).getSuit() == hand.get(2).getSuit() && hand.get(0).getSuit() == hand.get(3).getSuit() && hand.get(0).getSuit() == hand.get(4).getSuit()){
                counter++;
            }
        }

        result = (counter / runs) * 100;
        return result;
    }

    //Returns the probability of having a four of a kind in a hand of 5 cards
    public double fourOfKind(double runs){
        double result = 0;
        int counter = 0;

        for(int i = 0; i < runs; i++){
            Deck newDeck = new Deck();
            ArrayList<Card> hand = new ArrayList<Card>();

            newDeck.shuffled();

            for(int x = 0; x < 5; x++){
                hand.add(newDeck.drawCard());
            }

            for(int j = 0; j < hand.size(); j++){
                for(int k = j + 1; k < hand.size(); k++){
                    if(hand.get(j).getNum() == hand.get(k).getNum()){
                        for(int l = k + 1; l < hand.size(); l++){
                            if(hand.get(k).getNum() == hand.get(l).getNum()){
                                for(int h = l + 1; h < hand.size(); h++){
                                    if(hand.get(l).getNum() == hand.get(h).getNum()){
                                        counter++;
                                    break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

        result = (counter / runs) * 100;
        return result;
    }
}
