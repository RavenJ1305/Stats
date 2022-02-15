import java.util.Arrays;
import java.util.ArrayList;
public class Statistics {

    public ArrayList<Integer> convert(int[] list){
        ArrayList<Integer> converted = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            converted.add(list[i]);
        }
        return converted;
    }
    
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

    public ArrayList<Integer> union(int[] listA, int[] listB){
        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();
        ArrayList<Integer> listD = new ArrayList<>();
        listC = convert(listA);
        listD = convert(listB);

        for(int i=0; i < listC.size(); i++){
            if(!union.contains(listC.get(i))){
                union.add(listC.get(i));
            }
        }

        for(int i=0; i< listD.size(); i++){
            if(!union.contains(listD.get(i))){
                union.add(listD.get(i));
            }
        }
        return union;
    }

    public ArrayList<Integer> intersection(int[] listA, int[] listB){
        ArrayList<Integer> intersect = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();
        ArrayList<Integer> listD = new ArrayList<>();
        listC = convert(listA);
        listD = convert(listB);

        for(int i=0; i < listC.size(); i++){
            if(listD.contains(listC.get(i))){
                if(!intersect.contains(listC.get(i))){
                    intersect.add(listC.get(i));
                }
            }
        }
        return intersect;
    }

    public ArrayList<Integer> compliment(int[] list){
        ArrayList<Integer> out = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        listA = convert(list);
        int[] preSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i = 0; i < preSet.length; i++){
            if(!listA.contains(preSet[i])){
                out.add(preSet[i]);
            }
        }
        return out;
    }

    public void result(int[] listA, int[] listB, double n, double r){
        System.out.println();
        System.out.println("The mean of listA is: " + mean(listA));
        System.out.println("The median of listA is: " + median(listA));
        System.out.println("The mode of listA is: " + mode(listA));
        System.out.println("The standard deviation of listA is: " + stdDevi(listA));
        System.out.println("The variance of listA is: " + variance(listA));
        System.out.println("The permutation of variable n and variable r is: " + permutation(n, r));
        System.out.println("The combinationn of variable n and variable r is: " + combination(n, r));
        System.out.println("The union of listA and listB is: " + union(listA, listB));
        System.out.println("The intersection of listA and listB is: " + intersection(listA, listB));
        System.out.println("The compliment of listA compared to the preset list is: " + compliment(listA));
    }
}