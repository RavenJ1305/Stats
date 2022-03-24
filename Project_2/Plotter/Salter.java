import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Salter {
    Random rand = new Random();
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    public Salter(){
        //Exception checks to see if it can create the Salter.csv
        try{
            fWriter = new FileWriter("Salter.csv");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
    }

    public void writeData(){
        bWriter = new BufferedWriter(fWriter);
        //Creates a header for two columns in the Salter.csv
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

    public void changeData(int bound){
        bWriter = new BufferedWriter(fWriter);
        
        try{
            File myFile = new File("Plotter.csv"); //This variable tells the reader what file to read
            Scanner fReader = new Scanner(myFile); 
            double newX = 0;
            double newY = 0;

            for(int i=0; i <= 1000; i++){ //Loops through the csv file 1001 times
                
                /**While there is still data to read in the next row of the CSV this loop will continue to run.
                 * This loop will read the comma separated values and randomly add or subtract the bound set by the user to 
                 * the Y value and then write the new value into the CSV.
                 */
                while(fReader.hasNextLine()){
                    String val = fReader.nextLine(); 
                    for(int j = 0; j <= val.length(); j++){
                        int pos = val.indexOf(',');
                        int change = pos + 1;
                        newX = Double.valueOf(val.substring(0, change-1));
                        newY = Double.valueOf(val.substring(change));
                        int random = rand.nextInt(2);
                        if(random == 1){
                            newY = newY - bound;
                        }else{
                            newY = newY + bound;
                        }
                        
                    }
                    
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
