package Birthday_Problem;


public class Birthday_Tester {
    public static void main(String[] args){
        //Returns the probability two people will share a birthday in a room of X amount of people 
        Birthday bdayComp = new Birthday();
        //Adjust the parameters for the amount of people and the amount of times the code will run
        bdayComp.result(23, 10000);
    }

}
