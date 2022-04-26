import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Smoother{
    ArrayList<Double> listY = new ArrayList<Double>();
    ArrayList<Double> listX = new ArrayList<Double>();

    public ArrayList<Double> saltedData(ArrayList<Double> listY){

        try{
            File myFile = new File("Salter.csv"); 
            Scanner fReader = new Scanner(myFile); 
            String head = fReader.nextLine();
            double x = 0;
            double y = 0;

            for(int i=0; i <= 1000; i++){ 

                while(fReader.hasNextLine()){
                    String val = fReader.nextLine();

                    for(int j = 0; j <= val.length(); j++){
                        int pos = val.indexOf(',');
                        int change = pos + 1;
                        x = Double.valueOf(val.substring(0, change-1));
                        y = Double.valueOf(val.substring(pos+1));
                    }

                    listX.add(x);
                    listY.add(y);
                    break;
                }
            }
  
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }

        return(listY);
    }

    public ArrayList<Double> smoothedData(ArrayList<Double> listY){
        
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.setWindowSize(3);
        int temp;
            
        for(int i = 0; i < listY.size(); i++){
            stats.addValue(listY.get(i));
            temp = (int)stats.getMean();
            listY.add((double) temp);
        }

        return(listY);
    }

    public void result(){
        System.out.println(smoothedData(saltedData(listY)));
    }

    

    
}