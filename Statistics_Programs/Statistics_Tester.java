import java.util.ArrayList;

public class Statistics_Tester {
    public static void main(String args[]){
        Statistics s1 = new Statistics();
        int listA[] = {1, 5, 3, 5, 3, 5};
        int listB[] = {1, 2, 3, 4, 5, 6};
        s1.result(listA);
        s1.result2(listA, listB);
        ArrayList<Integer> listC = new ArrayList<>();
        listC.add(1);
        listC.add(2);
        listC.add(5);
        ArrayList<Integer> listD = new ArrayList<>();
        listD.add(2);
        listD.add(4);
        listD.add(6);
        System.out.println(s1.union(listC, listD));
        System.out.println(s1.intersection(listC, listD));
        System.out.println(s1.compliment(listC));
    }
}
