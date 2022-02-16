public class Statistics_Tester {
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        double n = 4;
        double r = 2;
        //Passes the Arrays and doubles to the result method for the outputs
        s1.result(listA, listB, n, r);
    }
}
