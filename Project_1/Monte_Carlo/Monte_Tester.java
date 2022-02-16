package Monte_Carlo;

public class Monte_Tester {
    public static void main(String[] args){
        Monte_Carlo monte = new Monte_Carlo();
        //Calls the run method of the Monte_Carlo class and passes the amount of times it should run into it
        monte.run(10000);
    }
}
