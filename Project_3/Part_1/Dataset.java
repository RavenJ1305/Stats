import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.util.ArrayList;

public class Dataset {
    //Converts Arrays into ArrayLists
    public ArrayList<Double> convert(double[] list){
        ArrayList<Double> converted = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            converted.add(list[i]);
        }
        return converted;
    }
    
    //Returns the mean of the elements in an Array
    public double mean(double[] wins){
        double avg = 0;
        int i;
        int arraySize = wins.length;

        if(arraySize == 0){
            return 0;
        }

        for(i=0; i < arraySize; i++)
            avg = avg + wins[i];
        
        avg = avg / arraySize;
        
        return avg;
    }

    //Returns the median of the elements in an Array
    public double median(double[] wins){
        double middle;
        int arraySize = wins.length;
        Arrays.sort(wins);

        if(arraySize % 2 == 0){
            middle = wins[arraySize / 2] + wins[arraySize / 2 - 1];
            middle = middle / 2;
        }else{
            middle = wins[arraySize / 2];
        }
        return middle;
    }

    //Returns the mode of the elements in an Array
    public int mode(double[] wins){
        int most = 0, highCount = 0;
        int i, j;
        int arraySize = wins.length;

        for(i = 0; i < arraySize; i++){
            int count = 0;
            for(j = 0; j < arraySize; j++){
                if(wins[i] == wins[j])
                    count++;
            }
            if(count > highCount){
                highCount = count;
                most = (int) wins[i];
            }
        }
        return most;
    }

    //Returns the standard deviation of the elements in an Array
    public double stdDevi(double[] wins){
        double avg = mean(wins), deviation = 0;
        int i, temp = 0, sum = 0;
        int arraySize = wins.length;
        int[] tempArray = new int[arraySize];

        for(i = 0; i < arraySize; i++){
            temp = (int)(wins[i] - avg);
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
    public double variance(double[] wins){
        double avg = mean(wins);
        int i, temp = 0, sum = 0;
        int arraySize = wins.length;
        int[] tempArray = new int[arraySize];

        for(i = 0; i < arraySize; i++){
            temp = (int)(wins[i] - avg);
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
    public BigInteger factorial(int a){
        long temp = a;
        BigInteger tempBigInt = BigInteger.valueOf(temp);
        
        if(a == 0){
            return BigInteger.valueOf(1);
        }
        BigInteger result = (tempBigInt.multiply(factorial(a-1)));
        return result;
    }

    //Returns the permutation of two numbers
    public BigInteger permutation(int n, int r){
        long tempN = n;
        long tempR = r;
        BigInteger tempBigN = BigInteger.valueOf(tempN);
        BigInteger tempBigR = BigInteger.valueOf(tempR);
        tempBigN = factorial(n);
        tempBigR = factorial(n-r);
        BigInteger result = tempBigN.divide(tempBigR);

        return result;
    }

    //Returns the combination of two numbers
    public BigInteger combination(int n, int r){
        BigInteger bigInt = new BigInteger("0");
        long tempN = n;
        long tempR = r;
        BigInteger tempBigN = BigInteger.valueOf(tempN);
        BigInteger tempBigR = BigInteger.valueOf(tempR);
        tempBigN = factorial(n);
        tempBigR = factorial(r);
        BigInteger temp = factorial(n-r);
    
        bigInt = tempBigN.divide(tempBigR.multiply(temp)); 
        return bigInt;
    }

    //Converts two Arrays to ArrayLists then unions the two ArrayLists and returns the union
    public ArrayList<Double> union(double[] wins, ArrayList<Double> winsComp){
        ArrayList<Double> union = new ArrayList<>();
        ArrayList<Double> listC = new ArrayList<>();
        ArrayList<Double> listD = new ArrayList<>();
        listC = convert(wins);
        listD = winsComp;

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
        Collections.sort(union);
        return union;
    }

    //Converts two ARrays to ArrayLists then intersects the two ArrayLists and returns the intersection
    public ArrayList<Double> intersection(double[] wins, ArrayList<Double> winsComp){
        ArrayList<Double> intersect = new ArrayList<>();
        ArrayList<Double> listC = new ArrayList<>();
        ArrayList<Double> listD = new ArrayList<>();
        listC = convert(wins);
        listD = winsComp;
        Collections.sort(listC);
        Collections.sort(listD);

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
    public ArrayList<Double> compliment(ArrayList<Double> winsConverted){
        ArrayList<Double> out = new ArrayList<Double>();
        ArrayList<Double> listA = new ArrayList<>();
        listA = winsConverted;
        double[] preSet = {12, 10, 10, 8, 4, 6, 9, 6, 7, 10, 3, 11, 5, 7, 4, 4, 6, 8, 6, 11, 8, 7, 6, 2, 5};

        for(int i = 0; i < preSet.length; i++){
            if(!listA.contains(preSet[i])){
                out.add(preSet[i]);
            }
        }
        return out;
    }

    //Returns the Binomial distribution of variables n, r, and p
    public double binDistro(int n, int y, double p){
        double result = 0;
        double q = 1 - p;
        BigInteger bigInt = combination(n, y);
        double comb = bigInt.doubleValue();
        double pOut = Math.pow(p,y);
        double qOut = Math.pow(q, (n-y));
        double temp = pOut * qOut;

        result = comb * temp;
        return result * 100;
    }

    //Returns the Geometric distribution of variables r and p
    public double geoDistro(int r, double p){
        double result = 0;
        result = Math.pow((1-p),(r-1))*p;

        return result * 100;
    }

    //Returns the Hyper Geometric distribution of variables n, littleR, N, and y
    public double hypGeoDistro(int n, int r, int N, int y){
        double result = 0;
        BigInteger first = combination(r, y);
        BigInteger second = combination((N-r), (n-y));
        BigInteger third = combination(N, n);
        BigInteger temp = (first.multiply(second));
        double top = temp.doubleValue();
        double bot = third.doubleValue();

        result = top/bot;
        return result * 100;
    }

    //Returns the poisson distribution of the variables setEvents and event
    public double poisson(int setEvents, int event){
        double result = 0;
        double e = 2.718218;

        result = (Math.pow(e,-setEvents)* Math.pow(setEvents,event) / factorial(event).doubleValue());
        return result * 100;
    }

    //Returns the output of variables upper, lower, and littleO using Chebyshev's Theorem
    public double cheby(int upper, int lower, double littleO, double mean){
        double result = 0;
        double avg = (upper + lower) / 2;
        double k = 0;

        if(upper - mean == mean - lower){
            k = (upper - mean) / littleO;
        }else{
            k = (upper - avg) / littleO;
        }

        result = 1 - (1 / Math.pow(k,2));
        return result * 100;
    }

    public double uniDistro(double a, double b, double x){
        double result = 0;  

        if(a <= x && x <= b){
            result = (x-a)/(b-a);
        }else{
            result = 0;
        }

        return result * 100;
    }

    //Prints all of the method outputs using all of the variables passed in by the Statistics.Tester.java class
    public void result(){
        int numSeasons = 25;
        int gamesPerSeason = 16;
        double[] wins = {4, 6, 6, 8, 12, 10, 7, 10, 9, 6, 13, 5, 11, 9, 12, 12, 10, 8, 10, 5, 8, 9, 10, 14, 11};
        ArrayList<Double> winsConverted = new ArrayList<Double>();
        winsConverted = convert(wins);
        ArrayList<Double> winsComp = compliment(winsConverted);

        System.out.println("The number of seasons in this data set is: " + numSeasons);
        System.out.println("The number of games per season in the data set is: " + gamesPerSeason);
        System.out.println();

        //WWhat is the average number of wins per season for the Ravens franchise?
        System.out.println("Average number of wins per season: " + mean(wins));

        //What is the median of wins per season for the Ravens franchise?
        System.out.println("Median of wins out of 25 seasons: " + median(wins));

        //What is the mode of the list of wins for the Ravens franchise?
        System.out.println("Mode of wins out of 25 seasons: " + mode(wins));

        //What is the standard deviation of the list of wins per season for the Ravens franchise?
        System.out.println("The standard deviation of the list of wins: " + stdDevi(wins));

        //What is the variance of the list of wins per season?
        System.out.println("The variance of the list of wins: " + variance(wins));

        //How many different ways can you order the Ravens' seasons with more than 10 wins?
        System.out.println("How many ways can the Ravens win 10 regular season games: " + permutation(gamesPerSeason, 10));

        //How many different ways can the Ravens win 10 games among 16 games?
        System.out.println("How many ways can the Ravens win 10 games among 16 games: " + combination(gamesPerSeason, 10));

        //What is the union between the list of wins and its compliment?
        System.out.println("Union of the list of wins and its compliment: " + union(wins, winsComp));

        //What is the intersection between the list of wins and its compliment?
        System.out.println("Intersection of the list of wins and its compliment: " + intersection(wins, winsComp));

        //What is the compliment of the list of wins?
        System.out.println("The compliment of the list of wins: " + compliment(winsConverted)); 

        //What are the odds of picking 15 random seasons that exceed 8 wins? 
        System.out.println("The odds of picking 15 random seasons that exceed 8 wins: " + binDistro(numSeasons, 15, .6));

        //What are the odds of randomly picking a season that exceeds 8 wins by the 5th attempt?
        System.out.println("The odds of picking a season that exceeds 8 wins by the 5th attempt: " + geoDistro(5, .6));

        //What are the odds of picking 2 seasons that have an odd amount of wins and exceed 10 wins
        System.out.println("The odds of picking 2 seasons that have an odd amount of wins that exceeds 10: " + hypGeoDistro(9, 3, numSeasons, 2));

        //There are 16 games per season, on average the Ravens win 9 of them. What are the odds the Ravens win more than 8 games per season?
        System.out.println("The odds the Ravens win more than 8 games per season: " + poisson(gamesPerSeason, 9));

        //What are the odds of the Ravens winning between 6 and 12 games per season with a mean of 9 and standard deviation of 2.65?
        System.out.println("The odds of the Ravens winning between 6 and 12 games per season: " + cheby(12, 6, 2.65, mean(wins)));

        //What are the odds of choosing the last 3 seasons out of the whole data set?
        System.out.println("The odds of choosing the last 3 seasons out of the whole data set: " + uniDistro(1, numSeasons, 3));
    }
}
