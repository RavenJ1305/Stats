import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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

    public ArrayList<Double> smoothedData(ArrayList<Double> saltedList){
        ArrayList<Double> smooth = new ArrayList<Double>();
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.setWindowSize(3);
        int temp;
            
        for(int i = 0; i < saltedList.size(); i++){
            stats.addValue(saltedList.get(i));
            temp = (int)stats.getMean();
            smooth.add((double) temp);
        }

        return(smooth);
    }

    public void printArrayList(ArrayList<Double> listOut){
        for(int i = 0; i < listOut.size(); i++){
            System.out.println(i + ", " + listOut.get(i));
        }
    }

    public void result(){
        ArrayList<Double> list = new ArrayList<Double>();
        ArrayList<Double> list2 = new ArrayList<Double>();
        list = saltedData(listY);
        list2 = smoothedData(list);
        printGraph(list, "Salted", "salteedGraph");
        printGraph(list2, "Smoothed", "smoothedGraph");

    }

    public void printGraph(ArrayList<Double> dataList, String title, String fName){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int i = 0; i < dataList.size(); i++){
            data.addValue(dataList.get(i), title, String.valueOf(i));
        }

        JFreeChart graph = ChartFactory.createLineChart(title, "X", "Y", data, PlotOrientation.VERTICAL, true, true, false);
        int graphWidth = 1000;
        int graphHeight = 1000;
        File graphOut = new File(fName + ".jpeg");

        try {
            ChartUtilities.saveChartAsJPEG(graphOut, graph, graphWidth, graphHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    
}