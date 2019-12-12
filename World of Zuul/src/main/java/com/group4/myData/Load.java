/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.myData;
import com.group4.gameLogic.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mikai
 */
public class Load {

    File myFile = new File("data.txt"); //Data file placement

    Scanner reader;

    public void LoadGame(Character player1) {
        try {
            this.reader = new Scanner(myFile);
            //Remember the load order has to be the same as the save order
            player1.setLevelReached(reader.nextInt()); //loads level reached from the data file
            player1.setRewards(reader.nextInt()); //loads rewards left from the data file
			player1.setBreath(reader.nextInt());
			player1.setCarryCapacity(reader.nextInt());
			reader.nextLine(); //Fix so it jumps to the nextline
            player1.setName(reader.nextLine()); //loads name from the data file
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File was not found");
        }
    }

}
