import java.util.ArrayList;
import java.util.Random;
public class Deck {
    
    public Deck(){

    }

    public ArrayList orgDeck(){
        ArrayList<Integer> newDeck = new ArrayList<>();
        for(int i = 0; i <= 52; i++){
            newDeck.add(i);
        }

        return newDeck;
    }

    public ArrayList shuffled(){
        ArrayList<Integer> shuffleDeck = new ArrayList<>();
        Random rand = new Random();
        int i = 0;
        int c = 0;
        if(shuffleDeck.size() < 52){
            i = rand.nextInt(orgDeck.size()) + 1;
            c = orgDeck(i);
            shuffleDeck.add(c);
        }
        return shuffleDeck;
    }
}
