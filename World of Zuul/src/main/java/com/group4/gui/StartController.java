package com.group4.gui;

import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;

public class StartController {

    @FXML
    private TextField textFieldPlayerName;
    @FXML
    private Text textLevel;
    @FXML
    private Text textRewards;
    @FXML
    private Text textBreath;
    @FXML
    private Text textInventory;

    @FXML
    private Button bLoad;

    @FXML
    private Button bPlay;

    @FXML
    private Button bScoreboard;

    @FXML
    void handleScoreboardButtonAction(ActionEvent event) {
		showAlertWithNotImplemented();
    }

    @FXML
    void handleLoadButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.LOAD, null));
		textFieldPlayerName.setText(App.game.player1.getName());
		textLevel.setText(""+App.game.player1.getLevelReached());
		textRewards.setText(""+App.game.player1.getRewards());
		textBreath.setText(""+App.game.player1.getMaxBreath());
		textInventory.setText(""+App.game.player1.getCarryCapacity());
    }

    @FXML
    void handlePlayButtonAction(ActionEvent event) {
		if(textFieldPlayerName.equals("")){
			App.game.player1.setName("You Did Not Put In A Name");
		} else {
			App.game.player1.setName(textFieldPlayerName.getText());
		}
		App.toggleUI();
    }

	    // Show a Information Alert with default header Text
    private void showAlertWithNotImplemented() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("This is not implemented: yet");

        // alert.setHeaderText("Results:");
        alert.setContentText("This is not implemented: yet");
        alert.showAndWait();
    }
}
