import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Smoother {
    Random rand = new Random();
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    public Smoother(){
        //Exception checks to see if it can create the Smoother.csv
        try{
            fWriter = new FileWriter("Smoother.csv");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
    }

    public void writeData(){
        bWriter = new BufferedWriter(fWriter);
        //Creates a header for two columns in the Smoother.csv
        try{
            bWriter.write("X Value " + "," + " Y Value \n");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        for(int i=0; i <= 1000; i++){
            //Writes in the X value under the X Value column and random integers under the Y Value column
            try{
                int xValue = i;
                int yValue = rand.nextInt(1000) + 1;
                bWriter.write(xValue + "," + yValue + "\n");
            } catch(Exception ex){
                System.out.println("Error occured: " + ex.toString());
            }
        }
        try{
            bWriter.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void changeData(int range){
        
    }
}
