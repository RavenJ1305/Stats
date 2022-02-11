package Birthday_Problem;
import java.util.Random;

public class Person {
    private int bday;
    Random rand = new Random();

    public int getBday(){
        return bday;
    }

    public Person(){
        bday = rand.nextInt(365) + 1;
    }
}
