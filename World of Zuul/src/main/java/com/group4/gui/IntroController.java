/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gui;

import com.group4.gameLogic.GameText;
import com.group4.gameLogic.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author mikai
 */
public class IntroController {
    
    @FXML // fx:id="textFieldIntro"
    private TextArea textFieldIntro;
    
    @FXML
    private Button bIUnderstandIntro;

    @FXML
    public void initialize() {
        textFieldIntro.setText("Hej dette er intro teksten"); //PrintWelcome method should be here
    }
    
    @FXML
    void handleIUnderstandIntroButtonAction(ActionEvent event) {
		App.toggleUI();
    }
    
}
