import java.util.Arrays;
import java.util.ArrayList;

public class Statistics {

    //Converts Arrays into ArrayLists
    public ArrayList<Integer> convert(int[] list){
        ArrayList<Integer> converted = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            converted.add(list[i]);
        }
        return converted;
    }
    
    //Returns the mean of the elements in an Array
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

    //Returns the median of the elements in an Array
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

    //Returns the mode of the elements in an Array
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

    //Returns the standard deviation of the elements in an Array
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

    //Returns the variance of the elements in the Array
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

    //Returns the factorial of a number
    public int factorial(int a){
        if(a == 0){
            return 1;
        }
        return (a*factorial(a-1));
    }

    //Returns the permutation of two numbers
    public int permutation(int n, int r){
        return (factorial(n)/(factorial(n-r)));
    }

    //Returns the combination of two numbers
    public int combination(int n, int r){
        return factorial(n)/((factorial(r))*(factorial(n-r)));
    }

    //Converts two Arrays to ArrayLists then unions the two ArrayLists and returns the union
    public ArrayList<Integer> union(int[] listA, int[] listB){
        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();
        ArrayList<Integer> listD = new ArrayList<>();
        listC = convert(listA);
        listD = convert(listB);

        for(int i=0; i < listC.size(); i++){
            //Checks to see if the element getting added already exists in the union ArrayList
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

    //Converts two ARrays to ArrayLists then intersects the two ArrayLists and returns the intersection
    public ArrayList<Integer> intersection(int[] listA, int[] listB){
        ArrayList<Integer> intersect = new ArrayList<>();
        ArrayList<Integer> listC = new ArrayList<>();
        ArrayList<Integer> listD = new ArrayList<>();
        listC = convert(listA);
        listD = convert(listB);

        for(int i=0; i < listC.size(); i++){
            //Checks to see if element i in listC is in listD
            if(listD.contains(listC.get(i))){
                //If element i in listC is in listD this checks if it exists in the ArrayList intersect, if it doesn't it adds it
                if(!intersect.contains(listC.get(i))){
                    intersect.add(listC.get(i));
                }
            }
        }
        return intersect;
    }

    //Returns the compliment of the Array passed into the method against the preset Array
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

    //Returns the Binomial distribution of variables n, r, and p
    public double binDistro(int n, int r, double p){
        double result = 0;
        double comb = combination(n, r);

        result = comb * ((Math.pow(p,r)) * (Math.pow((1-p),(n-r))));

        return result;
    }

    //Returns the Geometric distribution of variables r and p
    public double geoDistro(int r, double p){
        double result = 0;
        result = Math.pow((1-p),(r-1))*p;

        return result;
    }

    //Returns the Hyper Geometric distribution of variables n, littleR, N, and y
    public double hypGeoDistro(int n, int littleR, int N, int y){
        double result = 0;

        result = (combination(littleR, y)*combination((N-littleR),n-y))/combination(N, n);
        return result;
    }

    //Returns the Poissan distribution of the variables setEvents and event
    public double poissan(int setEvents, int event){
        double result = 0;
        double e = 2.718218;

        result = (Math.pow(e,-setEvents)* Math.pow(setEvents,event) / factorial(event));
        return result;
    }

    //Returns the output of variables upper, lower, and littleO using Chebyshev's Theorem
    public double cheby(int upper, int lower, int littleO){
        double result = 0;
        double avg = (upper + lower) / 2;
        double k = (upper - avg) / littleO;

        result = 1 - (1 / Math.pow(k,2));
        return result;
    }

    //Prints all of the method outputs using all of the variables passed in by the Statistics.Tester.java class
    public void result(int[] listA, int[] listB, int n, int r, double p, int setEvents, int event, int upper, int lower, int littleO, int littleR, int N, int y){
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
        System.out.println("The binomial distribution of n, r, p, and q is: " + binDistro(n, r, p));
        System.out.println("The geometric distribution of r and p is: " + geoDistro(r, p));
        System.out.println("The hypergeometric distribution of n, littleR, N, and y is: " + hypGeoDistro(n, littleR, N, y));
        System.out.println("The poissan distribution with the average event 'setEvents' and the testing event 'event' is: " + poissan(setEvents, event));
        System.out.println("If you plug upper, lower, and littleO into Chebyshev's theorem the result is: " + cheby(upper, lower, littleO));
        
    }
}