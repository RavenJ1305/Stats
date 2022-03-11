import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    
    ArrayList<Card> orgDeck = new ArrayList<Card>();

    public ArrayList<Card> addToDeck(){
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 14; j++){
                if(i == 0){
                    Card newCard = new Card(j, "Clubs");
                    orgDeck.add(newCard);
                }
                else if(i == 1){
                    Card newCard = new Card(j, "Diamonds");
                    orgDeck.add(newCard);
                }
                else if(i == 2){
                    Card newCard = new Card(j, "Hearts");
                    orgDeck.add(newCard);
                }
                else{
                    Card newCard = new Card(j, "Spades");
                    orgDeck.add(newCard);
                }
            }
        }
        return orgDeck;
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
