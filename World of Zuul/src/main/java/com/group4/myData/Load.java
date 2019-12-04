/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.myData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikai
 */
public class Load {

    File myFile = new File("C:\\Users\\mikai\\OneDrive\\Documentos\\NetBeansProjects\\Semester-Projekt-1\\Semester-Projekt-1\\data.txt");

    Scanner reader;

    public void LoadGame() {
        try {
            this.reader = new Scanner(myFile);
            System.out.println(reader.nextLine());
            System.out.println(reader.nextLine());
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
