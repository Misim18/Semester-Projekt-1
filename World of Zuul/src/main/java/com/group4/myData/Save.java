/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.myData;

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

    File myFile = new File("C:\\Users\\mikai\\OneDrive\\Documentos\\NetBeansProjects\\Semester-Projekt-1\\Semester-Projekt-1\\data.txt");

    PrintWriter pw;

    public void SaveGame(Character player) {
        try {
            this.pw = new PrintWriter(myFile);
            pw.println("Saved data from your game:");
            //pw.println("Character Level: " + player.getLevelReached());
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
