/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author kkmp
 */
public class PrimaryController implements Initializable {
    @FXML
    private Button bUp;
    @FXML
    private Button bDown;
    @FXML
    private Button bLeft;
    @FXML
    private Button bRight;
    @FXML
    private Button bSave;
    @FXML
    private Button bLoad;
    @FXML
    private Button bQuit;

	// GO commands implement
    @FXML
    void handleUpButtonAction(ActionEvent event) {
		App.game.goRoom(new Command(CommandWord.GO, "up"));
    }

    @FXML
    void handleDownButtonAction(ActionEvent event) {
		App.game.goRoom(new Command(CommandWord.GO, "down"));
    }

    @FXML
    void handleLeftButtonAction(ActionEvent event) {
		App.game.goRoom(new Command(CommandWord.GO, "left"));
    }

    @FXML
    void handleRightButtonAction(ActionEvent event) {
		App.game.goRoom(new Command(CommandWord.GO, "right"));
    }


    @FXML
    void handleLoadButtonAction(ActionEvent event) {

    }

    @FXML
    void handleQuitButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.QUIT, null));
    }


    @FXML
    void handleSaveButtonAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
