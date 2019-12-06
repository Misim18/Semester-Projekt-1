package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.group4.gameLogic.Collectables;
import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import com.group4.gameLogic.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameController implements Initializable {
    @FXML
    private ListView<Collectables> listViewInventory;
	@FXML
	private HBox hboxRoom;
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
	Image sharkRight,sharkLeft,playerImage,foodWrapper,straw,fork,knife,spoon,bottle,bottleCap,bag,Lid,Cup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewInventory.setItems(App.game.player1.getInventory());
		updateUI();
        if (App.firstTimeInit()) {
            addKeyEventScene();
        }
		for(int i=0; i<Game.getLimitX(); i++){
			VBox test = new VBox();
			for (int j = 0; j <Game.getLimitY(); j++) {
				ImageView imageViewRoom = new ImageView(image);
				imageViewRoom.setFitWidth(80);
				imageViewRoom.setPreserveRatio(true);
				imageViewRoom.setSmooth(true);
				imageViewRoom.setCache(true);
				test.getChildren().add(imageViewRoom);
			}
			hboxRoom.getChildren().add(test);
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
        App.game.processCommand(new Command(CommandWord.LOAD, null));
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
        App.game.processCommand(new Command(CommandWord.SAVE, null));
    }

    @FXML
    void handleQuitButtonAction(ActionEvent event) {
        App.closeGame();
    }

    public void updateUI() {
        labelLevel.setText("" + App.game.player1.getLevelReached());
        labelHealth.setText("" + App.game.player1.getLife());

        //PlacePlayer(currentRoom(x,y));
        //Place.EmptyGrid(OldRoom(x,y));
        //for (int i = 0; i < Room.getHostilesActive().size(); i++) {
        //    if (Room.getHostilesActive().get(i).getCoordinateX() <= App.game.getLimitX() && Room.getHostilesActive().get(i).getCoordinateY() <= App.game.getLimitY()) {
        //        if (Room.getHostilesActive().get(i).getDirectionX() == 1) {
        //            //Place RIGHT facing shark on grid element x(Room.getHostilesActive().get(i).getCoordinateX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
        //        } else if (Room.getHostilesActive().get(i).getDirectionX() == -1) {
        //            //Place LEFT facing shark on grid element x(Room.getHostilesActive().get(i).getCoordinateX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
        //        }
        //    }
        //    if (App.game.getGrid()[Room.getHostilesActive().get(i).getCoordinateX()][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() == null) {
        //        //Place EmptyGrid on grid element x((Room.getHostilesActive().get(i).getCoordinateX()-Room.getHostilesActive().get(i).getDirectionX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
        //    } else if (App.game.getGrid()[Room.getHostilesActive().get(i).getCoordinateX()][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() != null) {
        //        //Place (correct) Collectable on grid element x((Room.getHostilesActive().get(i).getCoordinateX()-Room.getHostilesActive().get(i).getDirectionX()) & y(Room.getHostilesActive().get(i).getCoordinateY())
        //    } else {
        //        //Do nothing?
        //    }
        //}

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

	Image sharkRight,sharkLeft,player,foodWrapper,straw,fork,knife,spoon,bottle,bottleCap,bag,Lid,Cup;
	public void loadImage(){
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkLeft = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		playerImage = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
		sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
	}
}
