/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author kkmp
 */
public class PrimaryController implements Initializable {

    @FXML
    private TitledPane ColorPicker;
    @FXML
    private RadioButton rbBlue;
    @FXML
    private RadioButton rbRed;
    @FXML
    private RadioButton rbGreen;
    @FXML
    private RadioButton rbBlack;
    @FXML
    private RadioButton rbSmall;
    @FXML
    private RadioButton rbMedium;
    @FXML
    private RadioButton rbBig;
    @FXML
    private Button bUndo;
    @FXML
    private Button bClear;
    @FXML
    private Label handleHejLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void handleBlueRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleRedRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleGreenRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleBlackRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleSamllRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleMediumRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleBigRadioButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleUndoButtonAction(ActionEvent event) {
			handleHejLabel.setText("Kevin");

    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
    }
}
