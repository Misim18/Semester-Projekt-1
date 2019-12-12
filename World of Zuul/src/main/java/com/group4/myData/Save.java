package com.group4.myData;

import com.group4.gameLogic.Character;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Save {

    File myFile = new File("data.txt"); //Data file placement

    PrintWriter pw;

    public void SaveGame(Character player1) {
        try {
            this.pw = new PrintWriter(myFile);
            pw.println(player1.getLevelReached()); //stores level reached into the data file
            pw.println(player1.getRewards()); //stores rewards left into the data file
            pw.println(player1.getMaxBreath());
            pw.println(player1.getCarryCapacity());
            pw.println(player1.getName()); //stores name into the data file
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found");
        }
    }

}
