public class Poker_Tester {
    
    public static void main(String[] args){
        HandEvaluator hand = new HandEvaluator();
        double runs = 10000; //Sets the amount of hands to test with
        hand.result(runs);
    }
}
