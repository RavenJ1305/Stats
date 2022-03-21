public class Card {
    private String suit;
    private int num;

    public int getNum(){
        return num;
    }

    public String getSuit(){
        return suit;
    }

    public void setNum(int newNum){
        num = newNum;
    }

    public void setSuit(String newSuit){
        suit = newSuit;
    }

    public Card(int nums, String suits){
        suit = suits;
        num = nums;
    }
}
