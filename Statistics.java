import java.util.Arrays;
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
                if(list[j] == list[i])
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

        avg = (double)(sum / (arraySize - 1));
        deviation = Math.sqrt(sum);
        return deviation;
    }

}