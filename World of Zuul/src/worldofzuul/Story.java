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

public static void IntroLine(){
    System.out.println("Hello, you are about to begin the game."); 
    System.out.println("Please begin by entering your name, followed by hitting Enter. ");
}


}
