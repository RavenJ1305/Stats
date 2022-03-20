import java.util.ArrayList;

public class HandEvaluator {
    public void result(double runs){
        System.out.println("The probability of a pair in a hand of five cards is: " + pairTester(runs) + "%");
    }

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
}
