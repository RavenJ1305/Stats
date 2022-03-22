public class Card {
    private String suit;
    private int num;

    //Returns the number of the card
    public int getNum(){
        return num;
    }

    //Returns the suit of the card
    public String getSuit(){
        return suit;
    }

    //Sets the number of the card
    public void setNum(int newNum){
        num = newNum;
    }

    //Sets the suit of the card
    public void setSuit(String newSuit){
        suit = newSuit;
    }

    //Creates the card
    public Card(int nums, String suits){
        suit = suits;
        num = nums;
    }
}
