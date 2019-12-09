package com.group4.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.group4.gameLogic.Collectables;
import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import com.group4.gameLogic.Game;
import com.group4.gameLogic.Room;
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
    Image sharkRight, sharkLeft, diver, foodWrapper, straw, fork, knife, spoon, bottle, bottleCap, bag, lid, cup, emptyWater, boat1, boat2, boat3, characterLastStep;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadImage();
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

        //Places diver on new position);
        setImageViewImage(App.game.player1.getCoordinateX(), App.game.player1.getCoordinateY(), diver);

        if (App.game.getOldRoom().getCoordinateY() == 0) {
            if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2 - 1) {
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), boat1);
            } else if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2) {
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), boat2);
            } else if (App.game.getOldRoom().getCoordinateX() == Game.getLimitX() / 2 + 1) {
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), boat3);
            } else {
                setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), straw);
            }
        } else {
            setImageViewImage(App.game.getOldRoom().getCoordinateX(), App.game.getOldRoom().getCoordinateY(), emptyWater);
        }

        for (int i = 0; i < Room.getHostilesActive().size() - 1; i++) {
            if (Room.getHostilesActive().get(i).getCoordinateX() < App.game.getLimitX() && Room.getHostilesActive().get(i).getCoordinateX() >= 0 && Room.getHostilesActive().get(i).getCoordinateY() < App.game.getLimitY()) {
                if (Room.getHostilesActive().get(i).getDirectionX() == 1) {
                    setImageViewImage(Room.getHostilesActive().get(i).getCoordinateX(), Room.getHostilesActive().get(i).getCoordinateY(), sharkRight);
//Place RIGHT facing shark on grid element x(Room.getHostilesActive().get(i).getCoordinateX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
                } else if (Room.getHostilesActive().get(i).getDirectionX() == -1) {
                    setImageViewImage(Room.getHostilesActive().get(i).getCoordinateX(), Room.getHostilesActive().get(i).getCoordinateY(), sharkLeft);
//Place LEFT facing shark on grid element x(Room.getHostilesActive().get(i).getCoordinateX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
                }
                if (App.game.getGrid()[Room.getHostilesActive().get(i).getCoordinateX()][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() == null) {
                    setImageViewImage((Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX()), Room.getHostilesActive().get(i).getCoordinateY(), emptyWater);
//Place EmptyGrid on grid element x((Room.getHostilesActive().get(i).getCoordinateX()-Room.getHostilesActive().get(i).getDirectionX()) & y(Room.getHostilesActive().get(i).getCoordinateY());
                } else if (App.game.getGrid()[Room.getHostilesActive().get(i).getCoordinateX()][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable() != null) {
                    String type = App.game.getGrid()[Room.getHostilesActive().get(i).getCoordinateX()][Room.getHostilesActive().get(i).getCoordinateY()].getCollectable().getName();
                    setImageViewImage((Room.getHostilesActive().get(i).getCoordinateX() - Room.getHostilesActive().get(i).getDirectionX()), Room.getHostilesActive().get(i).getCoordinateY(), cup);
//Place ("type") Collectable on grid element x((Room.getHostilesActive().get(i).getCoordinateX()-Room.getHostilesActive().get(i).getDirectionX()) & y(Room.getHostilesActive().get(i).getCoordinateY())
                }
            }
        }
    }

    public void printInitialUI() {

        for (int x = 0; x < Game.getLimitX(); x++) {
            VBox test = new VBox();
            for (int y = 0; y < Game.getLimitY(); y++) {
                if (y == 0) {
                    if (x == Game.getLimitX() / 2 - 1) {
                        test.getChildren().add(createImageView(boat1, x, y));
                    } else if (x == Game.getLimitX() / 2) {
                        test.getChildren().add(createImageView(boat2, x, y));
                    } else if (x == Game.getLimitX() / 2 + 1) {
                        test.getChildren().add(createImageView(boat3, x, y));
                    } else {
                        test.getChildren().add(createImageView(straw, x, y)); // above water
                    }
                } else if (App.game.getGrid()[x][y].getCollectable() != null) { //is collectable 
                    test.getChildren().add(createImageView(bottleCap, x, y));
                } else if (App.game.getGrid()[x][y].getCollectable() == null) { //no collectable
                    test.getChildren().add(createImageView(emptyWater, x, y));
                }
            }

            hboxRoom.getChildren().add(test);
        }

        setImageViewImage(Game.getLimitX() / 2, 1, diver);

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

    public void loadImage() {
        try {
            sharkRight = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
            sharkLeft = new Image(getClass().getResource("shark_resize_100_100.png").toExternalForm());
            diver = new Image(getClass().getResource("diver.png").toExternalForm());
            foodWrapper = new Image(getClass().getResource("food_wrapper.png").toExternalForm());
            straw = new Image(getClass().getResource("plastic_straw.png").toExternalForm());
            spoon = new Image(getClass().getResource("plastic_spoon.png").toExternalForm());
            bottle = new Image(getClass().getResource("plastic_bottle.png").toExternalForm());
            bottleCap = new Image(getClass().getResource("bottle_cap.png").toExternalForm());
            bag = new Image(getClass().getResource("plastic_bag.png").toExternalForm());
            lid = new Image(getClass().getResource("plastic_lid.png").toExternalForm());
            cup = new Image(getClass().getResource("plastic_cup.png").toExternalForm());
            emptyWater = new Image(getClass().getResource("empty_water.png").toExternalForm());
            boat1 = new Image(getClass().getResource("boat_1.png").toExternalForm());
            boat2 = new Image(getClass().getResource("boat_2.png").toExternalForm());
            boat3 = new Image(getClass().getResource("boat_3.png").toExternalForm());
        } catch (Exception e) {
            System.out.println("Naming is wrong" + e.toString());
        }
    }
}
