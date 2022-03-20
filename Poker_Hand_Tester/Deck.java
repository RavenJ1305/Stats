import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    
    ArrayList<Card> orgDeck = new ArrayList<Card>();

    public Deck(){
        for(int i = 1; i < 13; i++){
            orgDeck.add(new Card(i, "Clubs"));
            orgDeck.add(new Card(i, "Diamonds"));
            orgDeck.add(new Card(i, "Hearts"));
            orgDeck.add(new Card(i, "Spades"));
        }
    }

    public void shuffled(){
        Collections.shuffle(orgDeck);
    }

    public void print(){
        for(int i = 0; i < orgDeck.size(); i++){
            System.out.println(orgDeck.get(i).getNum());
            System.out.println(orgDeck.get(i).getSuit());
        }
    }

    public Card drawCard(){
        Card c = orgDeck.get(0);
        orgDeck.remove(0);
        return c;
    }
}
