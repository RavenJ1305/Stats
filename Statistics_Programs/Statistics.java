import java.util.Arrays;
import java.util.ArrayList;
public class Statistics {

    public double mean(int[] list){
        double avg = 0;
        int i;
        int arraySize = list.length;

        if(arraySize == 0){
            return 0;
        }

        for(i=0; i < arraySize; i++)
            avg = avg + list[i];
        
        avg = avg / arraySize;
        return avg;
    }

    public double median(int[] list){
        double middle;
        int arraySize = list.length;
        Arrays.sort(list);

        if(arraySize % 2 == 0){
            middle = list[arraySize / 2] + list[arraySize / 2 - 1];
            middle = middle / 2;
        }else{
            middle = list[arraySize / 2];
        }
        return middle;
    }

    public int mode(int[] list){
        int most = 0, highCount = 0;
        int i, j;
        int arraySize = list.length;

        for(i = 0; i < arraySize; i++){
            int count = 0;
            for(j = 0; j < arraySize; j++){
                if(list[i] == list[j])
                    count++;
            }
            if(count > highCount){
                highCount = count;
                most = list[i];
            }
        }
        return most;
    }

    public double stdDevi(int[] list){
        double avg = mean(list), deviation = 0;
        int i, temp = 0, sum = 0;
        int arraySize = list.length;
        int[] tempArray = new int[arraySize];

        for(i = 0; i < arraySize; i++){
            temp = (int)(list[i] - avg);
            temp = (int)Math.pow(temp,2);
            tempArray[i] = temp;
        }
        for(i = 0; i < arraySize; i++){
            sum = sum + tempArray[i];
        }

        double var = (double)(sum / (arraySize - 1));
        deviation = Math.sqrt(var);
        return deviation;
    }

    public double variance(int[] list){
        double avg = mean(list);
        int i, temp = 0, sum = 0;
        int arraySize = list.length;
        int[] tempArray = new int[arraySize];

        for(i = 0; i < arraySize; i++){
            temp = (int)(list[i] - avg);
            temp = (int)Math.pow(temp,2);
            tempArray[i] = temp;
        }
        for(i = 0; i < arraySize; i++){
            sum = sum + tempArray[i];
        }

        double var = (double)(sum / (arraySize - 1));
        return var;
    }

    public double factorial(double a){
        if(a == 0){
            return 1;
        }
        return a*factorial(a-1);
    }

    public double permutation(double n, double r){
        return (factorial(n)/(factorial(n-r)));
    }

    public double combination(double n, double r){
        return factorial(n)/((factorial(r))*(factorial(n-r)));
    }

    public ArrayList<Integer> union(ArrayList<Integer> listA, ArrayList<Integer> listB){
        ArrayList<Integer> union = new ArrayList<>();
        for(int i=0; i < listA.size(); i++){
            union.add(listA.get(i));
        }
        for(int i=0; i< listB.size(); i++){
            if(!union.contains(listB.get(i))){
                union.add(listB.get(i));
            }
        }
        return union;
    }
    public ArrayList<Integer> intersection(ArrayList<Integer> listA, ArrayList<Integer> listB){
        ArrayList<Integer> intersect = new ArrayList<>();

        for(int i=0; i < listA.size(); i++){
            if(listB.contains(listA.get(i))){
                intersect.add(listA.get(i));
            }
        }
        return intersect;
    }

    public ArrayList<Integer> compliment(ArrayList<Integer> list){
        ArrayList<Integer> out = new ArrayList<>();
        int[] preSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < preSet.length; i++){
            if(!list.contains(preSet[i])){
                out.add(preSet[i]);
            }
        }
        return out;
    }

    public void result(int[] list){
        System.out.println();
        System.out.println("The mean of this list is: " + mean(list));
        System.out.println("The median of this list is: " + median(list));
        System.out.println("The mode of this list is: " + mode(list));
        System.out.println("The standard deviation of this list is: " + stdDevi(list));
    }

    public void result2(int[] list, int[] list2){
        
    }

}