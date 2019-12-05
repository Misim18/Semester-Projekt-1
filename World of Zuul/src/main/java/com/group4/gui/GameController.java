package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.group4.gameLogic.Collectables;
import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.PrintStream;

public class GameController implements Initializable {
    @FXML
    private TextArea console;
    private PrintStream ps ;
	@FXML
    private ListView<Collectables> listViewInventory;
	private ObservableList<Collectables> inventory;

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
	@FXML
	private Label labelHealth;
	@FXML
	private Label labelLevel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
		ps = new PrintStream(new Console(console));
		System.setOut(ps);
        System.setErr(ps);
		inventory = FXCollections.observableArrayList();
		updateUI();
		if(App.firstTimeInit()){
			addKeyEventScene();
		}
    }
	// GO commands implement
    @FXML
    void handleUpButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.GO, "up"));
		updateUI();
    }

    @FXML
    void handleDownButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.GO, "down"));
		updateUI();
    }

    @FXML
    void handleLeftButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.GO, "left"));
		updateUI();
    }

    @FXML
    void handleRightButtonAction(ActionEvent event) {
		App.game.processCommand(new Command(CommandWord.GO, "right"));
		updateUI();
    }


    @FXML
    void handleLoadButtonAction(ActionEvent event) {
        App.game.processCommand(new Command(CommandWord.LOAD, null ));
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
        App.game.processCommand(new Command(CommandWord.SAVE, null));
    }

    @FXML
    void handleQuitButtonAction(ActionEvent event) {
		App.closeGame();
    }


	public void updateUI(){
		labelLevel.setText("" + App.game.player1.getLevelReached());
		labelHealth.setText("" + App.game.player1.getLife());
		updateInventory();
	}

    public void addKeyEventScene() {
        App.scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.S) {
                App.game.goRoom(new Command(CommandWord.GO, "down"));
            }
            if (key.getCode() == KeyCode.W) {
                App.game.goRoom(new Command(CommandWord.GO, "up"));
            }
            if (key.getCode() == KeyCode.A) {
                App.game.goRoom(new Command(CommandWord.GO, "left"));
            }
            if (key.getCode() == KeyCode.D) {
                App.game.goRoom(new Command(CommandWord.GO, "right"));
            }
            if (key.getCode() == KeyCode.Q) {
				App.closeGame();
            }
            if (key.getCode() == KeyCode.T) {
				App.toggleUI();
            }
            if (key.getCode() == KeyCode.C) {
				App.game.processCommand(new Command(CommandWord.CHEAT, "getAllItem"));
            }
			updateUI();
        });
    }

	// Needs to be made more performent. right now is not good.
	public void updateInventory(){
		if(App.game.player1.inventoryUpdated()){
			inventory.clear();
			//inventory.addAll(App.game.player1.getInventory());
			for (Collectables collectables : App.game.player1.getInventory()) {
				inventory.add(collectables);
				System.out.println(inventory);
			}
			listViewInventory.setItems(inventory);
		System.out.println("Inventory updated");
		} else {
			System.out.println("Inventory not updated");
		}

	}
}
