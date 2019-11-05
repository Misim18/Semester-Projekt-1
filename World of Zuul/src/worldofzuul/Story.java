package worldofzuul;
import java.util.Scanner;

public class Story {

private String Line;    
public Story(){}
private String[] randLineArray = new String[10];

public void fillArray(){ //facts fra poster billede.
randLineArray[0] = "2,412,151";
randLineArray[1] = "1,739,743";
randLineArray[2] = "1,569,135";
randLineArray[3] = "1,091,107";
randLineArray[4] = "757,523";
randLineArray[5] = "746,211";
randLineArray[6] = "643,562";
randLineArray[7] = "632,874";
randLineArray[8] = "624,878";
randLineArray[9] = "580,570";
}

public String getLine(){
    return Line;
}

public void getRandLine(){
    fillArray();
    int temp =(int) Math.round(Math.random()*9);
    System.out.println(randLineArray[temp]);
    
}

public void IntroLine(){
    Scanner s = new Scanner(System.in);
    
    System.out.println("Hello player1. You are about to begin the game.");
    System.out.println("Please begin by entering your name, and finish by typing Enter. ");
    String name = s.nextLine();
    System.out.println("Welcome to OceanClear " + name + ". We are happy you are here. Let's get startet.");
    System.out.println("");
}
    //main skal ikke være i denne klasse.
//    public static void main(String[] args){
//        Story first = new Story();
//        first.IntroLine();
//        first.getRandLine();
//        first.getRandLine();
//    }
}
