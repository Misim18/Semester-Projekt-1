package com.group4.gui;

import com.group4.gameLogic.GameText;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class IntroController {

    @FXML // fx:id="textFieldIntro"
    private TextArea textFieldIntro;

    @FXML
    private Button bIUnderstandIntro;

    @FXML
    public void initialize() {
        textFieldIntro.setText(GameText.introLineUI());
    }

    @FXML
    void handleIUnderstandIntroButtonAction(ActionEvent event) {
        App.swithToStart();
    }

}
