package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.group4.gameLogic.Collectables;
import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import com.group4.gameLogic.Game;
import com.group4.gameLogic.Room;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    private Button bQuit;
    @FXML
    private Label labelHealth;
    @FXML
    private Label labelBreath;
    @FXML
    private Label labelLevel;
    //Image sharkRight, sharkLeft, diver, foodWrapper, straw, fork, knife, spoon, bottle, bottleCap, bag, lid, cup, emptyWater, boat1, boat2, boat3;

    private HashMap<String, Image> imageHash = new HashMap<String, Image>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //loadImage();
        loadImage2();
        listViewInventory.setItems(App.game.player1.getInventory());
        //updateUI();
        if (App.firstTimeInit()) {
            addKeyEventScene();
        }
        printInitialUI();
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
		labelBreath.setText("" + App.game.player1.getBreath());

        //Places diver on new position);

        //Toggles death screen if player death
        if (App.game.player1.getLife() <= 0) {
            App.toggleDeathUI();
        }


        //setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), imageHash.get("diver"));


        if (App.game.player1.getCoordinateY() == 0) {  //if the player IS on the upper grid
            if (App.game.player1.getCoordinateX() == Game.getLimitX() / 2 - 1) {  //where boat1 is
                setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), imageHash.get("boat1diver")); //<-- boat_1
            } else if (App.game.player1.getCoordinateX() == Game.getLimitX() / 2) { //where boat2 is
                setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), imageHash.get("boat2diver")); //<-- boat_2
            } else if (App.game.player1.getCoordinateX() == Game.getLimitX() / 2 + 1) { //where boat3 is
                setImageViewImage(App.game.player1.getCoordinateX(),App.game.player1.getCoordinateY(), imageHash.get("boat3diver")); //<-- boat_3
            } else { //water line
                setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), imageHash.get("aboveWater")); //<-- replace with water line
            }
        } else { //if none of the above, just put emptyWater
            setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), imageHash.get("diver"));
        }

        if (/*App.game.getOldRoom()!=null &&*/ App.game.getOldRoom().getCoordinateY() == 0) {  //if the player WAS on the upper grid
            if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2 - 1) {  //where boat1 is
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), imageHash.get("boat1"));
            } else if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2) { //where boat2 is
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), imageHash.get("boat2"));
            } else if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2 + 1) { //where boat3 is
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), imageHash.get("boat3"));
            } else { //water line
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), imageHash.get("oceanTop")); //<-- replace with water line
            }
        } else { //if none of the above, just put emptyWater
            //if (App.game.getOldRoom()!=null){
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), imageHash.get("emptyWater"));
            //}
        }

        //remove expired sharks
        for (int i = 0; i < 2; i++) {  //To check index[0] & index[gameLimitX-1]
            for (int y = 2; y < App.game.getLimitY(); y++) { // Given that the first two rows are shark free, no need to check
                if (i == 0) { //at left grid boundry
                    if (((ImageView) hboxRoom.lookup("#x" + 0 + "y" + y)).getImage() == imageHash.get("sharkLeft")) { //and there's a shark going left
                        if (App.game.getGrid()[0][y].getCollectable() != null) { //code to check for item
                            setImageViewImage(0, y, imageHash.get(App.game.getGrid()[0][y].getCollectable().getName())); //<-- correct item
                        } else {
                            setImageViewImage(0, y, imageHash.get("emptyWater"));
                        }
                    }
                } else if (i == 1) { //at right grid boundry
                    if (((ImageView) hboxRoom.lookup("#x" + (App.game.getLimitX() - 1) + "y" + y)).getImage() == imageHash.get("sharkRight")) { //and there's a shark going right
                        if (App.game.getGrid()[App.game.getLimitX() - 1][y].getCollectable() != null) { //code to check for item
                            setImageViewImage((App.game.getLimitX() - 1), y, imageHash.get(App.game.getGrid()[App.game.getLimitX() - 1][y].getCollectable().getName())); //<-- correct item
                        } else {
                            setImageViewImage((App.game.getLimitX() - 1), y, imageHash.get("emptyWater"));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < Room.getHostilesActive().size(); i++) { //go through all the Hostiles
            if (Room.getHostilesActive().get(i).getCoordinateX() < App.game.getLimitX() && Room.getHostilesActive().get(i).getCoordinateX() >= 0 && Room.getHostilesActive().get(i).getCoordinateY() < App.game.getLimitY()) { //if the shark is INSIDE the grid
                if (Room.getHostilesActive().get(i).getDirectionX() == 1) {  //and it's facing right
                    setImageViewImage(Room.getHostilesActive().get(i).getCoordinateX(), Room.getHostilesActive().get(i).getCoordinateY(), imageHash.get("sharkRight"));
                    //Place RIGHT facing shark on it's coordinates
                } else if (Room.getHostilesActive().get(i).getDirectionX() == -1) { //if it's facing left
                    setImageViewImage(Room.getHostilesActive().get(i).getCoordinateX(), Room.getHostilesActive().get(i).getCoordinateY(), imageHash.get("sharkLeft"));
                    //Place LEFT facing shark on it's coordinates
                }
                if (Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX() >= 0 && Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX() < Game.getLimitX()) { // if the shark is "legal" aka not on it's starting pos
                    if (App.game.getGrid()[(Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX())][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() == null) { //if the sharks old locations DOES NOT have a collectable
                        setImageViewImage((Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX()), Room.getHostilesActive().get(i).getCoordinateY(), imageHash.get("emptyWater"));
                    } else if (App.game.getGrid()[(Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX())][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() != null) { //if the sharks old locations DOES  have a collectable
                        //String type = App.game.getGrid()[(Room.getHostilesActive().get(i).getCoordinateX()- Room.getHostilesActive().get(i).getDirectionX())][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable().getName();
                        setImageViewImage((Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX()), Room.getHostilesActive().get(i).getCoordinateY(), imageHash.get(App.game.getGrid()[(Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX())][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable().getName()));
                        //Place ("type") Collectable on grid element x((Room.getHostilesActive().get(i).getCoordinateX()-Room.getHostilesActive().get(i).getDirectionX()) & y(Room.getHostilesActive().get(i).getCoordinateY())
                    }
                }
            }
        }
    }

    public void printInitialUI() {

        hboxRoom.setAlignment(Pos.CENTER);

        for (int x = 0; x < Game.getLimitX(); x++) {
            VBox test = new VBox();
            for (int y = 0; y < Game.getLimitY(); y++) {
                if (y == 0) {
                    if (x == Game.getLimitX() / 2 - 1) {
                        test.getChildren().add(createImageView(imageHash.get("boat1"), x, y));
                    } else if (x == Game.getLimitX() / 2) {
                        test.getChildren().add(createImageView(imageHash.get("boat2"), x, y));
                    } else if (x == Game.getLimitX() / 2 + 1) {
                        test.getChildren().add(createImageView(imageHash.get("boat3"), x, y));
                    } else {
                        test.getChildren().add(createImageView(imageHash.get("oceanTop"), x, y)); // above water
                    }
                } else if (App.game.getGrid()[x][y].getCollectable() != null) { //is collectable
                    //test.getChildren().add(createImageView(cup, x, y));
                    test.getChildren().add(createImageView(imageHash.get(App.game.getGrid()[x][y].getCollectable().getName()), x, y));
                } else if (App.game.getGrid()[x][y].getCollectable() == null) { //no collectable
                    test.getChildren().add(createImageView(imageHash.get("emptyWater"), x, y));
                }
            }

            hboxRoom.getChildren().add(test);
        }

        setImageViewImage(Game.getLimitX() / 2, 1, imageHash.get("diver"));

    }

    public void setImageViewImage(int x, int y, Image img) {
        ((ImageView) hboxRoom.lookup("#x" + x + "y" + y)).setImage(img);
    }

    public ImageView createImageView(Image type, int x, int y) {
        ImageView imageViewRoom = new ImageView(type);
        imageViewRoom.setFitHeight(619 / Game.getLimitY());
        imageViewRoom.setPreserveRatio(true);
        imageViewRoom.setSmooth(true);
        imageViewRoom.setCache(true);
        imageViewRoom.setId("x" + x + "y" + y);

        return imageViewRoom;
    }

    public Image getImageHash(String type){
        return imageHash.get(type);
    }

    public void addKeyEventScene() {
        App.scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.S) {
                App.game.goRoom(new Command(CommandWord.GO, "down"));
            	updateUI();
            }
            if (key.getCode() == KeyCode.W) {
                App.game.goRoom(new Command(CommandWord.GO, "up"));
            	updateUI();
            }
            if (key.getCode() == KeyCode.A) {
                App.game.goRoom(new Command(CommandWord.GO, "left"));
            	updateUI();
            }
            if (key.getCode() == KeyCode.D) {
                App.game.goRoom(new Command(CommandWord.GO, "right"));
            	updateUI();
            }
            if (key.getCode() == KeyCode.Q) {
                App.closeGame();
            	updateUI();
            }
            if (key.getCode() == KeyCode.T) {
                App.toggleUI();
            }
            if (key.getCode() == KeyCode.C) {
                App.game.processCommand(new Command(CommandWord.CHEAT, "getAllItem"));
            	updateUI();
            }
        });
    }

//    public void loadImage() {
//        try {
//            sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
//            sharkLeft = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
//            diver = new Image(getClass().getResource("diver.png").toExternalForm());
////            foodWrapper = new Image(getClass().getResource("food_wrapper.png").toExternalForm());
//            straw = new Image(getClass().getResource("plastic_straw.png").toExternalForm());
////            spoon = new Image(getClass().getResource("plastic_spoon.png").toExternalForm());
////            bottle = new Image(getClass().getResource("plastic_bottle.png").toExternalForm());
//            bottleCap = new Image(getClass().getResource("bottle_cap.png").toExternalForm());
////            bag = new Image(getClass().getResource("plastic_bag.png").toExternalForm());
////            lid = new Image(getClass().getResource("plastic_lid.png").toExternalForm());
//            cup = new Image(getClass().getResource("plastic_cup.png").toExternalForm());
//            emptyWater = new Image(getClass().getResource("empty_water.png").toExternalForm());
//            boat1 = new Image(getClass().getResource("boat_1.png").toExternalForm());
//            boat2 = new Image(getClass().getResource("boat_2.png").toExternalForm());
//            boat3 = new Image(getClass().getResource("boat_3.png").toExternalForm());
//        } catch (Exception e) {
//            System.out.println("Naming is wrong" + e.toString());
//        }
//    }

    public void loadImage2() {
        try {
            imageHash.put("sharkRight", new Image(getClass().getResource("shark_right.jpg").toExternalForm()));
            imageHash.put("sharkLeft", new Image(getClass().getResource("shark_left.jpg").toExternalForm()));
            imageHash.put("diver", new Image(getClass().getResource("diver.jpg").toExternalForm()));
            imageHash.put("Food Wrapper", new Image(getClass().getResource("food_wrapper.jpg").toExternalForm()));
            imageHash.put("Plastic Straw", new Image(getClass().getResource("plastic_straw.jpg").toExternalForm()));
            imageHash.put("Plastic Knife", new Image(getClass().getResource("plastic_knife.jpg").toExternalForm()));
            imageHash.put("Plastic Spoon", new Image(getClass().getResource("plastic_spoon.jpg").toExternalForm()));  
            imageHash.put("Plastic Bottle", new Image(getClass().getResource("plastic_bottle.jpg").toExternalForm())); //<-- got to here safely
            imageHash.put("Plastic Bottle Cap", new Image(getClass().getResource("bottle_cap.jpg").toExternalForm()));
            imageHash.put("Plastic Bag", new Image(getClass().getResource("plastic_bag.jpg").toExternalForm())); 
            imageHash.put("Plastic Lid", new Image(getClass().getResource("plastic_lid.jpg").toExternalForm()));
            imageHash.put("Plastic Cup", new Image(getClass().getResource("plastic_cup.jpg").toExternalForm())); 
            imageHash.put("Plastic Plate", new Image(getClass().getResource("Plastic_plate.jpg").toExternalForm()));
            imageHash.put("emptyWater", new Image(getClass().getResource("empty_water.jpg").toExternalForm()));
            imageHash.put("boat1", new Image(getClass().getResource("boat_1.jpg").toExternalForm()));
            imageHash.put("boat2", new Image(getClass().getResource("boat_2.jpg").toExternalForm()));
            imageHash.put("boat3", new Image(getClass().getResource("boat_3.jpg").toExternalForm()));
            imageHash.put("boat1diver", new Image(getClass().getResource("boat_1_diver.jpg").toExternalForm()));
            imageHash.put("boat2diver", new Image(getClass().getResource("boat_2_diver.jpg").toExternalForm()));
            imageHash.put("boat3diver", new Image(getClass().getResource("boat_3_diver.jpg").toExternalForm()));
            imageHash.put("oceanTop", new Image(getClass().getResource("ocean_top.jpg").toExternalForm()));
            imageHash.put("aboveWater", new Image(getClass().getResource("ocean_top_with_diver.jpg").toExternalForm()));
            imageHash.put("Plastic Fork", new Image(getClass().getResource("plastic_fork.jpg").toExternalForm()));
    } catch (Exception e){
            System.out.println("loadImage2 returned following error: " + e.getMessage());
    }
    }
}
