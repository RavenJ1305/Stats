public class Statistics_Tester {
    
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        int n = 10;
        int r = 7;
        double p = .8;
        int setEvents = 1;
        int event = 2;
        int upper = 49; 
        int lower = 29;
        int littleO = 5;
        //Passes the Arrays and integers to the result method for the outputs
        s1.result(listA, listB, n, r, p, setEvents, event, upper, lower, littleO);
    }
}
