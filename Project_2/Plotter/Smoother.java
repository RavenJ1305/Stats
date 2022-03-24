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

    public void writeData(int bound){
        bWriter = new BufferedWriter(fWriter);
        //Creates a header for two columns in the Smoother.csv
        try{
            bWriter.write("X Value " + "," + " Y Value \n");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }

        try{
            File myFile = new File("/Users/annetteraven/Documents/GitHub/Stats/Project_2/Plotter/Plotter.csv"); //This variable tells the reader what file to read
            Scanner fReader = new Scanner(myFile); 
            String head = fReader.nextLine();
            double newX = 0;
            double newY = 0;

            for(int i=0; i <= 1000; i++){ //Loops through the csv file 1001 times
                
                /**While there is still data to read in the next row of the CSV this loop will continue to run.
                 * This loop will read the comma separated values and randomly add or subtract the bound set by the user to 
                 * the Y value and then write the new value into the CSV.
                 */
                while(fReader.hasNextLine()){
                     
                    
                    
                    bWriter.write(newX + "," + newY + "\n");
                    break;
                }
            }
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }

        try{
            bWriter.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
