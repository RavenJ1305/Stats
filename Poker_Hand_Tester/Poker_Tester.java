public class Poker_Tester {
    
    public static void main(String[] args){
        HandEvaluator hand = new HandEvaluator();
        double runs = 10000;
        //hand.drawFive();
        //hand.printHand();
        hand.result(runs);
    }
}
