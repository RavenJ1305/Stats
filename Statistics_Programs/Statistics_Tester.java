public class Statistics_Tester {
    
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        double n = 10;
        double r = 7;
        double p = .8;
        double q = .2
        //Passes the Arrays and doubles to the result method for the outputs
        s1.result(listA, listB, n, r);
    }
}
