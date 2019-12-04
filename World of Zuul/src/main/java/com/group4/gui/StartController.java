package com.group4.gui;

import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StartController {

    @FXML
    private TextField textFieldPlayerName;

    @FXML
    private TextField textFieldPlayerStat1;

    @FXML
    private TextField textFieldPlayerStat2;

    @FXML
    private TextField textFieldPlayerStat3;

    @FXML
    private Button bLoad;

    @FXML
    private Button bPlay;

    @FXML
    private Button bScoreboard;

    @FXML
    void handleScoreboardButtonAction(ActionEvent event) {
    }

    @FXML
    void handleLoadButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.LOAD, null));
		App.toggleUI();
    }

    @FXML
    void handlePlayButtonAction(ActionEvent event) {
		App.game.player1.setName("Temp Name");
		App.toggleUI();
    }

}
