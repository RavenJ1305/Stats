public class Statistics_Tester {
    
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        int n = 7;
        int r = 5;
        double p = .8;
        int setEvents = 1;
        int event = 2;
        int upper = 49; 
        int lower = 29;
        int littleO = 5;
        int littleR = 5;
        int N = 50;
        int y = 2;
        int x = 6;

        //Passes the above variables to the result method of the Statistics.java class for the outputs
        s1.result(listA, listB, n, r, p, setEvents, event, upper, lower, littleO, littleR, N, y, x);
    }
}
