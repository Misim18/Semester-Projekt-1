/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.myData;
import com.group4.gameLogic.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikai
 */
public class Save {

    File myFile = new File("data.txt"); //Data file placement

    PrintWriter pw;

    public void SaveGame(Character player1) {
        try {
            this.pw = new PrintWriter(myFile);
            //Remember the save order has to be the same as the load order
            pw.println(player1.getLevelReached()); //stores level reached into the data file
            pw.println(player1.getRewards()); //stores rewards left into the data file
			pw.println(player1.getBreath());
			pw.println(player1.getCarryCapacity());
            pw.println(player1.getName()); //stores name into the data file
            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found");
        }
    }

}
