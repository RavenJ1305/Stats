package Birthday_Problem;

public class Birthday {
    private int counter;
    private double result;

    //Loops through as many times as specified by the runAmnt parameter and returns the probability
    public void result(int pplAmnt, int runAmnt){
        
        for(int i=0;i < runAmnt; i++){
            Person[] room = new Person[pplAmnt];
            //The room variable gets populated by the classRoom method's returned Array
            room = classRoom(pplAmnt);
            //If 1 is returned by compareBday it's added to the result variable to calculate the probability
            result += compareBday(room);
        }
        result = (result/runAmnt) * 100;
        System.out.println("The probability of two people sharing the same birthday in a room of " + pplAmnt + " people is: " + result + "%");
    }

    //Creates a specified amount of person objects and puts them into an array based off of the pplAmnt parameter and returns the Array
    public Person[] classRoom(int pplAmnt){
        Person[] room = new Person[pplAmnt];

        for(int i=0; i < room.length; i++){
            Person newPerson = new Person();
            room[i]= newPerson;
        }

        return room;
    }

    //Loops through the array to find a matching birthday, once found adds to counter, breaks the loop, checks if counter was incremented, breaks the loop if so, returns the counter
    public int compareBday(Person[] room){
        counter = 0;
        for(int i=0; i < room.length; i++){
            for(int j=i+1; j < room.length; j++){
                if(room[i].getBday() == room[j].getBday()){
                    counter++;
                    break;
                }
            }
            if(counter == 1)
                break;
        }
        return counter;
    }
}
