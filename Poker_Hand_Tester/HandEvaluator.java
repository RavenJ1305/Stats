import java.util.ArrayList;

public class HandEvaluator {
    Deck newDeck = new Deck();
    ArrayList<Card> hand = new ArrayList<Card>();

    public ArrayList<Card> drawFive(){
        newDeck.addToDeck();
        newDeck.shuffled();

        for(int i = 0; i < 5; i++){
            hand.add(newDeck.drawCard());
        }

        return hand;
    }

    public void printHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).getNum());
            System.out.println(hand.get(i).getSuit());
        }
    }
}
