package CSV_Writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Random;

public class CSV_Writer {
    Random rand = new Random();
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    public CSV_Writer(){
        //Exception checks to see if it can create the FavoriteNumbers.csv
        try{
            fWriter = new FileWriter("FavoriteNumbers.csv");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
    }

    public void writeData(){
        bWriter = new BufferedWriter(fWriter);
        //Creates a header for two columns in the FavoriteNumbers.csv
        try{
            bWriter.write("ID " + "," + " Favorite Number \n");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        for(int i=0; i <= 1000; i++){
            //Writes in the ID number under the ID column and random integers under the Favorite Number column
            try{
                int idNumber = i;
                int favoriteNumber = rand.nextInt(1000) + 1;
                bWriter.write(idNumber + "," + favoriteNumber + "\n");
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
}
