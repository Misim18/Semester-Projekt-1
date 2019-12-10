package com.group4.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.group4.gameLogic.Text;

public class DeathController {

    @FXML
    private Text levelReachedText;

    @FXML
    private Text textCourseOfDead;

    @FXML
    void bBacktoStart(ActionEvent event) {
		App.toggleIntroUI();


    }

    @FXML
    public void initialize() throws Exception {
		levelReachedText.setText(""+App.game.player1.getLevelReached());
		textCourseOfDead.setText(Text.causeOfDeath());

    }
}
