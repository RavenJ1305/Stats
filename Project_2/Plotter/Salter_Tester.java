public class Salter_Tester {
    public static void main(String[] args){
        Salter salter = new Salter();
        int bound = 10; //Sets the bound to be added or subtracted from the Y value
        salter.writeData();
        salter.changeData(bound);
    }
}
