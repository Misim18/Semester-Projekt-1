/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gui;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author mikai
 */
public class DeathController {
 
    @FXML
    private Button bBackToStart;

    @FXML
    private Text levelReachedText;
    
    public void initialize() {
        levelReachedText.setText("Hej dette er intro teksten"); //PrintWelcome method should be here
    }

    @FXML
    void handleBackToStartButtonAction(ActionEvent event) {
        App.toggleUI();
    }

}

    

