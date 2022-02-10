public class Statistics_Tester {
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        Statistics s2 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        s1.result(listA);
        s2.result2(listA, listB);
    }
}
