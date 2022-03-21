import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Random;

public class Salter {
    Random rand = new Random();
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    private BufferedReader bReader;
    
    public void CSV_Writer(){
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
            bWriter.write("X " + "," + " Y \n");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        for(int i=1; i <= 1000; i++){
            //Writes in the X value under the X column and random integers under the Y column
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

    public void changeData(){
        try{
            bReader = new BufferedReader(new FileReader("Salter.csv"));
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        try{
            fWriter = new FileWriter("Salter_Changed.csv");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        
        try{
            while(bReader.readLine() != null){
                
            }
        } catch(IOException ex){
            System.out.println("Error occured: " + ex.toString());
        }
    }

}
