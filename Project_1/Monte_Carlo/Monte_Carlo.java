package Monte_Carlo;
import java.util.Random;

public class Monte_Carlo {
    Random rand = new Random();
    int count = 0;
    int playerDoor = 0;
    int winDoor = 0;
    
    //Returns the probability of winning if the player does not change their door
    public double dontChange(double  plays){
        count = 0;
        for(int i = 1; i <= plays; i++){
            playerDoor = rand.nextInt(3);
            winDoor = rand.nextInt(3);

            if(playerDoor == winDoor){
                count++;
            }
        }

        return (count/plays) * 100;
    }

    //Returns the probability of winning if the player does change their door
    public double doChange(double plays){
        count = 0;
        for(int i = 1; i <= plays; i++){
            playerDoor = rand.nextInt(3);
            winDoor = rand.nextInt(3);
            int wrongDoor = winDoor;
            
            //Re-assigns wrongDoor a number if it's assigned the same number as winDoor or playerDoor
            while(wrongDoor == winDoor || wrongDoor == playerDoor){
                wrongDoor = rand.nextInt(3);
            }

            int changeDoor = 3 - (playerDoor + wrongDoor);

            if(changeDoor == winDoor){
                count++;
            }
        }

        return (count/plays) * 100;
    }

    //Calls both methods and returns both
    public void run(double plays){
        System.out.println("If the player does not change the door every time out of " + plays + " they will win " + dontChange(plays) + "% of the time.");
        System.out.println("If the player does change the door every time out of " + plays + " they will win " + doChange(plays) + "% of the time.");
    }
}
