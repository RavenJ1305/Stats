import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class Plotter {
    private FileWriter fWriter;
    private BufferedWriter bWriter;
    
    public Plotter(){
        //Exception checks to see if it can create the Plotter.csv
        try{
            fWriter = new FileWriter("Plotter.csv");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
    }

    /**This method uses the function y=mx=b, the variables m and b are preset. X is incremented by the for loop and y is determined 
    * using the function
    */
    public void writeData(){
        bWriter = new BufferedWriter(fWriter);
        //Creates a header for two columns in the Plotter.csv
        try{
            bWriter.write("X Value " + "," + " Y Value \n");
        } catch(Exception ex){
            System.out.println("Error occured: " + ex.toString());
        }
        for(int i=0; i <= 1000; i++){
            try{
                int x = i;
                double m = .5;
                int b = 10;
                double y = (m*x) + b;
                bWriter.write(x + "," + y + "\n");
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
