import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    
    ArrayList<Card> orgDeck = new ArrayList<Card>();

    //Creates a deck of cards using 1-13 for each card in each suit
    public Deck(){
        for(int i = 1; i < 13; i++){
            orgDeck.add(new Card(i, "Clubs"));
            orgDeck.add(new Card(i, "Diamonds"));
            orgDeck.add(new Card(i, "Hearts"));
            orgDeck.add(new Card(i, "Spades"));
        }
    }

    //Shuffles the deck of cards using the imported Collections class
    public void shuffled(){
        Collections.shuffle(orgDeck);
    }

    //Prints out the organized deck of cards to confirm that there are the appropriate amount of cards created
    public void print(){
        for(int i = 0; i < orgDeck.size(); i++){
            System.out.println(orgDeck.get(i).getNum());
            System.out.println(orgDeck.get(i).getSuit());
        }
    }

    //Draws a card from the top of the deck then removes that card from the deck
    public Card drawCard(){
        Card c = orgDeck.get(0);
        orgDeck.remove(0);
        return c;
    }
}
