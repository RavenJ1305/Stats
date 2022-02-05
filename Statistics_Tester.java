public class Statistics_Tester {
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int list[] = {1, 5, 3, 5, 3, 5};

        System.out.println();
        System.out.println("The mean of this list is: " + s1.mean(list));
        System.out.println("The median of this list is: " + s1.median(list));
        System.out.println("The mode of this list is: " + s1.mode(list));
        System.out.println("The standard deviation of this list is: " + s1.stdDevi(list));
    }
}
