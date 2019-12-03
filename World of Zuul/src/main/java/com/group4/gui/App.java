package com.group4.gui;

import com.group4.gameLogic.Command;
import com.group4.gameLogic.CommandWord;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

import com.group4.gameLogic.Game;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    static Game game;
    private static Scene scene;

    public static void injectGame(Game game1) {
        game = game1;
    }

    public static Game getGame() {
        return game;
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("primary"), 1280, 800);
        stage.setScene(scene);
        addKeyEventScene();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void startFX(String[] args) {
        launch(args);
    }

    public void addKeyEventScene() {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.S) {
                System.out.println("You pressed down");
                App.game.goRoom(new Command(CommandWord.GO, "down"));
            }
            if (key.getCode() == KeyCode.W) {
                System.out.println("You pressed up");
                App.game.goRoom(new Command(CommandWord.GO, "up"));
            }
            if (key.getCode() == KeyCode.A) {
                System.out.println("You pressed left");
                App.game.goRoom(new Command(CommandWord.GO, "left"));
            }
            if (key.getCode() == KeyCode.D) {
                System.out.println("You pressed right");
                App.game.goRoom(new Command(CommandWord.GO, "right"));
            }
        });
    }

}
