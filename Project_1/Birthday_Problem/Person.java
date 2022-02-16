package Birthday_Problem;
import java.util.Random;

public class Person {
    private int bday;
    Random rand = new Random();

    public int getBday(){
        return bday;
    }

    //Sets person's birthday to a day of the year
    public Person(){
        bday = rand.nextInt(365) + 1; //+ 1 to account for the random int giving 0
    }
}
