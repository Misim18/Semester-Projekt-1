/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gui;

import com.group4.gameLogic.Text;
import com.group4.gameLogic.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author mikai
 */
public class DeathController {
    
    @FXML // fx:id="levelReachedText"
    private TextArea levelReachedText;
    
    @FXML
    private Button bBackToStart;

    @FXML
    public void initialize() {
        //levelReachedText.setText("level reached here" + player1.getLevelReached()); 
    }
    
    @FXML
    void handlehandleBackToStartButtonAction(ActionEvent event) {
		App.toggleUI();
    }
    
}
