package Birthday_Problem;

public class Birthday {
    private int counter;
    private double result;

    public void result(int pplAmnt, int runAmnt){
        for(int i=0;i < runAmnt; i++){
            Person[] room = new Person[pplAmnt];
            room = classRoom(pplAmnt);
            result += compareBday(room);
        }
        result = (result/runAmnt) * 100;
        System.out.println("The probability of two people sharing the same birthday in a room of " + pplAmnt + " people is: " + result + "%");
    }

    public Person[] classRoom(int pplAmnt){
        Person[] room = new Person[pplAmnt];

        for(int i=0; i < room.length; i++){
            Person newPerson = new Person();
            room[i]= newPerson;
        }

        return room;
    }

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
